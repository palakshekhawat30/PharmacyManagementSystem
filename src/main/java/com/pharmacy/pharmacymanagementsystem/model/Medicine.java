package com.pharmacy.pharmacymanagementsystem.model;

public class Medicine {

    private int id;
    private String medicineName;
    private String category;
    private int quantity;
    private double price;
    private String expiryDate;

    public Medicine() {
    }

    // Constructor for adding a new medicine
    public Medicine(String medicineName, String category,
                    int quantity, double price, String expiryDate) {

        this.medicineName = medicineName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    // Constructor for loading medicine from database
    public Medicine(int id, String medicineName, String category,
                    int quantity, double price, String expiryDate) {

        this.id = id;
        this.medicineName = medicineName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}