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

    private static int contCategory = 0;

    // Método Construtor
    public Category(String name) {
        System.out.println("Construindo uma categoria!");

        // Aumentando a qtde de Categoria
        contCategory++;

        this.id = contCategory;
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
