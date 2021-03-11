package com.pizzas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzas.PizzaDeliveryApplication;
import com.pizzas.dao.IPizzaRecipeRepository;
import com.pizzas.model.PizzaRecipe;
import com.pizzas.vo.PizzaRecipeVO;

@Service
public class PizzaRecipeServiceImp implements IPizzaRecipeService{

    Logger logger = LoggerFactory.getLogger(PizzaDeliveryApplication.class);
    
    @Autowired
    IPizzaRecipeRepository iPizzaRecipeRepository;
    
    PizzaRecipeVO pizzaRecipeVO;
    
    @Override
    public PizzaRecipeVO findAll() {
	List<PizzaRecipe>pizzaRecipeList = new ArrayList<PizzaRecipe>();
	pizzaRecipeVO = new PizzaRecipeVO("Ups error!", "0", pizzaRecipeList);
	try {
	    pizzaRecipeVO.setPizzaRecipeListVO(iPizzaRecipeRepository.findAll());
	    pizzaRecipeVO.setMessage(String.format("Se han encontrado %d registro(s)", pizzaRecipeVO.getPizzaRecipeListVO().size()));
	} catch (Exception e) {
	    logger.error("Try catch Error: PizzaRecipe findAll() not working", e);
	}
	return pizzaRecipeVO;
    }

    @Override
    public PizzaRecipeVO save(PizzaRecipe pizzaRecipe) {
	List<PizzaRecipe> pizzaRecipeList = new ArrayList<PizzaRecipe>();
	pizzaRecipeVO = new PizzaRecipeVO("Ups error!", "0", pizzaRecipeList);
	try {
	    iPizzaRecipeRepository.save(pizzaRecipe);
	    pizzaRecipeVO.setMessage(String.format("Se han encontrado %d registro(s)", pizzaRecipeVO.getPizzaRecipeListVO().size()));
	} catch (Exception e) {
	    logger.error("Try catch Error: PizzaRecipe save() not working", e);
	}
	return pizzaRecipeVO;
    }

    @Override
    public PizzaRecipeVO delete(PizzaRecipe pizzaRecipe) {
	List<PizzaRecipe> pizzaRecipeList = new ArrayList<PizzaRecipe>();
	pizzaRecipeVO = new PizzaRecipeVO("Ups error!", "0", pizzaRecipeList);
	try {
	    iPizzaRecipeRepository.delete(pizzaRecipe);
	    
	} catch (Exception e) {
	    logger.error("Try catch Error; PizzaRecipe delete() not working", e);
	}
	return pizzaRecipeVO;
    }


}
