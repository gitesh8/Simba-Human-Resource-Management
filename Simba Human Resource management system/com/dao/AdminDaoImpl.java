package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exception.AdminException;
import com.model.Employee;
import com.utility.Dbcon;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String AddNewDepart(String dept_name) throws AdminException {
		// TODO Auto-generated method stub
		
		String message = "Department Not added";
		
		try (Connection con = Dbcon.getcon()){
			
			PreparedStatement ps = con.prepareStatement("insert into department (dept_name) values (?)");
			ps.setString(1, dept_name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Department Added Successfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			throw new AdminException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String UpdateDepart(int dept_id, String dept_name) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String RegisterNewEmployee(Employee emp) throws AdminException {
		// TODO Auto-generated method stub
		
		String message = "Employee Not Registered";
		
		try(Connection con = Dbcon.getcon()) {
			PreparedStatement ps = con.prepareStatement("insert into employee (emp_name,emp_phone,emp_address,emp_password,dept_id) values(?,?,?,?,?)");
			ps.setString(1,emp.getEmp_name());
			ps.setInt(2, emp.getEmp_phone());
			ps.setString(3, emp.getEmp_address());
			ps.setString(4,emp.getEmp_password());
			ps.setInt(5,emp.getDept_id());
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Employee Registered Successfully";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		return message;
	}


}
