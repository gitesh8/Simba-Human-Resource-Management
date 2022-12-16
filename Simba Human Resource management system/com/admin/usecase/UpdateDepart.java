package com.admin.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class UpdateDepart {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Department Id");
		int dept_id = ip.nextInt();
		
		System.out.println("Enter Name to be Updated for Department");
		String dept_name = ip.next();
		
		AdminDao ad = new AdminDaoImpl();
		try {
			String m = ad.UpdateDepart(dept_id, dept_name);
			System.out.println(m);
			
			System.out.println();
			AdminMain.main(args);
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		ip.close();
		
	}

}
