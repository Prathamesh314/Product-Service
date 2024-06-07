package com.kurve.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kurve.product_service.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends MongoRepository<Product, String>{
    
}
