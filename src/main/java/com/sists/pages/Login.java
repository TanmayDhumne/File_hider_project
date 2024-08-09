package com.sists.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDAO;
import service.SendOTPService;
import service.generateOTP;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		
		session.setAttribute("email_login", email);
		
		try {
			
			if (userDAO.isExist(email)) {

				String genOTP = generateOTP.getOTP();
				SendOTPService.sendOTP(email, genOTP);

				session.setAttribute("otp", genOTP);

				response.sendRedirect("otp2.jsp");

			} else {

				out.println("USER NOT FOUND");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
