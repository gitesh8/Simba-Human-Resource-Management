package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.EmployeeException;
import com.model.Employee;
import com.utility.Dbcon;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee Login(int emp_id, String emp_pass) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Employee e = new Employee();
		
		try(Connection con = Dbcon.getcon()) {
			
			PreparedStatement ps = con.prepareStatement("select * from employee where emp_id=? AND emp_password=?");
			
			ps.setInt(1, emp_id);
			ps.setString(2, emp_pass);
			
			ResultSet x = ps.executeQuery();
			
			if(x.next()) {
				e.setEmp_id(x.getInt("emp_id"));
				e.setEmp_name(x.getString("emp_name"));
				e.setDept_id(x.getInt("dept_id"));
				
			}
			else {
				throw new EmployeeException("Incorrect Username or Password");
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			throw new EmployeeException(e2.getMessage());
		}
		
		return e;
	}

	@Override
	public String DeptName(int dept_id) {
		// TODO Auto-generated method stub
		
		String message = "Department Not Found";
		try(Connection con = Dbcon.getcon()) {
			PreparedStatement ps = con.prepareStatement("select * from department where dept_id=?");
			
			ps.setInt(1, dept_id);
			ResultSet x = ps.executeQuery();
			
			 if(x.next()) {
                message = x.getString("dept_name");
			 }
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return message;
	}

	@Override
	public String Updatepass(int emp_id, String emp_cpass, String emp_npass) throws EmployeeException {
		// TODO Auto-generated method stub
		String message = "Password Not Updated";
		
		try (Connection con = Dbcon.getcon()){
			
			PreparedStatement ps = con.prepareStatement("update employee set emp_password=? where emp_id=? AND emp_password=?");
			
			ps.setString(1, emp_npass);
			ps.setInt(2,emp_id);
			ps.setString(3, emp_cpass);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Password Updated Sucessfully";
			}
			else {
				message = "Current Password is Incorrect";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String UpdateProfile(int emp_id, String add, int phone) throws EmployeeException {
		// TODO Auto-generated method stub
		
		String m = "Profile Not Updated";
		
		try (Connection con = Dbcon.getcon()){
			
			PreparedStatement ps = con.prepareStatement("update employee set emp_phone=?, emp_address=? where emp_id=?");
			
			ps.setInt(1, phone);
			ps.setInt(3,emp_id);
			ps.setString(2, add);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				m = "Profile Updated Sucessfully";
			}

			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		return m;
		
	}

	@Override
	public String ApplyLeave(int emp_id, String fromdate, String todate) throws EmployeeException {
		// TODO Auto-generated method stub
		String m = "Error";
		
		try(Connection con = Dbcon.getcon()) {
			
			PreparedStatement ps = con.prepareStatement("update employee set emp_leave_status=?, emp_leave_fromdate=?, emp_leave_todate=? where emp_id=?;");
			
			ps.setString(1,"Pending");
			ps.setString(2, fromdate);
			ps.setString(3, todate);
			ps.setInt(4,emp_id);
			
			int x= ps.executeUpdate();
			
			if(x>0) {
				m = "Leave Requested, Waiting for Confirmation";
			}
			
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			throw new EmployeeException(e2.getMessage());
		}
		
		return m;
	}

	@Override
	public Employee CheckLeave(int emp_id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		
		try(Connection con = Dbcon.getcon()) {
			
			PreparedStatement ps = con.prepareStatement("select * from employee where emp_id=?");
			
			ps.setInt(1, emp_id);
			
			ResultSet x = ps.executeQuery();
			
			if(x.next()) {
				e.setEmp_leave_status(x.getString("emp_leave_status"));
				e.setEmp_leave_fromdate(x.getString("emp_leave_fromdate"));
				e.setEmp_leave_todate(x.getString("emp_leave_todate"));
				
			}
			else {
				throw new EmployeeException("Incorrect Username or Password");
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			throw new EmployeeException(e2.getMessage());
		}
		
		return e;
	}

	@Override
	public Employee CheckProfile(int emp_id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		
		try(Connection con = Dbcon.getcon()) {
			
			PreparedStatement ps = con.prepareStatement("select * from employee where emp_id=?");
			
			ps.setInt(1, emp_id);
			
			ResultSet x = ps.executeQuery();
			
			if(x.next()) {
				e.setEmp_id(x.getInt("emp_id"));
				e.setEmp_name(x.getString("emp_name"));
				e.setEmp_address(x.getString("emp_address"));
				e.setEmp_phone(x.getInt("emp_phone"));
				
			}
			
			
		} catch (Exception e2) {
			// TODO: handle exception
			throw new EmployeeException(e2.getMessage());
		}
		
		return e;
	}
	

}
