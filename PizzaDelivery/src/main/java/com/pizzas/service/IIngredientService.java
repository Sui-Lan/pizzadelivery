package com.pizzas.service;

import com.pizzas.model.Ingredient;
import com.pizzas.vo.IngredientVO;

public interface IIngredientService {

    public IngredientVO findAll();
    public IngredientVO findById(Integer id);
    public IngredientVO findByName(String name);
    public IngredientVO save(Ingredient ingredient);
    public IngredientVO update(Ingredient ingredient);
    public IngredientVO delete(Ingredient ingredient);
    
}
