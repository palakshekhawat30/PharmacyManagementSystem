package com.pharmacy.pharmacymanagementsystem.model;

public class Customer {

    private int id;
    private String customerName;
    private String phone;
    private String email;
    private String address;

    // Empty constructor
    public Customer() {
    }

    // Constructor for adding a new customer
    public Customer(String customerName, String phone,
                    String email, String address) {

        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Constructor for loading customer from database
    public Customer(int id, String customerName, String phone,
                    String email, String address) {

        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}