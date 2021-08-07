package com.hackerthon.model;

/* 2021S2_REG_WE_64 */

public class Employee {

	private String employeeId;
	private String fullName;
	private String address;
	private String facultyName;
	private String department;
	private String designation;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeID) {
		employeeId = employeeID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getFacultyName()
	{
		return facultyName;
	}

	public void setFacultyName(String facultyName)
	{
		this.facultyName = facultyName;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	@Override
	public String toString() {
		
		return "Employee ID = " + employeeId + "\n" + "FullName = " + fullName + "\n" + "Address = " + address + "\n"
				+ "Faculty Name = " + facultyName + "\n" + "Department = " + department + "\n" + "Designation = "
				+ designation;
	}
}
