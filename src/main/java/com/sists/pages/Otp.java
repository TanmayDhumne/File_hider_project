package com.sists.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.User_service;
import view.Welcome;

public class Otp extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String otp_entered = request.getParameter("otp");

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String s_user = (String) session.getAttribute("user_name");
		String otp = (String) session.getAttribute("otp");
		String s_email = (String) session.getAttribute("email");

		if (otp_entered.equalsIgnoreCase(otp)) {

			User user = new User(s_user, s_email);
			
			int save = User_service.saveUser(user);

			switch (save) {

			case 0:

				out.println("USER ALREADY EXIST");

				break;

			case 1:
                response.sendRedirect("index.jsp"); 
				break;

			}

		} else {

			out.println("wrong otp");

		}

	}

}