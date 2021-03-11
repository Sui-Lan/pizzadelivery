package com.pizzas.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pizzas_recipe")
public class PizzaRecipe {

    @EmbeddedId
    private Integer idPizzaRecipe;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private Product product;
    
    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
    
//    @OneToMany(mappedBy = "pizzas_recipe")
////    @JoinColumn(name="id_product")
//    private Set<PizzaRecipe> productSet;
    
    private float quantity;
}
