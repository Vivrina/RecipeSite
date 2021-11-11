package ru.itis.repositories;

import ru.itis.form.ImageForm;
import ru.itis.models.User;

import java.sql.*;

public class ImageRepositoryImpl implements ImageRepository{
    private Connection connection;
    public ImageRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    //language=SQL
    private static final String SQL_SELECT_BY_RECIPE = "select * from images where id_recipe = ?;";

    //language=SQL
    private static final String SQL_INSERT_UPDATE = "insert into images (id_recipe, im_size, uuid_name) values(?, ?, ?) ON CONFLICT (id_recipe) DO UPDATE SET im_size = ?, uuid_name=?;";

    @Override
    public ImageForm find(int id) {
        ResultSet resultSet = null;
        ImageForm imageForm = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_RECIPE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                imageForm.setRecipe_id(resultSet.getInt("id_recipe"));
                imageForm.setSize(resultSet.getLong("im_size"));
                imageForm.setUuid_name(resultSet.getString("uuid_name"));
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return imageForm;
    }

    @Override
    public void save(ImageForm imageForm) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_UPDATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, imageForm.getRecipe_id());
            preparedStatement.setLong(2, imageForm.getSize());
            preparedStatement.setString(3,imageForm.getUuid_name());
            preparedStatement.setLong(4, imageForm.getSize());
            preparedStatement.setString(5,imageForm.getUuid_name());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
