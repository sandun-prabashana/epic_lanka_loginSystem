/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.dao;

import com.epic.login.db.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.epic.login.model.Users;
import com.epic.login.security.AES;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerDAO {
    
public boolean registerEmployee(Users users) throws ClassNotFoundException {
            
        final String query = "INSERT INTO users" +
            "  ( user_name , address , email_address , contact, password, role) VALUES " +
            " ( ?, ?, ?, ?, ?,?);";
        DBConnection connection = null;
        try {
            connection = new DBConnection();


                    PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query); 
                    preparedStatement.setString(1, users.getUser_name());
                    preparedStatement.setString(2, users.getAddress());
                    preparedStatement.setString(3, users.getEmail_address());
                    preparedStatement.setString(4, users.getContact());
                    preparedStatement.setString(5, users.getPassword());
                    preparedStatement.setString(6, users.getRole());
                    System.out.println(preparedStatement);

            int i = preparedStatement.executeUpdate();
            if (i >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

        public boolean validate(Users users) throws ClassNotFoundException {
            
                final String query = "select * from users where email_address = ? and password = ? ";
                        
		boolean status = false;
                
                DBConnection connection = null;
                
		try {
                         connection = new DBConnection();

				
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query) ;
			            preparedStatement.setString(1, users.getEmail_address());
                                    preparedStatement.setString(2, users.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
                    try {
                        connection.connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(registerDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		
                    
		return status;
	}
        
        public boolean user_name_validate(Users users) throws ClassNotFoundException {
            
                final String query = "select * from users where user_name = ? ";
                        
		boolean status = false;
                
                DBConnection connection = null;
                
		try {
                         connection = new DBConnection();

				
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query) ;
			preparedStatement.setString(1, users.getUser_name());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
                    try {
                        connection.connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(registerDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		
                    
		return status;
	}
        
        
                public boolean user_password_validate(Users users) throws ClassNotFoundException {
            
                final String query = "select * from users where password = ? ";
                        
		boolean status = false;
                
                DBConnection connection = null;
                
		try {
                         connection = new DBConnection();

				
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query) ;
			preparedStatement.setString(1, users.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
                    try {
                        connection.connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(registerDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		
                    
		return status;
	}
                
       

        
       public ArrayList<Users> userDetails(String email) {
        DBConnection connection = null;
        try {
            connection = new DBConnection();
            final String url="select user_name,address,email_address,contact,password,role,image from users WHERE email_address=?";
            PreparedStatement pstm = connection.getConnection().prepareStatement(url);
            pstm.setString(1, email);
            ResultSet rst = pstm.executeQuery();
            ArrayList<Users> load = new ArrayList<>();
            while (rst.next()) {
                System.out.println(rst.getString(5));
                
                AES aes = new AES("gtevdywoap12gryd");
                String decdata =  aes.decrypt(rst.getString(5));
                
                System.out.println(decdata);
                
                load.add(new Users(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), decdata, rst.getString(6), rst.getString(7)));
            }
            return load;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception ex) {
        Logger.getLogger(registerDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;

    }
       
       public boolean updateUser(Users users) throws ClassNotFoundException {
            
        final String query = "UPDATE users SET user_name=?,address=?,email_address=?,contact=?,password=?,role=? WHERE email_address=?";
        DBConnection connection = null;
        try {
            connection = new DBConnection();


                    PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query); 
                    preparedStatement.setString(1, users.getUser_name());
                    preparedStatement.setString(2, users.getAddress());
                    preparedStatement.setString(3, users.getEmail_address());
                    preparedStatement.setString(4, users.getContact());
                    preparedStatement.setString(5, users.getPassword());
                    preparedStatement.setString(6, users.getRole());
                    preparedStatement.setString(7, users.getEmail_address());
                    System.out.println(preparedStatement);

            int i = preparedStatement.executeUpdate();
            if (i >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
       
        public boolean updateImage(Users users) throws ClassNotFoundException {
            
        final String query = "UPDATE users SET image=? WHERE email_address=?";
        DBConnection connection = null;
        try {
            connection = new DBConnection();


                    PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query); 
                    preparedStatement.setString(1, users.getImage());
                    preparedStatement.setString(2, users.getEmail_address());
                    System.out.println(preparedStatement);

            int i = preparedStatement.executeUpdate();
            if (i >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
        
}


