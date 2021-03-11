package com.pizzas.service;

import com.pizzas.model.Address;
import com.pizzas.vo.AddressVO;

public interface IAddressService {

    public AddressVO findAll();
    public AddressVO save(Address address);
    public AddressVO update(Address address);
    public AddressVO delete(Address address);
    
}
