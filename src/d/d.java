package d;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import a.a;
import c.c3;

public class d {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		a employeeService = new a();
		try {
			c3.rEQUESTtRANSFORM();
			employeeService.EMPLOEESFROMXML();
			employeeService.eMPLOYEEtABLEcREATE();
			employeeService.eMPLOYEESaDD();
//			employeeService.eMPLOYEEGETBYID("EMP10004");
//			employeeService.EMPLOYEEDELETE("EMP10001");
			employeeService.eMPLOYEEdISPLAY();
		} catch (Exception e) {
		}

	}

}
