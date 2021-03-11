package com.pizzas.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "product_line", columnDefinition = "ENUM('ACOMPANAMIENTO', 'BEBESTIBLE','PIZZA')")
    private ProductLine productLine;
    private String nameProduct;
    private String size;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "measure_unit", columnDefinition="ENUM('KILOS','LITROS')", nullable = false)
    private MeasurementUnit measurementUnit;
    private float price;
    private float stockQuantity;
    private boolean availability;

    @OneToMany(mappedBy = "product",cascade=CascadeType.ALL)
    private Set<PizzaRecipe> ingredientSet;
    
    @Override
    public String toString() {
	return "Product [idProduct=" + idProduct + ", productLine=" + productLine + ", nameProduct=" + nameProduct
		+ ", size=" + size + ", measurementUnit=" + measurementUnit + ", price=" + price + ", stockQuantity="
		+ stockQuantity + ", availability=" + availability + "]\n";
    }
}
