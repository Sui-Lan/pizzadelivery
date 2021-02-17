package com.pizzas.vo;

import java.util.ArrayList;
import java.util.List;

import com.pizzas.model.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IngredientVO {

    private String message;
    private String code;
    private List<Ingredient> IngredientList;
    
}
