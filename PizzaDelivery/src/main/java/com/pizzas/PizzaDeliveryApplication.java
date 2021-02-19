package com.pizzas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzas.dao.IIngredientRepository;
import com.pizzas.model.Ingredient;
import com.pizzas.model.MeasurementUnit;
import com.pizzas.service.IIngredientService;

@SpringBootApplication
public class PizzaDeliveryApplication {

	public static void main(String[] args) {
//		SpringApplication.run(PizzaDeliveryApplication.class, args);
		
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(PizzaDeliveryApplication.class);
		
	    	//REPOSITORY TEST
//		IIngredientRepository iIngredientRepository = acac.getBean(IIngredientRepository.class);		
//		System.out.println(iIngredientRepository.findAll());
//		System.out.println(iIngredientRepository.findByName("Salsa de Tomate"));
		
	    
		//SERVICE TEST
//		IIngredientService iIngredientService = acac.getBean(IIngredientService.class);
//		System.out.println(iIngredientService.findAll());
//		System.out.println(iIngredientService.findById(16));
//		System.out.println(iIngredientService.findByName("Ajo"));
		
//		MeasurementUnit enumUnit = null;
//		Ingredient ingredient1 = new Ingredient(null, "Orégano", (float) 7.0 , enumUnit.KILOS);
//	    	Ingredient ingredient0 = new Ingredient(null, "Pimienta", (float) 0.3 , enumUnit.KILOS);
//		System.out.println(iIngredientService.save(ingredient0));
//		
//		Ingredient ingredient2 = new Ingredient(18, "Orégano", (float) 5.0 , enumUnit.KILOS);
//		System.out.println(iIngredientService.update(ingredient2));
		
//		Ingredient ingredient3 = new Ingredient(19, "Orégano", (float) 7.0 , enumUnit.KILOS);
//		System.out.println(iIngredientService.delete(ingredient3));
	}

}
