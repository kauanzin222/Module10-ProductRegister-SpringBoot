package com.abutua.projectbackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.projectbackend.models.Product;
import com.abutua.projectbackend.repositories.CategoryRepository;
import com.abutua.projectbackend.repositories.ProductRepository;
import com.abutua.projectbackend.services.CategoryService;
import com.abutua.projectbackend.services.ProductService;

@RestController
@CrossOrigin
public class ProductController {

        @Autowired
        public ProductRepository productRepository;

        @Autowired
        public CategoryRepository categoryRepository;

        @Autowired
        public ProductService productService;

        @Autowired
        public CategoryService categoryService;

        @PostMapping("Products")
        public ResponseEntity<Product> save(@RequestBody Product product) {
                product = productService.save(product);

                URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(product.getId())
                                .toUri();
                
                return ResponseEntity.created(location).body(product);
        }

        @GetMapping("Products/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable int id) {
                Product product = productService.getById(id);
                return ResponseEntity.ok(product);
        }

        @GetMapping("Products")
        public List<Product> getProducts() {
                return productService.getAll();
        }

        @DeleteMapping("Products/{id}")
        public ResponseEntity<Void> removeProduct(@PathVariable int id) {
                productService.deleteById(id);  
                return ResponseEntity.noContent().build();
        }

        @PutMapping("Products/{id}")
        public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody Product productUpdate) {
                productService.update(id, productUpdate);
                return ResponseEntity.ok().build();
        }

}
