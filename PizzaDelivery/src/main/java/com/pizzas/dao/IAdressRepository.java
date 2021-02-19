package com.pizzas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzas.model.Address;

@Repository
public interface IAdressRepository extends JpaRepository<Address, Integer>{
    
}
