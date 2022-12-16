package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.AdminException;
import com.model.Department;
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
		
		String message = "Error";
		
		try(Connection con = Dbcon.getcon()) {
			PreparedStatement ps = con.prepareStatement("update department set dept_name=? where dept_id=?");
			ps.setInt(2, dept_id);
			ps.setString(1, dept_name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Department Updated";
			}
			else {
				message = "Department Not Found with Id: "+dept_id;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		
		return message;
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

	@Override
	public List<Department> ViewDepart() throws AdminException{
		// TODO Auto-generated method stub
		List<Department> ls = new ArrayList<>();
		
		
		try(Connection con = Dbcon.getcon()) {
			PreparedStatement ps = con.prepareStatement("select * from department");
			
			ResultSet x = ps.executeQuery();
			
			 while(x.next()) {
				 Department d= new Department();
				 d.setDept_id(x.getInt("dept_id"));
				 d.setDept_name(x.getString("dept_name"));
				 
				 ls.add(d);
			 }
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		
		
		
		return ls;
	}

	@Override
	public String EmpDeptTranfer(int emp_id, int dept_id) throws AdminException {
		// TODO Auto-generated method stub
		String message = "Error";
		
		try(Connection con = Dbcon.getcon()) {
			PreparedStatement ps = con.prepareStatement("update employee set dept_id=? where emp_id=?");
			
			ps.setInt(1, dept_id);
			ps.setInt(2, emp_id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Employee Department Tranfered Successfully";
			}
			else {
				message = "Employee Not Found with Id: "+emp_id;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String EmpLeaveStatus(int emp_id, String status) throws AdminException {
		// TODO Auto-generated method stub
		String m = "Error";
		
		try (Connection con = Dbcon.getcon()){
			
			PreparedStatement ps = con.prepareStatement("update employee set emp_leave_status=? where emp_id=?;");
			
			ps.setString(1, status);
			ps.setInt(2, emp_id);
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				m = "Leave Status Updated to "+status+" for Employee id "+emp_id;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AdminException(e.getMessage());
		}
		return m;
	}


}
