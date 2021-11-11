package ru.itis.services;

import ru.itis.form.CategoryForm;
import ru.itis.form.RecipeForm;

import java.util.List;

public interface RecipeService {
    List<CategoryForm> findCategories();
    List<RecipeForm> findRecipes();
    RecipeForm addRecipe(RecipeForm rf);
    List<RecipeForm> findRecipesForCategory(int id);


}
