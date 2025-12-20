package com.abutua.projectbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abutua.projectbackend.models.Product;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    
}
