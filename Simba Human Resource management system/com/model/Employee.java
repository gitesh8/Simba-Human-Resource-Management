package com.model;

public class Employee {
	private int emp_id;
	private String emp_name;
	private int emp_phone;
	private int dept_id;
	private String emp_address;
	private String emp_password;
	private String emp_leave_req;
	private String emp_leave_status;
	private String emp_leave_fromdate;
	private String emp_leave_todate;
	
	public Employee() {
	
	}

	public Employee(int emp_id, String emp_name, int emp_phone, int dept_id, String emp_address, String emp_password,
			String emp_leave_req, String emp_leave_status, String emp_leave_fromdate, String emp_leave_todate) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.dept_id = dept_id;
		this.emp_address = emp_address;
		this.emp_password = emp_password;
		this.emp_leave_req = emp_leave_req;
		this.emp_leave_status = emp_leave_status;
		this.emp_leave_fromdate = emp_leave_fromdate;
		this.emp_leave_todate = emp_leave_todate;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_phone=" + emp_phone + ", dept_id="
				+ dept_id + ", emp_address=" + emp_address + ", emp_password=" + emp_password + ", emp_leave_req="
				+ emp_leave_req + ", emp_leave_status=" + emp_leave_status + ", emp_leave_fromdate="
				+ emp_leave_fromdate + ", emp_leave_todate=" + emp_leave_todate + "]";
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(int emp_phone) {
		this.emp_phone = emp_phone;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public String getEmp_leave_req() {
		return emp_leave_req;
	}

	public void setEmp_leave_req(String emp_leave_req) {
		this.emp_leave_req = emp_leave_req;
	}

	public String getEmp_leave_status() {
		return emp_leave_status;
	}

	public void setEmp_leave_status(String emp_leave_status) {
		this.emp_leave_status = emp_leave_status;
	}

	public String getEmp_leave_fromdate() {
		return emp_leave_fromdate;
	}

	public void setEmp_leave_fromdate(String emp_leave_fromdate) {
		this.emp_leave_fromdate = emp_leave_fromdate;
	}

	public String getEmp_leave_todate() {
		return emp_leave_todate;
	}

	public void setEmp_leave_todate(String emp_leave_todate) {
		this.emp_leave_todate = emp_leave_todate;
	}
	
	
}
