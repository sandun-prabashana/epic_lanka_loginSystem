/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

import com.epic.login.dao.registerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MCTech
 */

@WebServlet(urlPatterns = "/deleteUser")
public class deleteUser extends HttpServlet{
    
    private registerDAO registrationDao;

    public void init() {
        registrationDao =new registerDAO();
    }
    
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("deletemethod");
        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject reg = reader.readObject();
            System.out.println("jasonobject");
        int id = Integer.parseInt(reg.getString("id"));
        System.out.println(id);
        int x = 0;
        try {
            x = registrationDao.deleteUser(id);

        resp.setContentType("application/json");
        if(x>0){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("operation","success");
            writer.print(response.build());
        }
        writer.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
