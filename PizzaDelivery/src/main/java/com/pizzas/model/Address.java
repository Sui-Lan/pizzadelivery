package com.pizzas.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAddress;
    private String nameAddress;
    private String street;
    private String number;
    private String apartment;
    private String comment;
    
}
