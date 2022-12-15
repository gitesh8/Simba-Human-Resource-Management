package main;

import java.util.Scanner;

import com.admin.usecase.AdminMain;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Simba Human Resources Management System\n");
		System.out.println("1. Admin Login\n2. Employee Login");
		
		Scanner ip = new Scanner(System.in);
		
		int input = ip.nextInt();
		
		switch(input) {
		   case 1:
			   System.out.println("Welcome to Admin Login\n");
			   
			   // admin auth
			   System.out.print("Enter Username: ");
			   String a_uname = ip.next();
			   
			   System.out.print("Enter Password: ");
			   String a_pass = ip.next();
			   
			   System.out.println();
			   
			   if(a_uname.equals("Admin") && a_pass.equals("Admin123")) {
				   System.out.println("Login Success\n");
				   AdminMain.main(args);
			   }
			   else {
				   System.out.println("Invalid Username or Password\n");
				   
				   System.out.println("1. Main Menu\n2. Exit");
				   int val = ip.nextInt();
				   
				   if(val==1) {
					   main(args);
				   }
				   else {
					   System.out.println("Thanks for Visiting");
					   break;
				   }
				   
			   }
			   
			   break;
		   case 2:
			   break;
		   default:
			   System.out.println("Invalid Input");
		}
		ip.close();
	}

}
