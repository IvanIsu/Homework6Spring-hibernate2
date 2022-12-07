package com.isupov.model.dao;

import com.isupov.model.Product;

import java.util.List;

public interface ProductDao {


    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);


}
