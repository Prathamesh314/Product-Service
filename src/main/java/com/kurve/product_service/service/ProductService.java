package com.kurve.product_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kurve.product_service.dto.ProductRequest;
import com.kurve.product_service.models.Product;
import com.kurve.product_service.repository.ProductRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRespository productRespository;

    public void addProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
            .id(UUID.randomUUID().toString())
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        productRespository.save(product);
    }
}
