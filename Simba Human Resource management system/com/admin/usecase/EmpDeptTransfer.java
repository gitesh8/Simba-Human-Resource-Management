package com.admin.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class EmpDeptTransfer {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Employee Id");
		int emp_id = ip.nextInt();
		
		System.out.println("Enter Department id for Employee Transfer");
		int dept_id = ip.nextInt();
		
		AdminDao ad = new AdminDaoImpl();
		try {
			String m = ad.EmpDeptTranfer(emp_id, dept_id);
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
