package com.admin.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class EmpLeaveRequest {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int emp_id = ip.nextInt();
		
		System.out.println("Enter Status (Approved or Decline)");
		String status = ip.next();
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			String m = ad.EmpLeaveStatus(emp_id, status);
			System.out.println(m);
			
			System.out.println();
			
			AdminMain.main(args);
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip.close();
		
	}

}
