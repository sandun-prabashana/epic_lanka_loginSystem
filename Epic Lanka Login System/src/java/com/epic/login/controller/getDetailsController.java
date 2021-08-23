/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

import com.epic.login.dao.registerDAO;
import com.epic.login.model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/getdetails")

public class getDetailsController extends HttpServlet {


    private registerDAO registrationDao;

    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       ArrayList<Users> details = registrationDao.userDetails(req.getParameter("name"));
        String data = new Gson().toJson(details);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(data);
        
//        try {
//            
//            
//            String email = req.getParameter("custEmail");
//            
//            System.out.println(email);
//            
//            Users users = registrationDao.useDetails(email);
//
//
//        PrintWriter writer = resp.getWriter();
//        resp.setContentType("application/json");
//            writer.write("{\"operation\":\"+email+\"}");
//
//            writer.close();
//        }catch (Exception ex) {
//            Logger.getLogger(registerController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

