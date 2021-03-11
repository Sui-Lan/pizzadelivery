package com.pizzas.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idIngredient;
    private String nameIngredient;
    private Float stockQuantity;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "measure_unit", columnDefinition="ENUM('KILOS','LITROS')", nullable = false)
    private MeasurementUnit measurementUnit;
    
    @OneToMany(mappedBy = "ingredient")
    private Set<PizzaRecipe> pizzasRelationSet;

    @Override
    public String toString() {
	return "Ingredient [idIngredient=" + idIngredient + ", nameIngredient=" + nameIngredient + ", stockQuantity="
		+ stockQuantity + ", measurementUnit=" + measurementUnit + "]\n";
    }
}
