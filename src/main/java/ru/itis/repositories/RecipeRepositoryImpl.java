package ru.itis.repositories;

import ru.itis.form.CategoryForm;
import ru.itis.form.RecipeForm;
import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeRepositoryImpl implements RecipeRepository{



    private Connection connection;

    //language=sql
    private final String SQL_INSERT_INTO_RECIPE = "INSERT INTO recipes(name, description) VALUES (?, ?);";

    //language=sql
    private final String SQL_INSERT_INTO_RECIPE_CATEGORY = "INSERT INTO recipe_category(id_recipe, id_category) VALUES (?, ?);";

    //language=sql
    private final String SQL_INSERT_INTO_USER_RECIPE = "INSERT INTO user_recipe (id_recipe, id_user) VALUES (?, ?);";

    //language=sql
    private final String SQL_FIND_CATEGORIES = "SELECT * FROM categories ;";

    //language=sql
    private final String SQL_FIND_RECIPES = "SELECT * FROM recipes r left join recipe_category rc on r.id_recipe=rc.id_recipe left join user_recipe ur on r.id_recipe=ur.id_recipe left join images i on r.id_recipe = i.id_recipe order by ur.date_creation desc;";

    //language=sql
    private final String SQL_FIND_RECIPES_FOR_CATEGORY = "SELECT * FROM recipes r left join recipe_category rc on r.id_recipe=rc.id_recipe left join user_recipe ur on r.id_recipe=ur.id_recipe left join images i on r.id_recipe = i.id_recipe where (rc.id_category = ?) order by ur.date_creation desc;";

    public RecipeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CategoryForm> findCategories() {
        ResultSet resultSet = null;
        List<CategoryForm> categoryForms = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CATEGORIES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryForm cf = new CategoryForm();
                cf.setId(resultSet.getInt("id_categories"));
                cf.setName(resultSet.getString("name"));

                categoryForms.add(cf);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return categoryForms;
    }

    @Override
    public List<RecipeForm> findAll() {
        ResultSet resultSet = null;
        List<RecipeForm> recipeForms = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_RECIPES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RecipeForm rf = new RecipeForm();
                rf.setId(resultSet.getInt("id_recipe"));
                rf.setTitle(resultSet.getString("name"));
                rf.setDescription(resultSet.getString("description"));
                rf.setDateCreation(resultSet.getDate("date_creation"));
                rf.setCategory(resultSet.getInt("id_category"));
                rf.setUser(resultSet.getInt("id_user"));

                String img = resultSet.getString("uuid_name");
                if(img!=null){
                    rf.setImage(img);
                }else {
                    rf.setImage("null");
                }
                recipeForms.add(rf);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return recipeForms;
    }

    @Override
    public List<RecipeForm> findRecipesForCategory(int id) {
        ResultSet resultSet = null;
        List<RecipeForm> recipeForms = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_RECIPES_FOR_CATEGORY);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RecipeForm rf = new RecipeForm();
                rf.setId(resultSet.getInt("id_recipe"));
                rf.setTitle(resultSet.getString("name"));
                rf.setDescription(resultSet.getString("description"));
                rf.setDateCreation(resultSet.getDate("date_creation"));
                rf.setCategory(resultSet.getInt("id_category"));
                rf.setUser(resultSet.getInt("id_user"));

                String img = resultSet.getString("uuid_name");
                if(img!=null){
                    rf.setImage(img);
                }else {
                    rf.setImage("null");
                }
                recipeForms.add(rf);
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return recipeForms;
    }

    @Override
    public Optional<RecipeForm> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RecipeForm save(RecipeForm recipeForm) {
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_RECIPE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, recipeForm.getTitle());
            preparedStatement.setString(2, recipeForm.getDescription());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                recipeForm.setId(resultSet.getInt("id_recipe"));
            }
            System.out.println(recipeForm.getId());
            System.out.println(recipeForm.getUser());
            System.out.println(recipeForm.getTitle());
            System.out.println(recipeForm.getCategory());
            System.out.println(recipeForm.getDescription());

            preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_RECIPE_CATEGORY);
            preparedStatement.setInt(1, recipeForm.getId());
            preparedStatement.setInt(2, recipeForm.getCategory());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_USER_RECIPE);
            preparedStatement.setInt(1, recipeForm.getId());
            preparedStatement.setInt(2, recipeForm.getUser());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                recipeForm.setDateCreation(resultSet.getDate("date_creation"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeForm;
    }

    @Override
    public void deleteById(Long id) {

    }
}
