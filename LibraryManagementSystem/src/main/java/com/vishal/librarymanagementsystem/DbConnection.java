/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vishal.librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author vishal
 */
public class DbConnection {
    public static Connection connect() throws SQLException{
        String url = "jdbc:mysql://mysqlDB_woodengas:9d8f8fc82af22459bdeff73c6a510b7f3bc59d23@efd.h.filess.io:3307/mysqlDB_woodengas";
        String user = "mysqlDB_woodengas";
        String pass = "9d8f8fc82af22459bdeff73c6a510b7f3bc59d23";
        return DriverManager.getConnection(url, user, pass);
        
        }
}