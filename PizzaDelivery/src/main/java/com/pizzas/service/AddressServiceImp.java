package com.pizzas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzas.PizzaDeliveryApplication;
import com.pizzas.dao.IAddressRepository;
import com.pizzas.model.Address;
import com.pizzas.vo.AddressVO;

@Service
public class AddressServiceImp implements IAddressService{

    private static final Logger logger = LoggerFactory.getLogger(PizzaDeliveryApplication.class);
    
    @Autowired
    IAddressRepository iAddressRepository;
    
    private AddressVO addressVO;
    
    @Override
    public AddressVO findAll() {
	List<Address> addressList = new ArrayList<Address>();
	addressVO = new AddressVO("Ups error!", "100", addressList);
	try {
	    addressVO.setAddressListVO(iAddressRepository.findAll());
	    if(addressVO.getAddressListVO().size()>0) {
		addressVO.setMessage("Success! findAll() has loaded correctly.");
		addressVO.setCode("101");
	    } else addressVO.setMessage("Sorry, address not found. Please try again");
	} catch (Exception e) {
	    logger.error("Try catch Error: findAll() not working", e);
	}
	return addressVO;
    }

    @Override
    public AddressVO save(Address address) {
	List<Address> addressList = new ArrayList<Address>();
	addressVO = new AddressVO("Ups error!", "100", addressList);
	try {
	    iAddressRepository.save(address);
	    addressVO.setMessage("The address has been saved correctly");
	    addressVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: Ingredient name not saved!", e);
	}
	return addressVO;
    }

    @Override
    public AddressVO update(Address address) {
	List<Address> addressList = new ArrayList<Address>();
	addressVO = new AddressVO("Ups error!", "100", addressList);
	try {
	    iAddressRepository.save(address);
	    addressVO.setMessage("The address has been updated correctly");
	    addressVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: Ingredient name not updated!", e);
	}
	return addressVO;
    }

    @Override
    public AddressVO delete(Address address) {
	List<Address> addressList = new ArrayList<Address>();
	addressVO = new AddressVO("Ups error!", "100", addressList);
	try {
	    iAddressRepository.delete(address);
	    addressVO.setMessage("The address has been deleted correctly");
	    addressVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: Ingredient name not saved!", e);
	}
	return addressVO;
    }

}
