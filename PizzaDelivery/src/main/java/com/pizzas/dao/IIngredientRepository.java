package com.pizzas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzas.model.Ingredient;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {

    
}
