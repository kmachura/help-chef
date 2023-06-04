package com.app.helpchef.Controller;

import com.app.helpchef.Model.Recipe;
import com.app.helpchef.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long recipeId) {
        return ResponseEntity.ok(recipeService.findRecipeById(recipeId));
    }

    @PutMapping("/editRecipe/{recipeId}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable long recipeId, @RequestBody Recipe recipeDetails) {
        return ResponseEntity.ok(recipeService.updateRecipe(recipeId, recipeDetails));
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
