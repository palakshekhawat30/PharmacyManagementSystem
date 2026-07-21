package com.pharmacy.pharmacymanagementsystem.dao;

import com.pharmacy.pharmacymanagementsystem.model.Medicine;
import com.pharmacy.pharmacymanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {

    // ADD MEDICINE
    public boolean addMedicine(Medicine medicine) {

        String sql = "INSERT INTO medicines "
                + "(medicine_name, category, quantity, price, expiry_date) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, medicine.getMedicineName());
            pst.setString(2, medicine.getCategory());
            pst.setInt(3, medicine.getQuantity());
            pst.setDouble(4, medicine.getPrice());
            pst.setString(5, medicine.getExpiryDate());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateMedicine(Medicine medicine) {

    String sql = "UPDATE medicines SET "
            + "medicine_name = ?, "
            + "category = ?, "
            + "quantity = ?, "
            + "price = ?, "
            + "expiry_date = ? "
            + "WHERE id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, medicine.getMedicineName());
        pst.setString(2, medicine.getCategory());
        pst.setInt(3, medicine.getQuantity());
        pst.setDouble(4, medicine.getPrice());
        pst.setString(5, medicine.getExpiryDate());
        pst.setInt(6, medicine.getId());

        int rowsAffected = pst.executeUpdate();

        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean deleteMedicine(int id) {

    String sql = "DELETE FROM medicines WHERE id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, id);

        int rowsAffected = pst.executeUpdate();

        return rowsAffected > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // GET ALL MEDICINES
    public List<Medicine> getAllMedicines() {

        List<Medicine> medicines = new ArrayList<>();

        String sql = "SELECT * FROM medicines";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Medicine medicine = new Medicine(
                        rs.getInt("id"),
                        rs.getString("medicine_name"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("expiry_date")
                );

                medicines.add(medicine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicines;
    }
}