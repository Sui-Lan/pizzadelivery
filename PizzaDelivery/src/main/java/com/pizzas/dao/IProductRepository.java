package com.pizzas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pizzas.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
    
    @Query(value="SELECT * FROM product WHERE name_product= ?1", nativeQuery= true)
    public List<Product> findByName(String name);
    
    @Query(value="SELECT * FROM product WHERE product_line=?1", nativeQuery = true)
    public List<Product> findByProductLine(String productLine);

    @Query(value="SELECT * FROM product ORDER BY stock_quantity DESC", nativeQuery = true)
    public List<Product> stockSortByMin();
    
    @Query(value="SELECT * FROM product ORDER BY stock_quantity, product_line ASC, name_product ASC", nativeQuery = true)
    public List<Product> stockSortByMax();
    
    @Query(value="SELECT * FROM product ORDER BY price DESC", nativeQuery = true)
    public List<Product> priceSortByMin();
    
    @Query(value="SELECT * FROM product ORDER BY price, product_line ASC, name_product ASC", nativeQuery = true)
    public List<Product> priceSortByMax();
        

}
