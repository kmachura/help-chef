package com.app.helpchef.Controller;

import com.app.helpchef.Model.Ingredient;
import com.app.helpchef.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/ingredients")
public class IngedientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllRecipes() {
        return ingredientService.findAll();
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.createIngredient(ingredient);
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable long ingredientId) {
        return ResponseEntity.ok(ingredientService.findIngredientById(ingredientId));
    }

    @PutMapping("/editIngredient/{ingredientId}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable long ingredientId, @RequestBody Ingredient ingredientDetails) {
        return ResponseEntity.ok(ingredientService.updateIngredient(ingredientId, ingredientDetails));
    }

    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<HttpStatus> deleteIngredient(@PathVariable long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
