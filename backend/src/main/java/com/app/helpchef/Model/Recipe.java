package com.app.helpchef.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeId")
    private Long recipeId;

    @Column(name = "recipeName")
    private String recipeName;

    @ElementCollection
    @Column(name = "ingredietns")
    private List<Ingredient> ingredients;

    @Column(name = "description")
    private String description;

    @Column(name = "rate")
    private double rate;

    @ManyToOne
    @JoinColumn(name = "commentId")
    private Comment comment;

}
