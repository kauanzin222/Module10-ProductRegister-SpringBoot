package com.abutua.projectbackend.resources;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.abutua.projectbackend.models.Category;
import com.abutua.projectbackend.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin
public class CategoryController {

    
    // private List<Category> categories = Arrays.asList(
    //         new Category("Produção Própria"),
    //         new Category("Nacional"),
    //         new Category("Premium"),
    //         new Category("Avançado"),
    //         new Category("Importado"));
  
    
    @Autowired
    private CategoryRepository categoryRepository;

    // @GetMapping("Categories/{id}")
    // public ResponseEntity<Category> getCategory(@PathVariable int id) {

    //     Category cat = categories.stream()
    //             .filter(c -> c.getId() == id)
    //             .findFirst()
    //             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found... :c"));

    //     return ResponseEntity.ok(cat);
    // }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
