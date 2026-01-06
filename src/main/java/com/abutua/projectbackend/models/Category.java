package com.abutua.projectbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_CATEGORY")
public class Category {

    // Atributos
    @Id
    private int id;
    
    private String name;

    // Construtor sem-args necessário ao JPA
    public Category() {
    }

    // Método Construtor
    public Category(int id, String name) {
        System.out.println("Construindo uma categoria!");

        this.id = id;
        this.name = name;
    }

    // Métodos da classe
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
