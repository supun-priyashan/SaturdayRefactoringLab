package b;

public class b {

	public String employeeID;
	public String fullName;
	public String address;
	public String facultyName;
	public String department;
	public String designation;
	public String getEmployeeID() {
		return employeeID;
	}
	public void employeeID(String employeeID) {
		employeeID = employeeID;
	}
	public String getFullName() {
		return fullName;
	}
	public void fullName(String fullName) {
		fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void address(String address) {
		address = address;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void facultyName(String facultyName) {
		facultyName = facultyName;
	}
	public String getDepartment() {
		return department;
	}
	public void department(String department) {
		department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void designation(String designation) {
		designation = designation;
	}
	@Override
	public String toString() {
		
		return "Employee ID = " + employeeID + "\n" + "FullName = " + fullName + "\n" + "Address = " + address + "\n"
				+ "Faculty Name = " + facultyName + "\n" + "Department = " + department + "\n" + "Designation = "
				+ designation;
	}
}
