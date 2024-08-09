package com.sists.pages;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataDAO;
import model.Data;


public class Hide extends HttpServlet {
      
	private static final long serialVersionUID = 1L;
	private String email3;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getParameter("filePath");
	
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		email3 = (String) session.getAttribute("email_login");
		
		File f = new File(path);
		Data file = new Data(0, f.getName(), path,this.email3);
		try {
			DataDAO.hideFile(file);
			out.println("FILE HIDE SUCCESSFULLY....");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
	}


