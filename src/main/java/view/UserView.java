package view;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.DataDAO;
import model.Data;

public class UserView {

	private String email; // email which is login

	UserView(String email) {

		this.email = email;

	}

	public void home() {

		do {

			System.out.println("Welcome" + this.email);
			System.out.println("PRESS 1 TO SHOW HIDDEN FILES");
			System.out.println("PRESS 2 TO HIDE A FILE");
			System.out.println("PRESS 3 TO UNHIDE A FILE");
			System.out.println("PRESS 0 TO EXIT");

			Scanner sc = new Scanner(System.in);

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				try {
					List<Data> files = DataDAO.getAllFiles(this.email);
					System.out.println("ID - File Name");
					for (Data file : files) {
						System.out.println(file.getId() + " - " + file.getFileName());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:{ 
				System.out.println("Enter the file path");
				String path = sc.next();
				File f = new File(path);
				Data file = new Data(0, f.getName(), path, this.email);
				try {
					DataDAO.hideFile(file);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				break;
			case 3: {
				List<Data> files = null;
				try {
					files = DataDAO.getAllFiles(this.email);

					System.out.println("ID - File Name");
					for (Data file : files) {
						System.out.println(file.getId() + " - " + file.getFileName());
					}
					System.out.println("Enter the id of file to unhide");
					int id = sc.nextInt();
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
						System.out.println("Wrong ID");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				break;
			case 0: {
				System.exit(0);
			}
				break;
			}

		} while (true);

	}

}
