/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.dao;

/**
 *
 * @author MCTech
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epic.login.model.Users;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loginDAO {

	public boolean validate(Users users) throws ClassNotFoundException {
            
                final String url = "jdbc:mysql://localhost:3306/user";
                final String name = "root";
                final String password = "mysql";
                final String query = "select * from users where email_address = ? and password = ? ";
                        
		boolean status = false;
                
        

		Class.forName("com.mysql.jdbc.Driver");
                
                Connection connection = null;
                
		try {
                         connection = DriverManager
                        .getConnection(url,name,password);

				
			PreparedStatement preparedStatement = connection
			.prepareStatement(query) ;
			            preparedStatement.setString(1, users.getEmail_address());
                                    preparedStatement.setString(2, users.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
                    try {
                        printSQLException(e);
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		
                    
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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

