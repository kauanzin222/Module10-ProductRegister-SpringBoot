package com.abutua.projectbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_PRODUCT") 
public class Product {

    // Atributos:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private double price;
    private String description;
    private boolean promotion;
    private boolean newProduct;
    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(){}

    private static int contProducts = 0;

    // Métodos Construtores
    public Product(String name, String desc, Category category, boolean prom, boolean newProd, double price) {
        System.out.println("Construindo um Produto!");

        // Aumentando a qtde de Produtos existentes
        contProducts++;

        this.id = contProducts;
        this.name = name;
        this.description = desc;
        this.category = category;
        this.promotion = prom;
        this.newProduct = newProd;
        this.price = price;
    }

    // Métodos de Produto
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
}
