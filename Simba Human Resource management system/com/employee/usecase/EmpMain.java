package com.employee.usecase;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;

import main.Main;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ip= new Scanner(System.in);
		
		System.out.print("Enter Employee id: ");
		int emp_id= ip.nextInt(); 
		
		System.out.print("Enter Password: ");
		String emp_pass= ip.next();
		
		System.out.println();
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		try {
			Employee ep = ed.Login(emp_id, emp_pass);
			System.out.println("Welcome, "+ep.getEmp_name());
			System.out.println("Employee Id: "+ep.getEmp_id());
			System.out.println("Department Id: "+ep.getDept_id());
			System.out.println("Department Name: "+ed.DeptName(ep.getDept_id()));
			
			Login(ep);
			
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
			System.out.println();
			
			System.out.println("Try Again");
			
			System.out.println();
			
			main(args);
		}
		ip.close();
		
		

	}
	public static String changepass(int emp_id) {
		
		String m = "Something Went Wrong";
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter Current Password");
		String cpass = ip.next();
		
		System.out.println("Enter New Password");
		String npass = ip.next();
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		try {
			m = ed.Updatepass(emp_id, cpass, npass);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip.close();
		return m;
		
		
	}
	
public static String updateProfile(int emp_id) {
		
		String m = "Something Went Wrong";
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter Address");
		String emp_address = ip.next();
		
		System.out.println("Enter Phone ");
		int emp_phone = ip.nextInt();
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		try {
			m = ed.UpdateProfile(emp_id, emp_address,emp_phone);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip.close();
		return m;
		
	}

public static void Login(Employee ep) {
	
	Scanner ip = new Scanner(System.in);
	
	
	System.out.println();
	
	System.out.println("1. Update Profile\n2. View Profile\n3. Apply for Leave\n4. Check Leave Status\n5. Change Password\n6. Main Menu\n7. Logout");
	
	int val = ip.nextInt();
	
	switch(val) {
	case 1:
		System.out.println(updateProfile(ep.getEmp_id()));
		System.out.println();
		Login(ep);
		break;
	case 2:
		CheckProfile(ep.getEmp_id());
		Login(ep);
		break;
	case 3:
		ApplyLeave(ep.getEmp_id());
		Login(ep);
		break;
	case 4:
		CheckLeave(ep.getEmp_id());
		Login(ep);
		break;
	case 5 :
		System.out.println(changepass(ep.getEmp_id()));
		System.out.println();
		System.out.println("Login Again");
		System.out.println();
		main(null);
	case 6:
		Main.main(null);
	case 7:
		System.out.println("Logged Out Successful");
		break;
	default:
		 System.out.println("Invalid Input");
		 break;
		
		
	}
	ip.close();
}
public static void ApplyLeave(int emp_id) {
	Scanner ip =  new Scanner(System.in);
	
	System.out.println("Enter from date");
	String fromdate = ip.next();
	
	System.out.println("Enter todate");
	String todate = ip.next();
	
	EmployeeDao ed = new EmployeeDaoImpl();
	
	try {
		String m = ed.ApplyLeave(emp_id, fromdate, todate);
		System.out.println(m);
		System.out.println();
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	ip.close();
	
}
public static void CheckLeave(int emp_id) {
	
	EmployeeDao ed = new EmployeeDaoImpl();
	
	try {
		Employee e = ed.CheckLeave(emp_id);
		System.out.println("Leave Status: "+e.getEmp_leave_status());
		System.out.println("From date: "+e.getEmp_leave_fromdate());
		System.out.println("Todate: "+e.getEmp_leave_todate());
		
		System.out.println();
		
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
}
public static void CheckProfile(int emp_id) {
	
	EmployeeDao ed = new EmployeeDaoImpl();
	
	try {
		Employee e = ed.CheckProfile(emp_id);
		System.out.println("Employee Id: "+e.getEmp_id());
		System.out.println("Name: "+e.getEmp_name());
		System.out.println("Phone: "+e.getEmp_phone());
		System.out.println("Address: "+e.getEmp_address());
		
		
		System.out.println();
		
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
}

}
