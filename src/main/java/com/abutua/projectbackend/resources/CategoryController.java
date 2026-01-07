package com.abutua.projectbackend.resources;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.abutua.projectbackend.models.Category;
import com.abutua.projectbackend.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired 
    private CategoryService categoryService;

    @GetMapping("Categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("Categories")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }
}
