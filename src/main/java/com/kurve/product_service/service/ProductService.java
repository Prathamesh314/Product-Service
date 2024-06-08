package com.kurve.product_service.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.kurve.product_service.dto.ProductResponse;
import org.springframework.stereotype.Service;

import com.kurve.product_service.dto.ProductRequest;
import com.kurve.product_service.models.Product;
import com.kurve.product_service.repository.ProductRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRespository productRespository;

    public ProductResponse addProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
            .id(UUID.randomUUID().toString())
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        productRespository.save(product);
        return new ProductResponse(product.id, product.name, product.description, product.price);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRespository.findAll();
        return products.stream().map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice())).toList();
    }
}
