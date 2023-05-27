package com.app.helpchef.Service;

import com.app.helpchef.Model.Ingredient;
import com.app.helpchef.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findIngredientById(long ingredientId) {
        return ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient with id: " + ingredientId + " not exist"));
    }

    public Ingredient updateIngredient(long ingredientId, Ingredient ingredientDetails) {
        Ingredient updateIngredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient with id: " + ingredientId + " not exist"));

        updateIngredient.setIngredientName(ingredientDetails.getIngredientName());
        updateIngredient.setAmount(ingredientDetails.getAmount());
        updateIngredient.setUnit(ingredientDetails.getUnit());

        return ingredientRepository.save(updateIngredient);
    }

    public void deleteIngredient(long ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient with id: " + ingredientId + " not exist"));

        ingredientRepository.delete(ingredient);
    }
}
