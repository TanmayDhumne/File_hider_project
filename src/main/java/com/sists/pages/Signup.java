package com.sists.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.SendOTPService;
import service.generateOTP;
@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String user_name = request.getParameter("username");
		String email = request.getParameter("email");
		
		String genOTP = generateOTP.getOTP();
	
		System.out.println(user_name);
		System.out.println(email);
		System.out.println(genOTP);
		
		HttpSession session = request.getSession();
		session.setAttribute("user_name", user_name);
		session.setAttribute("email", email);
		
		session.setAttribute("otp", genOTP);
		
		SendOTPService.sendOTP(email, genOTP);
		
		response.sendRedirect("otp.jsp");
		
		
	}

}
