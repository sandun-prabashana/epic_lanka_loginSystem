/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

import com.epic.login.dao.registerDAO;
import com.epic.login.model.Users;
import com.epic.login.security.AES;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signup") //url
public class registerController extends HttpServlet {

    //create reference variable
    private registerDAO registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            
            String user_name = req.getParameter("user_name");
            String address = req.getParameter("address");
            String email_address = req.getParameter("email_address");
            String conatct = req.getParameter("conatct");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            String mother = req.getParameter("mother");

            
            System.out.println("mother "+ mother);
            AES aes = new AES("gtevdywoap12gryd");
            String encdata = aes.encrypt(password);
            System.out.println(encdata);
            
            
            Users users = new Users();
                
                
                
                users.setUser_name(user_name);
                users.setAddress(address);
                users.setEmail_address(email_address);
                users.setContact(conatct);
                users.setPassword(encdata);
                users.setRole(role);
                users.setMothername(mother);

                System.out.println(mother);

        boolean b = registrationDao.registerEmployee(users); 
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        if (b){
            writer.write("{\"operation\":\"success\"}");
        }else{
            writer.write("{\"operation\":\"failed\"}");
        }
            writer.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(registerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
        
}


