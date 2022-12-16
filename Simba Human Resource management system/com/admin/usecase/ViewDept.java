package com.admin.usecase;

import java.util.List;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.Department;

public class ViewDept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdminDao ad = new AdminDaoImpl();
		try {
			List<Department> ls = ad.ViewDepart();
			ls.forEach(n->{
				System.out.println("Department Id: "+n.getDept_id());
				System.out.println("Department Name: "+n.getDept_name());
				
				System.out.println("-------------------------------");
			});
			
			System.out.println();
			AdminMain.main(args);
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
