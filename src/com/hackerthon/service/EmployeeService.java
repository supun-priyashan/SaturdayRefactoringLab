package com.hackerthon.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;

import com.hackerthon.model.Employee;
import com.hackerthon.common.CommonUtil;
import com.hackerthon.common.QueryUtil;
import com.hackerthon.common.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

public class EmployeeService extends CommonUtil {

	private final ArrayList<Employee> el = new ArrayList<Employee>();

	private static Connection c;

	private static Statement s;

	private PreparedStatement ps;

	public EmployeeService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
		} catch (Exception e) {
		} 
	}

	public void EMPLOEESFROMXML() {

		try {
			int s = TransformUtil.readXmlXPaths().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = TransformUtil.readXmlXPaths().get(i);
				Employee EMPLOYEE = new Employee();
				EMPLOYEE.setEmployeeId(l.get("XpathEmployeeIDKey"));
				EMPLOYEE.setFullName(l.get("XpathEmployeeNameKey"));
				EMPLOYEE.setAddress(l.get("XpathEmployeeAddressKey"));
				EMPLOYEE.setFacultyName(l.get("XpathFacultyNameKey"));
				EMPLOYEE.setDepartment(l.get("XpathDepartmentKey"));
				EMPLOYEE.setDesignation(l.get("XpathDesignationKey"));
				el.add(EMPLOYEE);
				System.out.println(EMPLOYEE.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}

	public void eMPLOYEEtABLEcREATE() {
		try {
			s = c.createStatement();
			s.executeUpdate(QueryUtil.queryByID("q2"));
			s.executeUpdate(QueryUtil.queryByID("q1"));
		} catch (Exception e) {
		}
	}

	public void eMPLOYEESaDD() {
		try {
			ps = c.prepareStatement(QueryUtil.queryByID("q3"));
			c.setAutoCommit(false);
			for(int i = 0; i < el.size(); i++){
				Employee e = el.get(i);
				ps.setString(1, e.getEmployeeId());
				ps.setString(2, e.getFullName());
				ps.setString(3, e.getAddress());
				ps.setString(4, e.getFacultyName());
				ps.setString(5, e.getDepartment());
				ps.setString(6, e.getDesignation());
				ps.addBatch();
			}
			ps.executeBatch();
			c.commit();
		} catch (Exception e) {
		}
	}

	public void eMPLOYEEGETBYID(String eid) {

		Employee e = new Employee();
		try {
			ps = c.prepareStatement(QueryUtil.queryByID("q4"));
			ps.setString(1, eid);
			ResultSet R = ps.executeQuery();
			while (R.next()) {
				e.setEmployeeId(R.getString(1));
				e.setFullName(R.getString(2));
				e.setAddress(R.getString(3));
				e.setFacultyName(R.getString(4));
				e.setDepartment(R.getString(5));
				e.setDesignation(R.getString(6));
			}
			ArrayList<Employee> l = new ArrayList<Employee>();
			l.add(e);
			eMPLOYEEoUTPUT(l);
		} catch (Exception ex) {
		}
	}

	public void EMPLOYEEDELETE(String eid) {

		try {
			ps = c.prepareStatement(QueryUtil.queryByID("q6"));
			ps.setString(1, eid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMPLOYEEdISPLAY() {

		ArrayList<Employee> l = new ArrayList<Employee>();
		try {
			ps = c.prepareStatement(QueryUtil.queryByID("q5"));
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Employee e = new Employee();
				e.setEmployeeId(r.getString(1));
				e.setFullName(r.getString(2));
				e.setAddress(r.getString(3));
				e.setFacultyName(r.getString(4));
				e.setDepartment(r.getString(5));
				e.setDesignation(r.getString(6));
				l.add(e);
			}
		} catch (Exception e) {
		}
		eMPLOYEEoUTPUT(l);
	}
	
	public void eMPLOYEEoUTPUT(ArrayList<Employee> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		for(int i = 0; i < l.size(); i++){
			Employee e = l.get(i);
			System.out.println(e.getEmployeeId() + "\t" + e.getFullName() + "\t\t"
					+ e.getAddress() + "\t" + e.getFacultyName() + "\t" + e.getDepartment() + "\t"
					+ e.getDesignation() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
