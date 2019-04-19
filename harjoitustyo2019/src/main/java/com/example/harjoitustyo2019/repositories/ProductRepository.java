package com.example.harjoitustyo2019.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.harjoitustyo2019.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductName(String name);
    
}