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
	public void dESIGNATION(String designation) {
		dESIGNATION = designation;
	}
	@Override
	public String toString() {
		
		return "Employee ID = " + iDeMPLOYEE + "\n" + "FullName = " + nAMEfULL + "\n" + "Address = " + aDDRESS + "\n"
				+ "Faculty Name = " + fACULTYnAME + "\n" + "Department = " + dEPARTMENT + "\n" + "Designation = "
				+ dESIGNATION;
	}
}
