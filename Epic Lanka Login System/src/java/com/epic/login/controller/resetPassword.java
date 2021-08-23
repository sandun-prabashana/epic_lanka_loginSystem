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
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/rest") //url
public class resetPassword extends HttpServlet {

    //create reference variable
    private registerDAO registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            
            String user_name = req.getParameter("user_name");
            String conatct = req.getParameter("conatct");
            String mother = req.getParameter("mother");

            
            
            
            Users users = new Users();
                
                
                
                users.setUser_name(user_name);
                users.setContact(conatct);
                users.setMothername(mother);

                System.out.println(mother);

        boolean b = registrationDao.uservalidate(users); 
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
    
    
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            
        try {
            JsonReader reader = Json.createReader(req.getReader());
            JsonObject jsonObject = reader.readObject();
            
            String userName = jsonObject.getString("user_name");
            String password = jsonObject.getString("password");
            
            System.out.println(userName);

            
            AES aes = new AES("gtevdywoap12gryd");
            String encdata = aes.encrypt(password);
            System.out.println(encdata);
            
            Users user = new Users();
            
            user.setUser_name(userName);
            user.setPassword(encdata);
            
            boolean b = registrationDao.restPassword(user);
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


