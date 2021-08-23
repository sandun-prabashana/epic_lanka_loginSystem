/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

import com.epic.login.dao.registerDAO;
import com.epic.login.model.Users;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
@WebServlet("/updateImage") 
//@WebServlet(urlPatterns = "/updateImage") //url
public class userImageUpdateController extends HttpServlet {

    private registerDAO registrationDao;


    public void init() {
        registrationDao =new registerDAO();
    }

    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            
		try
                {
                    
                    
                    System.out.println("In do post method of Add Image servlet.");
                    String name = req.getParameter("username");
                    Part file=req.getPart("image");
                    System.out.println(file);
                    System.out.println("aaaa"+name);
                    
                    
                    String imageFileName=file.getSubmittedFileName();
                    System.out.println("Selected Image File Name : "+imageFileName);
                    
                    String uploadPath="C:/Users/MCTech/Documents/NetBeansProjects/Epic Lanka Login System/web/images/"+imageFileName;
                    System.out.println("Upload Path : "+uploadPath);

                    try
                    {
                        
                        FileOutputStream fos=new FileOutputStream(uploadPath);
                        InputStream is=file.getInputStream();
                        
                        byte[] data=new byte[is.available()];
                        is.read(data);
                        fos.write(data);
                        fos.close();
                        
                    }
                    
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    
                    
                    
                    
                    Users user = new Users();
                    
                    
                    user.setUser_name(name);
                    user.setImage(imageFileName);
                    
                    
                    boolean b = registrationDao.updateImage(user);
                    
                    if(b){
                        resp.sendRedirect("profile.jsp?name="+name);
                    }else{
                        
                    }
                    
//            if (b){
//            writer.write("{\"operation\":\"success\"}");
//            }else{
//                writer.write("{\"operation\":\"failed\"}");
//            }
//            writer.close();
            
//         catch (Exception ex) {
//            Logger.getLogger(userUpdateController.class.getName()).log(Level.SEVERE, null, ex);
//        }
                }
		
		catch(ClassNotFoundException ex)
		{
			Logger.getLogger(userImageUpdateController.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    
        
        
}


