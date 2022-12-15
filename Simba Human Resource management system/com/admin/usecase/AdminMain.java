package com.admin.usecase;

import java.util.Scanner;

public class AdminMain {
	public static void main(String[] args) {
		System.out.println("Welcome Admin\n");
		
		System.out.println("1. Add new Department\n2. Update Department\n3. View Departments\n4. Register New Employee\n5. Transfer Employee Department ");
		
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
			 default:
				 System.out.println("Invalid Input");
				 break;
			 
		}
		
		ip.close();
	}

}
