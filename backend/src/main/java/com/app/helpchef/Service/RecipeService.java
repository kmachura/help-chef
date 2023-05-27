package com.app.helpchef.Service;

import com.app.helpchef.Model.Recipe;
import com.app.helpchef.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe findRecipeById(long recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with id: " + " not exist"));
    }

    public Recipe updateRecipe(long recipeId, Recipe recipeDetails) {
        Recipe updateRecipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with id: " + " not exist"));

        updateRecipe.setRecipeName(recipeDetails.getRecipeName());
        updateRecipe.setIngredients(recipeDetails.getIngredients());
        updateRecipe.setDescription(recipeDetails.getDescription());
        updateRecipe.setRate(recipeDetails.getRate());

        return recipeRepository.save(updateRecipe);
    }

    public void deleteRecipe(long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with id: " + " not exist"));

        recipeRepository.delete(recipe);
    }
}
