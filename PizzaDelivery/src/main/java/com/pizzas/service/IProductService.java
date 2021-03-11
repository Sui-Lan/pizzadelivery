package com.pizzas.service;

import java.util.List;


import com.pizzas.model.Product;
import com.pizzas.vo.ProductVO;

public interface IProductService {

    public ProductVO findAll();
    public ProductVO findByName(String name);
    public ProductVO findByProductLine(String productLine);
    public ProductVO stockSortByDesc();
    public ProductVO stockSortByAsc();
    public ProductVO priceSortByDesc();
    public ProductVO priceSortByAsc();
    public ProductVO save(Product product);
    public ProductVO update(Product product);
    public ProductVO delete(Product product);
    
}
