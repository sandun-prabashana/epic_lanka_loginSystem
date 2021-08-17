/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
    
    public Connection connection;
    public DBConnection(){
    }
    
    public  Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","mysql");
        System.out.println("db");
        return connection;
    }
    
    public  void connnectionClose() throws SQLException {
        System.out.println("connection closed");
        connection.close();
    }

}