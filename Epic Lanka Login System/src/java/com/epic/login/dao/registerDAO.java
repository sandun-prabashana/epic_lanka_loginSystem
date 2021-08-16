/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epic.login.model.Users;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerDAO {

    public boolean registerEmployee(Users users) throws ClassNotFoundException {
        
        final String url = "jdbc:mysql://localhost:3306/user";
        final String name = "root";
        final String password = "mysql";
        final String query = "INSERT INTO users" +
            "  ( id, user_name , email_address , contact, password, role) VALUES " +
            " ( ?, ?, ?, ?, ?,?);";
        
//        int result = 0;

        System.out.println("aaa");

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("bbbb");
        Connection connection = null;
        
        try{  connection = DriverManager
            .getConnection(url,name,password);

            
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
                        preparedStatement.setString(1, users.getId());
                        preparedStatement.setString(2, users.getUser_name());
                        preparedStatement.setString(3, users.getEmail_address());
                        preparedStatement.setString(4, users.getContact());
                        preparedStatement.setString(5, users.getPassword());
                        preparedStatement.setString(6, users.getRole());
                        System.out.println(preparedStatement);
            
            int result = preparedStatement.executeUpdate();

        if (result >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}


