package com.example.dao;

import com.example.entity.Product;
import com.example.model.MyProduct;

import java.util.List;

public interface ProductDao {

    boolean create(Product product);

    void update(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void remove(Product product);

    void removeById(Long id);


}
