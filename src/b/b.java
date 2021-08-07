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
	public void fULLnAME(String fullName) {
		nAMEfULL = fullName;
	}
	public String aDDRESSgET() {
		return aDDRESS;
	}
	public void aDDRESS(String address) {
		aDDRESS = address;
	}
	public String fACULTYnAMEgET() {
		return fACULTYnAME;
	}
	public void fACULTYNAME(String facultyName) {
		fACULTYnAME = facultyName;
	}
	public String dEPARTMENTgET() {
		return dEPARTMENT;
	}
	public void dEPARTMENT(String department) {
		dEPARTMENT = department;
	}
	public String dESIGNATIONgET() {
		return dESIGNATION;
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
