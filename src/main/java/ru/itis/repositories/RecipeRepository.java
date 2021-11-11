package ru.itis.repositories;


import ru.itis.form.CategoryForm;
import ru.itis.form.RecipeForm;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<RecipeForm>{
    List<CategoryForm> findCategories();
    List<RecipeForm> findRecipesForCategory(int id);
}
