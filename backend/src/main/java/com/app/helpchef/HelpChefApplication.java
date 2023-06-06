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

        //1st recipe
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

        //2nd recipe
        Ingredient ingredient4 = new Ingredient();
        ingredient4.setIngredientName("Burak");
        ingredient4.setAmount(500);
        ingredient4.setUnit("gram");

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setIngredientName("Feta");
        ingredient5.setAmount(250);
        ingredient5.setUnit("gram");

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setIngredientName("Rukola");
        ingredient6.setAmount(300);
        ingredient6.setUnit("gram");

        ingredientRepository.save(ingredient4);
        ingredientRepository.save(ingredient5);
        ingredientRepository.save(ingredient6);

        Comment comment2 = new Comment();
        comment2.setNick(user);
        comment2.setContent("Najlepsza sałatka z buraków!");
        comment2.setCommentDate(LocalDateTime.of(2023, 7, 10, 16, 10));

        Comment comment3 = new Comment();
        comment3.setNick(user);
        comment3.setContent("Bardzo pyszne :)");
        comment3.setCommentDate(LocalDateTime.of(2023, 8, 11, 18, 15));

        commentRepository.save(comment2);
        commentRepository.save(comment3);

        Recipe recipe2 = new Recipe();
        recipe2.setRecipeName("Carpaccio z buraka");

        List<Ingredient> ingredienstList2 = new ArrayList<>();
        ingredienstList2.add(ingredient4);
        ingredienstList2.add(ingredient5);
        ingredienstList2.add(ingredient6);

        recipe2.setIngredients(ingredienstList2);

        recipe2.setDescription("1. Pokroić buraka i fete w kostkę 2. Dodać rukolę 3. Wszystko ze sobą wymieszać");
        recipe2.setRate(5);
        recipe2.setComment(comment2);
        //do to comments list

        recipeRepository.save(recipe2);

    }
}
