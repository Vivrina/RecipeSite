package ru.itis.services;

import ru.itis.form.CategoryForm;
import ru.itis.form.RecipeForm;
import ru.itis.repositories.RecipeRepository;

import java.util.List;

public class RecipeServiceImpl implements RecipeService{

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public RecipeForm addRecipe(RecipeForm rf){
        return recipeRepository.save(rf);
    }

    @Override
    public List<CategoryForm> findCategories() {
        return recipeRepository.findCategories();
    }

    @Override
    public List<RecipeForm> findRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<RecipeForm> findRecipesForCategory(int id) {
        return recipeRepository.findRecipesForCategory(id);
    }
}
