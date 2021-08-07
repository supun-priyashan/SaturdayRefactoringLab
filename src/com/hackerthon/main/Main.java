package com.hackerthon.main;

import com.hackerthon.service.EmployeeService;
import com.hackerthon.common.TransformUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();

		try {
			TransformUtil.requestTransform();
			employeeService.employeesFromXML();
			employeeService.createEmployeeTable();
			employeeService.addEmployees();
//			employeeService.eMPLOYEEGETBYID("EMP10004");
//			employeeService.EMPLOYEEDELETE("EMP10001");
			employeeService.eMPLOYEEdISPLAY();
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}

	}

}
