package com.pizzas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzas.model.PizzaRecipe;

@Repository
public interface IPizzaRecipeRepository extends JpaRepository<PizzaRecipe, Integer>{

}
