package com.hackerthon.service;

import java.sql.*;

import com.hackerthon.model.Employee;
import com.hackerthon.common.CommonUtil;
import com.hackerthon.common.QueryUtil;
import com.hackerthon.common.TransformUtil;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeService extends CommonUtil {

	private final ArrayList<Employee> employeeList = new ArrayList<Employee>();

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	private static final Logger log = Logger.getLogger(EmployeeService.class.getName());

	public EmployeeService() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (ClassNotFoundException e ) {
			log.log(Level.SEVERE, e.getMessage());
		} catch ( SQLException e){
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void employeesFromXML() {

		try {

			for (Map<String, String> xPath: TransformUtil.readXmlXPaths()) {

				Employee employee = new Employee();

				employee.setEmployeeId(xPath.get("XpathEmployeeIDKey"));
				employee.setFullName(xPath.get("XpathEmployeeNameKey"));
				employee.setAddress(xPath.get("XpathEmployeeAddressKey"));
				employee.setFacultyName(xPath.get("XpathFacultyNameKey"));
				employee.setDepartment(xPath.get("XpathDepartmentKey"));
				employee.setDesignation(xPath.get("XpathDesignationKey"));

				employeeList.add(employee);
				log.info(employee.toString() + "\n");
			}
		} catch (ClassCastException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e){
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void createEmployeeTable() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID("q2"));
			statement.executeUpdate(QueryUtil.queryByID("q1"));
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e){
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void addEmployees() {
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID("q3"));
			connection.setAutoCommit(false);

			for(Employee employee:employeeList){
				preparedStatement.setString(1, employee.getEmployeeId());
				preparedStatement.setString(2, employee.getFullName());
				preparedStatement.setString(3, employee.getAddress());
				preparedStatement.setString(4, employee.getFacultyName());
				preparedStatement.setString(5, employee.getDepartment());
				preparedStatement.setString(6, employee.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e){
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void getEmployeeByID(String employeeID) {

		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID("q4"));
			preparedStatement.setString(1, employeeID);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				setEmployee(result, employee);
			}
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			employeeList.add(employee);
			employeeOutput(employeeList);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e){
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void employeeDelete(String eid) {

		try {
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID("q6"));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e){
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void displayEmployees() {

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID("q5"));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				setEmployee(resultSet, employee);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e){
			log.log(Level.SEVERE, e.getMessage());
		}
		employeeOutput(employeeList);
	}

	private void setEmployee(ResultSet resultSet, Employee employee) throws SQLException {
		employee.setEmployeeId(resultSet.getString(1));
		employee.setFullName(resultSet.getString(2));
		employee.setAddress(resultSet.getString(3));
		employee.setFacultyName(resultSet.getString(4));
		employee.setDepartment(resultSet.getString(5));
		employee.setDesignation(resultSet.getString(6));
	}

	public void employeeOutput(ArrayList<Employee> employeeArrayList){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		for(Employee e:employeeArrayList){
			System.out.println(e.getEmployeeId() + "\t" + e.getFullName() + "\t\t"
					+ e.getAddress() + "\t" + e.getFacultyName() + "\t" + e.getDepartment() + "\t"
					+ e.getDesignation() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
