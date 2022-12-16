package com.admin.usecase;

import java.util.Scanner;

import main.Main;

public class AdminMain {
	public static void main(String[] args) {
		System.out.println("Welcome Admin\n");
		
		System.out.println("1. Add new Department\n2. Update Department\n3. View Departments\n4. Register New Employee\n5. Transfer Employee Department\n6. Main Menu\n7. Logout ");
		
		Scanner ip = new Scanner(System.in);
		
		int val = ip.nextInt();
		
		switch(val) {
		 case 1:
			 AddNewDepart.main(args);
			 break;
		 case 2:
			 UpdateDepart.main(args);;
			 break;
		 case 3:
			 ViewDept.main(args);
			 break;
		 case 4:
			 RegisterNewEmloyee.main(args);
			 break;
		 case 5:
			 EmpDeptTransfer.main(args);
			 break;
		 case 6:
			 Main.main(args);
		 case 7:
			 System.out.println("Logged Out Success");
			 break;
			 default:
				 System.out.println("Invalid Input");
				 break;
			 
		}
		
		ip.close();
	}

}
