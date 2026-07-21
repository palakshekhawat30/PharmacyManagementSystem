package com.pharmacy.pharmacymanagementsystem.dao;

import com.pharmacy.pharmacymanagementsystem.model.Sale;
import com.pharmacy.pharmacymanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {

    public List<Sale> getAllSales() {

        List<Sale> sales = new ArrayList<>();

        String sql = "SELECT * FROM sales ORDER BY sale_date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Sale sale = new Sale(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getString("sale_date"),
                        rs.getDouble("total_amount")
                );

                sales.add(sale);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return sales;
    }
}