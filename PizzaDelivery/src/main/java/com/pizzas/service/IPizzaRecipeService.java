package com.pizzas.service;

import com.pizzas.model.PizzaRecipe;
import com.pizzas.vo.PizzaRecipeVO;

public interface IPizzaRecipeService {

    public PizzaRecipeVO findAll();
    public PizzaRecipeVO save(PizzaRecipe pizzaRecipe);
    public PizzaRecipeVO delete(PizzaRecipe pizzaRecipe);
    
}
