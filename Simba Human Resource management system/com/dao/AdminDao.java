package com.dao;

import com.exception.AdminException;
import com.model.Employee;

public interface AdminDao {
	
	public String AddNewDepart(String dept_name) throws AdminException;
	public String UpdateDepart(int dept_id, String dept_name) throws AdminException;
	public String RegisterNewEmployee(Employee emp) throws AdminException;
	

}
