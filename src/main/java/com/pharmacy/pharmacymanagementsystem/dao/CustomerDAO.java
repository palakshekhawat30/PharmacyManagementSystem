package com.pharmacy.pharmacymanagementsystem.dao;

import com.pharmacy.pharmacymanagementsystem.model.Customer;
import com.pharmacy.pharmacymanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // ADD CUSTOMER
    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO customers "
                + "(customer_name, phone, email, address) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, customer.getCustomerName());
            pst.setString(2, customer.getPhone());
            pst.setString(3, customer.getEmail());
            pst.setString(4, customer.getAddress());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // GET ALL CUSTOMERS
    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customers";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Customer customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                );

                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // UPDATE CUSTOMER
    public boolean updateCustomer(Customer customer) {

        String sql = "UPDATE customers SET "
                + "customer_name = ?, "
                + "phone = ?, "
                + "email = ?, "
                + "address = ? "
                + "WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, customer.getCustomerName());
            pst.setString(2, customer.getPhone());
            pst.setString(3, customer.getEmail());
            pst.setString(4, customer.getAddress());
            pst.setInt(5, customer.getId());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE CUSTOMER
    public boolean deleteCustomer(int id) {

        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}