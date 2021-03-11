package com.pizzas.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzas.PizzaDeliveryApplication;
import com.pizzas.dao.IProductRepository;
import com.pizzas.model.Product;
import com.pizzas.vo.ProductVO;

@Service
public class ProductServiceImp implements IProductService {

    private final static Logger logger = LoggerFactory.getLogger(PizzaDeliveryApplication.class);
    
    @Autowired
    IProductRepository iProductRepository;
    
    private ProductVO productVO;

    @Override
    public ProductVO findAll() {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.findAll());
	    if(productVO.getProductListVO().size() > 0) {
		productVO.setMessage(String.format("Se han encontrado %d registro(s)", productVO.getProductListVO().size()));
		productVO.setCode("101");
	    } else productVO.setMessage("Sorry, products not found. Please try again");
	} catch (Exception e) {
	    logger.error("Try catch Error: findAll() not working", e);
	}
	return productVO;
    }

    @Override
    public ProductVO findByName(String name) {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.findByName(name));
	    productVO.setMessage(String.format("Se han encontrado %d registro(s)", productVO.getProductListVO().size()));
	    productVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: findByName() not working", e);
	}
	return productVO;
    }

    @Override
    public ProductVO findByProductLine(String productLine) {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.findByProductLine(productLine));
	    productVO.setMessage(String.format("Se han encontrado %d registro(s)", productVO.getProductListVO().size()));
	    productVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: findByProductLine() not working", e);
	}
	return productVO;
    }

    @Override
    public ProductVO stockSortByDesc() {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.stockSortByMin());
	    productVO.setMessage(String.format("Se han encontrado %d registro(s)", productVO.getProductListVO().size()));
	    productVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: stockSortByMin() not working", e);
	}
	return productVO;
    }

    @Override
    public ProductVO stockSortByAsc() {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.stockSortByMax());
	    productVO.setMessage(String.format("Se han encontrado %d registro(s)", productVO.getProductListVO().size()));
	    productVO.setCode("101");
	} catch (Exception e) {
	    logger.error("Try catch Error: stockSortByMin() not working", e);
	}
 	return productVO;
    }

    @Override
    public ProductVO priceSortByDesc() {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.priceSortByMin());
	    productVO.setMessage(String.format("Se ha/n encontrado %d registro/s", productVO.getProductListVO().size()));
	    productVO.setCode("101");
	} catch (Exception e) {
	    logger.trace("Try catch Error: stockSortByMax() not working",e);
	}
	return productVO;
    }

    @Override
    public ProductVO priceSortByAsc() {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	try {
	    productVO.setProductListVO(iProductRepository.priceSortByMax());
	    productVO.setMessage("");
	    productVO.setCode("101");
	} catch (Exception e) {
	    logger.trace("Try catch Error: priceSortByAsc() not working",e);
	}
	return productVO;
    }

    @Override
    public ProductVO save(Product product) {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	    try {
		iProductRepository.save(product);
		productVO.setMessage(String.format("The ingredient %s has been saved correctly", product.getNameProduct()));
		productVO.setCode("101");
	    } catch (Exception e) {
		logger.trace("Try catch Error: save() not working",e);
	    }
	return productVO;
    }

    @Override
    public ProductVO update(Product product) {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	
	    try {
		iProductRepository.save(product);
		productVO.setMessage(String.format("The ingredient %s has been updated correctly", product.getNameProduct()));
		productVO.setCode("101");
	    } catch (Exception e) {
		logger.trace("Try catch Error: update() not working",e);
	    }
	return productVO;
    }

    @Override
    public ProductVO delete(Product product) {
	List<Product> productList = new ArrayList<Product>();
	productVO = new ProductVO("Ups error!", "100", productList);
	    try {
		iProductRepository.delete(product);
		productVO.setMessage("The ingredient has been deleted successfully.");
		productVO.setCode("101");
	    } catch (Exception e) {
		logger.trace("Try catch Error: delete() not working",e);
	    }
	return productVO;
    }
    
   
}
