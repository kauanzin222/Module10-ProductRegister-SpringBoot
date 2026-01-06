package com.abutua.projectbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Product;
import com.abutua.projectbackend.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public Product getById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product NOT FOUND"));
        
        return product;
    }
}
