/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pharmacy.pharmacymanagementsystem;

import com.pharmacy.pharmacymanagementsystem.util.DBConnection;
import java.sql.Connection;

public class PharmacyManagementSystem{
    public static void main(String[] args){
        Connection con = DBConnection.getConnection();
        if(con != null){
            System.out.println("Connection Successful !");
        }
        else{
             System.out.println("Connection Failed !");
        }
    }
}
