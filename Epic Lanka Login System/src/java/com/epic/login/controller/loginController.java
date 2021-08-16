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
import com.epic.login.dao.loginDAO;
import com.epic.login.security.AES;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private loginDAO logindao;

	public void init() {
		logindao = new loginDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
try{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
                
                System.out.println(password);
                AES aes = new AES("gtevdywoap12gryd");
                String encdata = aes.encrypt(password);
                System.out.println(encdata);
                
		Users users = new Users();
		users.setEmail_address(email);
		users.setPassword(encdata);

		
			if (logindao.validate(users)) {
                                
				response.sendRedirect("profile.jsp?email="+email);
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

