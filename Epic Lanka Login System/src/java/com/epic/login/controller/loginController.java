/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epic.login.model.Users;
import com.epic.login.dao.registerDAO;
import com.epic.login.security.AES;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/login")
public class loginController extends HttpServlet {
	private registerDAO registerdao;

	public void init() {
		registerdao = new registerDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
try{
		String name = request.getParameter("uname");
		String password = request.getParameter("password");
                
                System.out.println(password);
                AES aes = new AES("gtevdywoap12gryd");
                String encdata = aes.encrypt(password);
                System.out.println(encdata);
                
		Users users = new Users();
		users.setUser_name(name);
		users.setPassword(encdata);

                
		
			if (registerdao.validate(users)) {
                                
                            String role =registerdao.getRole(name);
                            System.out.println("oyathamay"+role);
                            
                            if(role.equals("ADMIN")){
                                response.sendRedirect("adminProfile.jsp?name="+name);
                            }else{
                                
                                String state="ACTIVE ";
                                
                                users.setStatus(state);
                                
                                if (registerdao.validateState(users)) {
                                response.sendRedirect("profile.jsp?name="+name);
                                }else{
                                    response.sendRedirect("error.jsp");
                                }
                                
                                
                            }
//				response.sendRedirect("profile.jsp?email="+email);
                                System.out.println("ok");
                                
			} else {
                                response.sendRedirect("loginfrom.jsp");
                                System.out.println("kela una");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}

