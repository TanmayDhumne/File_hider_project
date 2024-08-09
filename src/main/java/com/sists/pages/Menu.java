package com.sists.pages;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataDAO;
import model.Data;

public class Menu extends HttpServlet {
	
	private String email3;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int choice = Integer.parseInt(request.getParameter("inputField"));
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		email3=(String) session.getAttribute("email_login");
		
		switch (choice) {
		case 1:
			try {
				List<Data> files = DataDAO.getAllFiles(this.email3);
				out.println("ID - File Name");
				for (Data file : files) {
					out.println(file.getId() + " - " + file.getFileName());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			response.sendRedirect("hide.jsp");
			break;
			
		case 3:
			response.sendRedirect("Unhide_file");
			break;
//		case 3: {
//			List<Data> files = null;
//			try {
//				files = DataDAO.getAllFiles(email3);
//
//				System.out.println("ID - File Name");
//				for (Data file : files) {
//					System.out.println(file.getId() + " - " + file.getFileName());
//				}
//				System.out.println("Enter the id of file to unhide");
//				int id = sc.nextInt();
//				boolean isValidID = false;
//				for (Data file : files) {
//					if (file.getId() == id) {
//						isValidID = true;
//						break;
//					}
//				}
//				if (isValidID) {
//					DataDAO.unhide(id);
//				} else {
//					System.out.println("Wrong ID");
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//			break;
		case 0: {
			System.exit(0);
		}
			break;
		}
		
	}

}
