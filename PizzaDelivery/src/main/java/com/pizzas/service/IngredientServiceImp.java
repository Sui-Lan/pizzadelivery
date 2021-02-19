package com.pizzas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzas.PizzaDeliveryApplication;
import com.pizzas.dao.IIngredientRepository;
import com.pizzas.model.Ingredient;
import com.pizzas.vo.IngredientVO;

@Service
public class IngredientServiceImp implements IIngredientService {

    private static final Logger logger = LoggerFactory.getLogger(PizzaDeliveryApplication.class);
    
    @Autowired
    IIngredientRepository iIngredientRepository;
    
    private IngredientVO ingredientVO;
    
    @Override
    public IngredientVO findAll() {
	List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	ingredientVO = new IngredientVO("Ups error!", "0", ingredientsList);
	try {
	    ingredientVO.setIngredientListVO(iIngredientRepository.findAll());
	    if(ingredientVO.getIngredientListVO().size() > 0) {
        	    ingredientVO.setMessage(String.format("Se han encontrado %d registro(s)", ingredientVO.getIngredientListVO().size()));
        	    ingredientVO.setCode("101");
	    } else ingredientVO.setMessage("Sorry, ingredients not found. Please try again");
	} catch (Exception e) {
	    logger.error("Try catch Error: findAll() not working", e);
	}
	return ingredientVO;
    }

    @Override
    public IngredientVO findById(Integer id) {
	List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	ingredientVO = new IngredientVO("Ups error! Ingredient id found!", "100", ingredientsList);
	try {
	    Ingredient ingredient = iIngredientRepository.findById(id).get();
	    ingredientVO.getIngredientListVO().add(ingredient);
	    ingredientVO.setMessage("Ingredient id found!");
	    ingredientVO.setCode("101");
	} catch (Exception e) {
	    
	    logger.trace("Try catch Error: id not found!", e);
	}
	return ingredientVO;
    }

    @Override
    public IngredientVO findByName(String name) {
	List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	ingredientVO = new IngredientVO("Ups error! Ingredient name not found", "100", ingredientsList);
	try {
	    List<Ingredient> ingredient = iIngredientRepository.findByName(name);
	    ingredientVO.setIngredientListVO(ingredient);
	    if(ingredientVO.getIngredientListVO().size() > 0) {
		ingredientVO.setMessage("Ingredient name found!");
		ingredientVO.setCode("101");
	    } else ingredientVO.setMessage("Sorry, ingredient name not found. Please try again");
	} catch (Exception e) {
	    logger.trace("Try catch Error: Ingredient name not found!", e);
	}
	return ingredientVO;
    }

    @Override
    public IngredientVO save(Ingredient ingredient) {
	List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	ingredientVO = new IngredientVO("Ups error!", "100", ingredientsList);
	try {
		iIngredientRepository.save(ingredient);
		ingredientVO.setMessage(String.format("The ingredient %s has been saved correctly", ingredient.getNameIngredient()));
		ingredientVO.setCode("101");
	} catch (Exception e) {
	    logger.trace("Try catch Error: Ingredient name not saved!", e);
	}
	return ingredientVO;
    }

    @Override
    public IngredientVO update(Ingredient ingredient) {
	List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	ingredientVO = new IngredientVO("Ups error!. The ingredient has not been saved correctly", "100", ingredientsList);
	try {
		iIngredientRepository.save(ingredient);
		ingredientVO.setMessage(String.format("The ingredient %s has been saved correctly", ingredient.getNameIngredient()));
		ingredientVO.setCode("0");
	} catch (Exception e) {
	    logger.trace("Try catch Error: Ingredient name not updated!", e);
	}
	return ingredientVO;
    }

    @Override
    public IngredientVO delete(Ingredient ingredient) {
	List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
	ingredientVO = new IngredientVO("Please try again, ingredient has not been deleted.", "100", ingredientsList);
	try {
	    	
		iIngredientRepository.delete(ingredient);
		ingredientVO.setMessage("The ingredient has been deleted successfully.");
		ingredientVO.setCode("0");
	} catch (Exception e) {
	    logger.trace("Try catch Error: Ingredient name not deleted!", e);
	}
	return ingredientVO;
    }

}
