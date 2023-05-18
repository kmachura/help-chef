package com.app.helpchef.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredientId")
    private Long ingredientId;

    @Column(name = "ingredientName")
    private String ingredientName;

    @Column(name = "amount")
    private double amount;

    @Column(name = "unit")
    private String unit;
}
