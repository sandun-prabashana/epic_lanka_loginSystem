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
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/userActivate") 

public class userActivate extends HttpServlet {

    //create reference variable
    private registerDAO registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            
        try {
            JsonReader reader = Json.createReader(req.getReader());
            JsonObject jsonObject = reader.readObject();
            
            int id = Integer.parseInt(jsonObject.getString("id"));
            String states = jsonObject.getString("state");
            
            System.out.println(id);
   
            
            Users user = new Users();
            
            user.setId(id);
            user.setStatus(states);
            
            boolean b = registrationDao.updateState(user);
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            if (b){
            writer.write("{\"operation\":\"success\"}");
            }else{
                writer.write("{\"operation\":\"failed\"}");
            }
            writer.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(userUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
        
}


