package com.abutua.projectbackend.repositories;

import com.abutua.projectbackend.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Integer> {

}
