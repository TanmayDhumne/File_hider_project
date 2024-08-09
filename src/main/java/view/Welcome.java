package view;

import java.util.Scanner;

import dao.userDAO;
import model.User;
import service.SendOTPService;
import service.User_service;
import service.generateOTP;

public class Welcome {
	
	public void welcomeScreen() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean value = true;
		
		while(value == true) {
		
		System.out.println("--WELCOME TO THE APPLICATION--");
		System.out.println("ENTER THE CHOICE FROM BELOW:-");
		System.out.println("PRESS 1 FOR LOGIN");
		System.out.println("PRESS 2 FOR SIGNUP");
		System.out.println("PRESS 0 TO EXIT");
		
		int choice = sc.nextInt();
		
//		switch(choice) {
//		
//		case 1: login();
//		
//		case 2: signUp();
//		
//		case 3: System.out.println("EXITED FROM PROGRAM");
//		        value = false;
//		        break;
//		
//		}
		
	}

	}	
	
//	public void login() {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("ENTER THE EMIAL ID:-");
//		
//		String email = sc.next();
//		
//		try {
//			
//			if(userDAO.isExist(email)) {
//				
//				
//				String genOTP = generateOTP.getOTP();
//				SendOTPService.sendOTP(email, genOTP);
//				System.out.println("ENTER THE OTP :- ");
//				String otp = sc.next();
//				
//				if(otp.equalsIgnoreCase(genOTP)) {
//					
//					new UserView(email).home();
//					
//				}else {
//					
//					System.out.println("WORNG OTP");
//					
//				}
//				
//			}else {
//				
//				System.out.println("USER NOT FOUND");
//				
//			}
//			
//		} catch (Exception e) {
//			
//		}
//		
//	}
//	
//	public void signUp() {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("ENTER THE NAME:-");
//		String name = sc.next();
//		System.out.println("ENTER THE EMAIL:-");
//		String email = sc.next();
		
//		String genOTP = generateOTP.getOTP();
//	
//		SendOTPService.sendOTP(email, genOTP);
//		
//		System.out.println("ENTER THE OTP :- ");
//		String otp = sc.next();
//		
//		if(otp.equalsIgnoreCase(genOTP)) {
//			
//			User user = new User(name,email);
//			int response = User_service.saveUser(user);
//		
//			switch (response) {
//			
//			case 1: System.out.println("USER REGISTERED");
//			        break;
//			        
//			case 2: System.out.println("USER ALREADY EXIST");
//			        break;
//			
//			}
//			
//		}else {
//			
//			System.out.println("WORNG OTP");
//			
//		}
		
		
	}
//}
