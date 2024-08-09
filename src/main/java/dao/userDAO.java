package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.My_connection;
import model.User;

public class userDAO {
	
	//-----------METHOD TO CHEAK IF THE USER EXIST return true if email match and false if not-------------------------------
	
	public static boolean isExist(String email) throws SQLException {
		
		Connection connection = My_connection.getConnection();
		
		String querry = ("SELECT email FROM users");
		
		PreparedStatement statement = connection.prepareStatement(querry);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			
			String e = result.getString(1);
			
			if(e.equalsIgnoreCase(email)) {
				
				return true;
			}
			
			
		}
		return false;
	}
	
	//---------------METHOD FOR IF VALUE NOT EXIST THEN INSERT TO THE DATA BASE------------------

	public static int saveUser(User user) throws SQLException {
		
		Connection connection = My_connection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES (default,?,?)");
		
		statement.setString(2, user.getName());
		statement.setString(1, user.getEmail() );
		
	   return statement.executeUpdate();
		
		
	}
	
}
