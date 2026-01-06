package com.abutua.projectbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Category;
import com.abutua.projectbackend.models.Product;
import com.abutua.projectbackend.repositories.CategoryRepository;

public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public Category getByProduct(Product productUpdate) {
        Category category = categoryRepository.findById(productUpdate.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category NOT FOUND"));

        return category;
    }

    public Category getById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category NOT FOUND"));

        return category;
    }
}
