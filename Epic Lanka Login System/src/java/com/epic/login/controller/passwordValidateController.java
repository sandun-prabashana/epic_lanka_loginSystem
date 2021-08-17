/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

/**
 *
 * @author MCTech
 */
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

@WebServlet(urlPatterns = "/newpassword") 
public class passwordValidateController extends HttpServlet {
  
    private registerDAO registrationDao;
    
    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
             
            String password = req.getParameter("password");

            
            System.out.println(password);
            AES aes = new AES("gtevdywoap12gryd");
            String encdata = aes.encrypt(password);
            System.out.println(encdata);
            
            
            Users users = new Users();
                    
            users.setPassword(encdata);

            System.out.println(users.toString());

        boolean b = registrationDao.user_password_validate(users); 
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
