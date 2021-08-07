package b;

public class b {

	public String iDeMPLOYEE;
	public String nAMEfULL;
	public String aDDRESS;
	public String fACULTYnAME;
	public String dEPARTMENT;
	public String dESIGNATION;
	public String EMPLOYEEiDgET() {
		return iDeMPLOYEE;
	}
	public void eMPLOYEEiD(String employeeID) {
		iDeMPLOYEE = employeeID;
	}
	public String fULLnAMEgET() {
		return nAMEfULL;
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
