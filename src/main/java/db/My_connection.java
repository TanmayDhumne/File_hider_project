package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class My_connection {

//	private static final String url = "jdbc:mysql://localhost:3306/file_hider ";
//
//	private static final String user_name = "root";
//
//	private static final String password = "root";

	public static Connection connection = null;

	// ------------------THIS METHOD WILL JUST MAKE THE CONNECTION WITH THE DATABASE-------------------------

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/file_hider?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		System.out.println("connection done");

		return connection;
	}

//--------------------THIS METHOD WILL USE TO CLOSE THE CONNECTION ----------------------------	
	
	public static void closeConnection() {

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		
		My_connection.getConnection();
		
	}
	
}
