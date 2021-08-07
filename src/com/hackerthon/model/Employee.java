/**
 * author - 2021S2_REG_WE_64
 *
 */
package com.hackerthon.model;

//Employee class created
public class Employee {

	private String employeeId;
	private String fullName;
	private String address;
	private String facultyName;
	private String department;
	private String designation;

	// static variable single_instance of type Singleton
	private static Employee employee = null;

	// static method to create instance of Employee class
	public static Employee getInstance()
	{
		if (employee == null)
			employee = new Employee();

		return employee;
	}

	//implementing getters and setters
	/** implementing getters for employeeID */
	public String getEmployeeId() {
		return employeeId;
	}

	/** implementing setters for employeeID */
	public void setEmployeeId(String employeeID) {
		employeeId = employeeID;
	}
	/** implementing getters for full name */
	public String getFullName() {
		return fullName;
	}
	/** implementing setters for full name */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/** implementing getters for address */
	public String getAddress()
	{
		return address;
	}
	/** implementing setters for address */
	public void setAddress(String address)
	{
		this.address = address;
	}
	/** implementing getters for faculty name */
	public String getFacultyName()
	{
		return facultyName;
	}
	/** implementing setters for faculty name */
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
