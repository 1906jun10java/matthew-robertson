package com.revature.beans;

public class Department {
	private String departmentName;

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + "]";
	}
	
	
}
