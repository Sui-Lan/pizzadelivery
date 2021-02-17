package com.pizzas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    
    @Id
    private Integer idIngredient;
    private String nameIngredient;
    private float stockQuantity;
    private Enum measureUnit;
    
}
