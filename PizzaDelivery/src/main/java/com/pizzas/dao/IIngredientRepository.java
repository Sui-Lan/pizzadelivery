package com.pizzas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pizzas.model.Ingredient;
import com.pizzas.vo.IngredientVO;

@Repository
public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {

    @Query(value="SELECT * FROM ingredient WHERE name = ?1", nativeQuery=true)
    public List<Ingredient> findByName(String name);
}
