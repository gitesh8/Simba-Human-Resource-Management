package com.dao;

import com.exception.EmployeeException;
import com.model.Employee;

public interface EmployeeDao {
	
	public Employee Login(int emp_id, String emp_pass) throws EmployeeException;
	public String DeptName(int dept_id);
	public String Updatepass(int emp_id, String emp_cpass, String emp_npass) throws EmployeeException;
	public String UpdateProfile(int emp_id, String add, int phone) throws EmployeeException;
    public String ApplyLeave(int emp_id, String fromdate, String todate) throws EmployeeException;
    public Employee CheckLeave(int emp_id) throws EmployeeException;
    public Employee CheckProfile(int emp_id) throws EmployeeException;

}
