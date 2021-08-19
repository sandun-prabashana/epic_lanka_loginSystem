/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

import com.epic.login.dao.registerDAO;
import com.epic.login.model.Users;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MCTech
 */
@WebServlet(urlPatterns = "/getAllUsers")
public class loadTable extends HttpServlet{
    
    private registerDAO registerdao;
    
    public void init() {
        registerdao =new registerDAO();
    }
    
    
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("noo");
        String role="USER";
        ArrayList<Users> details = registerdao.loadAllData(role);
        System.out.println("yes");
        String data = new Gson().toJson(details);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(data);
    }
}
    
