package com.abutua.projectbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.projectbackend.models.Category;
import com.abutua.projectbackend.models.Product;
import com.abutua.projectbackend.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CategoryService categoryService;

    public Product getById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product NOT FOUND"));
        return product;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void deleteById(int id) {
        productRepository.delete(getById(id));
    }

    public void update(int id, Product productUpdate) {
        Product product = getById(id);

        if (productUpdate.getCategory() == null) 
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category can not be empty");

        Category category = categoryService.getByProduct(productUpdate);

        product.setDescription(productUpdate.getDescription());
        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        product.setNewProduct(productUpdate.isNewProduct());
        product.setPromotion(productUpdate.isPromotion());
        product.setCategory(category);

        productRepository.save(product);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
