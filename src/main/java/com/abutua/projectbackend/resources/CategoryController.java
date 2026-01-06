package com.abutua.projectbackend.resources;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Category;
import com.abutua.projectbackend.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("Categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category NOT FOUND"));

        return ResponseEntity.ok(category);
    }

    @GetMapping("Categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
