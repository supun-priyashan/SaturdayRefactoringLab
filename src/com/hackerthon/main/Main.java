package com.hackerthon.main;

import com.hackerthon.service.EmployeeService;
import com.hackerthon.common.c3;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();
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
