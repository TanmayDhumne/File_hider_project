package com.sists.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataDAO;
import model.Data;

public class Unhide extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email3;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Data> files = null;
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		email3=(String) session.getAttribute("email_login");
		
		try {
			files = DataDAO.getAllFiles(email3);
			
			 out.println("<html>");
			 out.println("<head>");
		        out.println("<title>File List</title>");
		        out.println("<link rel='stylesheet' href='Unhide.css'>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("<h1>File List</h1>");
		        out.println("<table border='1'>");
		        out.println("<tr><th>ID</th><th>File Name</th></tr>");
		        
		        for (Data file : files) {
		            out.println("<tr>");
		            out.println("<td>" + file.getId() + "</td>");
		            out.println("<td>" + file.getFileName() + "</td>");
		            out.println("</tr>");
		        }
		        
		        out.println("</table>");
		        
		        out.println("<h2>Unhide File</h2>");
		        out.println("<form action='Unhide_file'>");
		        out.println("<label for='fileId'>File ID:</label>");
		        out.println("<input type='text' id='fileId' name='fileId' required>");
		        out.println("<input type='submit' value='Unhide File'>");
		        out.println("</form>");

		        out.println("</body>");
		        out.println("</html>");
		        
		        int id = Integer.parseInt(request.getParameter("fileId"));
		        
		        boolean isValidID = false;
				for (Data file : files) {
					if (file.getId() == id) {
						isValidID = true;
						break;
					}
				}
				if (isValidID) {
					DataDAO.unhide(id);
				} else {
					out.println("Wrong ID");
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
