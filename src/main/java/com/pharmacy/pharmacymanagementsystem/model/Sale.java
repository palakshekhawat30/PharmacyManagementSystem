package com.pharmacy.pharmacymanagementsystem.model;

public class Sale {

    private int id;
    private String customerName;
    private String saleDate;
    private double totalAmount;

    public Sale() {
    }

    // Constructor for creating a new sale
    public Sale(String customerName, double totalAmount) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    // Constructor for loading sale from database
    public Sale(int id, String customerName,
                String saleDate, double totalAmount) {

        this.id = id;
        this.customerName = customerName;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}