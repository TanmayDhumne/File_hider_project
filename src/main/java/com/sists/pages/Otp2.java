package com.sists.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.User_service;
import view.UserView;

/**
 * Servlet implementation class Otp2
 */
public class Otp2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String otp_entered = request.getParameter("otp");

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		
		String otp = (String) session.getAttribute("otp");
	
		if (otp_entered.equalsIgnoreCase(otp)) {

			out.println("successfull");
			response.sendRedirect("main_menu.jsp");
			
		}else {
			
			out.println("WORNG OTP");
			
		}
	}

	}


