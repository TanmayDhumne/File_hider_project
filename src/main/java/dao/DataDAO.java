package dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import db.My_connection;
import model.Data;

public class DataDAO {
	
	public static List<Data> getAllFiles(String email) throws SQLException{
		
		Connection connection = My_connection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM data WHERE email =?");
		
		statement.setString(1, email);

		ResultSet result = statement.executeQuery();
		
		List<Data> files = new ArrayList<>();
		
		while(result.next()) {
			
			int id = result.getInt(1);
            String name = result.getString(2);
            String path = result.getString(3);
            files.add(new Data(id, name, path));

			}
		
		return files;
	}
	
	public static int hideFile(Data file)throws SQLException, IOException{
        Connection connection = My_connection.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "insert into data(name, path, email, bin_data) values(?,?,?,?)");
        ps.setString(1, file.getFileName());
        ps.setString(2, file.getPath());
        ps.setString(3, file.getEmail());
        File f = new File(file.getPath());
        FileReader fr = new FileReader(f);
        ps.setCharacterStream(4, fr, f.length());
        int ans = ps.executeUpdate();
        fr.close();
        f.delete();
        return ans;
    }

     
	 public static void unhide(int id) throws SQLException, IOException {
	        Connection connection = My_connection.getConnection();
	        PreparedStatement ps = connection.prepareStatement("select path, bin_data from data where id = ?");
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        String path = rs.getString("path");
	        Clob c = rs.getClob("bin_data");

	        Reader r = c.getCharacterStream();
	        FileWriter fw = new FileWriter(path);
	        int i;
	        while ((i = r.read()) != -1) {
	            fw.write((char) i);
	        }
	        fw.close();
	        ps = connection.prepareStatement("delete from data where id = ?");
	        ps.setInt(1, id);
	        ps.executeUpdate();
	        System.out.println("Successfully Unhidden");
	    }

	
	
}
