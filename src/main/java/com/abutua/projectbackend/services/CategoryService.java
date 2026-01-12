package com.abutua.projectbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Category;
import com.abutua.projectbackend.models.Product;
import com.abutua.projectbackend.repositories.CategoryRepository;

@Service
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

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void update(int id, Category categoryUpdate) {
        Category category = getById(id);
        category.setName(categoryUpdate.getName());

        categoryRepository.save(category);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(int id) {
        categoryRepository.delete(getById(id));
    }
}
