package com.dao;

import java.util.List;

import com.exception.AdminException;
import com.model.Department;
import com.model.Employee;

public interface AdminDao {
	
	public String AddNewDepart(String dept_name) throws AdminException;
	public String UpdateDepart(int dept_id, String dept_name) throws AdminException;
	public String RegisterNewEmployee(Employee emp) throws AdminException;
	public List<Department> ViewDepart() throws AdminException;
	public String EmpDeptTranfer(int emp_id, int dept_id) throws AdminException;
	public String EmpLeaveStatus(int emp_id, String status) throws AdminException;
	

}
