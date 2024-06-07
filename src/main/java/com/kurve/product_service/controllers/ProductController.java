package com.kurve.product_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.kurve.product_service.dto.ProductRequest;
import com.kurve.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postMethodName(@RequestBody ProductRequest entity) {
        productService.addProduct(entity);
        return "Product Added Successfully";
    }
    
}
