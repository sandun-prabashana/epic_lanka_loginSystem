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

/**
 *
 * @author MCTech
 */
@WebServlet(urlPatterns = "/newuser")

public class validationController extends HttpServlet {

    //create reference variable
    private registerDAO registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            
            String user_name = req.getParameter("user_name");
            
            Users users = new Users();
                
                
            users.setUser_name(user_name);

            System.out.println(users.toString());

        boolean b = registrationDao.user_name_validate(users); 
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
