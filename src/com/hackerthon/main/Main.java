package com.hackerthon.main;
/*2021S2_REG_WE_64*/

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
			employeeService.getEmployeeByID("EMP10004");
			employeeService.getEmployeeByID("EMP10001");
			employeeService.displayEmployees();
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}

	}

}
