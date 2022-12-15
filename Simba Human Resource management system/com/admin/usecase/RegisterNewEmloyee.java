package com.admin.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.Employee;

public class RegisterNewEmloyee {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter Employee Name");
		String name = ip.next();
		
		System.out.println("Enter Employee Phone");
		int phone = ip.nextInt();
		
		System.out.println("Enter Employee Address");
		String address = ip.next();
		
		System.out.println("Select Employee Password");
		String password = ip.next();
		
		System.out.println("Select Employee Department");
		int dept_id = ip.nextInt();
		
		System.out.println();
		
		Employee emp = new Employee();
		
		emp.setDept_id(dept_id);
		emp.setEmp_phone(phone);
		emp.setEmp_address(address);
		emp.setEmp_name(name);
		emp.setEmp_password(password);
		
		AdminDao ad= new AdminDaoImpl();
		try {
			String response = ad.RegisterNewEmployee(emp);
			System.out.println(response);
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		ip.close();
		
		
		
	}

}
