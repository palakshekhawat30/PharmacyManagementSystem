package com.pharmacy.pharmacymanagementsystem.dao;

import com.pharmacy.pharmacymanagementsystem.model.Sale;
import com.pharmacy.pharmacymanagementsystem.model.SaleItem;
import com.pharmacy.pharmacymanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillingDAO {

    public boolean completeSale(Sale sale, List<SaleItem> items) {

        String saleSQL =
                "INSERT INTO sales "
                + "(customer_name, total_amount) "
                + "VALUES (?, ?)";

        String itemSQL =
                "INSERT INTO sale_items "
                + "(sale_id, medicine_id, quantity, price, total) "
                + "VALUES (?, ?, ?, ?, ?)";

        String stockSQL =
                "UPDATE medicines "
                + "SET quantity = quantity - ? "
                + "WHERE id = ? AND quantity >= ?";

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            // Start transaction
            con.setAutoCommit(false);

            int saleId;

            // 1. Insert Sale
            try (PreparedStatement pst =
                         con.prepareStatement(
                                 saleSQL,
                                 PreparedStatement.RETURN_GENERATED_KEYS)) {

                pst.setString(1, sale.getCustomerName());
                pst.setDouble(2, sale.getTotalAmount());

                pst.executeUpdate();

                ResultSet rs = pst.getGeneratedKeys();

                if (rs.next()) {
                    saleId = rs.getInt(1);
                } else {
                    con.rollback();
                    return false;
                }
            }

            // 2. Process each medicine
            for (SaleItem item : items) {

                // Decrease stock
                try (PreparedStatement pst =
                             con.prepareStatement(stockSQL)) {

                    pst.setInt(1, item.getQuantity());
                    pst.setInt(2, item.getMedicineId());
                    pst.setInt(3, item.getQuantity());

                    int updatedRows = pst.executeUpdate();

                    if (updatedRows == 0) {
                        con.rollback();
                        return false;
                    }
                }

                // Insert Sale Item
                try (PreparedStatement pst =
                             con.prepareStatement(itemSQL)) {

                    pst.setInt(1, saleId);
                    pst.setInt(2, item.getMedicineId());
                    pst.setInt(3, item.getQuantity());
                    pst.setDouble(4, item.getPrice());
                    pst.setDouble(5, item.getTotal());

                    pst.executeUpdate();
                }
            }

            // Complete transaction
            con.commit();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackError) {
                rollbackError.printStackTrace();
            }

            return false;

        } finally {

            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}