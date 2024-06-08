package com.kurve.product_service.controllers;

import com.kurve.product_service.dto.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.kurve.product_service.dto.ProductRequest;
import com.kurve.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse postMethodName(@RequestBody ProductRequest entity) {
        return productService.addProduct(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
    
}
