/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoaiphuong
 */
public class Product {
    private String id;
    private String name;
    private Brand brand;
    private Category category;
    private int modelYear;
    private double listPrice;

    public Product() {
    }

    public Product(String id, String name, Brand brand, Category category, int modelYear, double listPrice) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    
    @Override
    public String toString() {
        String s = String.format("%s, %s, %s, %s, %d, %f", id, name, brand.getBrandId(), category.getCategoryId(), modelYear, listPrice);
        return s ;
    }
    
}
