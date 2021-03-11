package com.pizzas.vo;

import java.util.List;

import com.pizzas.model.PizzaRecipe;

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
public class PizzaRecipeVO {

    private String message;
    private String code;
    private List<PizzaRecipe> pizzaRecipeListVO;
    
}
