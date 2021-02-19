package com.pizzas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@ToString
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idIngredient;
    private String nameIngredient;
    private Float stockQuantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "measure_unit", columnDefinition="ENUM('KILOS','LITROS')", nullable = false)
    private MeasurementUnit measurementUnit;
    
}
