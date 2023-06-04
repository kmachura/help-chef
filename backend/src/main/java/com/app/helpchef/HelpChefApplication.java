package com.app.helpchef;

import com.app.helpchef.Model.*;
import com.app.helpchef.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HelpChefApplication implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelpChefApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Users user = new Users();
        user.setEmail("johndoe@mail.com");
        user.setName("John");
        user.setSurname("Doe");
        user.setNick("jodo");

        usersRepository.save(user);

        Account account = new Account();
        account.setUser(user);
        account.setCreateDate(LocalDate.of(2023,1,1));

        accountRepository.save(account);

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName("Pomidor");
        ingredient.setAmount(200);
        ingredient.setUnit("gram");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setIngredientName("Mozarella");
        ingredient2.setAmount(250);
        ingredient2.setUnit("gram");

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setIngredientName("Bazylia");
        ingredient3.setAmount(50);
        ingredient3.setUnit("gram");

        ingredientRepository.save(ingredient);
        ingredientRepository.save(ingredient2);
        ingredientRepository.save(ingredient3);

        Comment comment = new Comment();
        comment.setNick(user);
        comment.setContent("Ta sałatka jest pyszna!");
        comment.setCommentDate(LocalDateTime.of(2023, 7, 10, 16, 10));

        commentRepository.save(comment);

        Recipe recipe = new Recipe();
        recipe.setRecipeName("Caprese");

        List<Ingredient> ingredienstList = new ArrayList<>();
        ingredienstList.add(ingredient);
        ingredienstList.add(ingredient2);
        ingredienstList.add(ingredient3);

        recipe.setIngredients(ingredienstList);

        recipe.setDescription("1. Potnij pimidora i mozarelle na plasterki i ułóż je jedno po drugim 2. Połóż bazylię na górę");
        recipe.setRate(4.9);
        recipe.setComment(comment);

        recipeRepository.save(recipe);

    }
}
