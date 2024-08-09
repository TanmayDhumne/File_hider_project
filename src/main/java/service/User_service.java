package service;

import java.sql.SQLException;

import dao.userDAO;
import model.User;

public class User_service {
	
	public static Integer saveUser(User user){
        try {
            if(userDAO.isExist(user.getEmail())) {
                return 0;
            } else {
                return userDAO.saveUser(user);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
