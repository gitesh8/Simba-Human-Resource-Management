package com.admin.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class AddNewDepart {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Department Name");
		String dept_name = ip.next();
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			String op = ad.AddNewDepart(dept_name);
			System.out.println(op+"\n");
			
			System.out.println("1. Admin Menu\n2. Logged Out");
			
			int val = ip.nextInt();
			
			if(val==1) {
				AdminMain.main(args);
			}
			else {
				System.out.println("Logged Out Success\n");
			}
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		ip.close();
		
		
	}

}
