package a;

import org.xml.sax.SAXException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.PreparedStatement;
import javax.xml.xpath.XPathExpressionException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;
import java.io.IOException;

import b.b;
import c.c1;
import c.c2;
import c.c3;

import java.util.ArrayList;
import java.util.Map;

public class a extends c1 {

	private final ArrayList<b> el = new ArrayList<b>();

	private static Connection c;

	private static Statement s;

	private PreparedStatement ps;

	public a() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (Exception e) {
		} 
	}

	public void EMPLOEESFROMXML() {

		try {
			int s = c3.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.XMLXPATHS().get(i);
				b EMPLOYEE = new b();
				EMPLOYEE.eMPLOYEEiD(l.get("XpathEmployeeIDKey"));
				EMPLOYEE.fULLnAME(l.get("XpathEmployeeNameKey"));
				EMPLOYEE.aDDRESS(l.get("XpathEmployeeAddressKey"));
				EMPLOYEE.fACULTYNAME(l.get("XpathFacultyNameKey"));
				EMPLOYEE.dEPARTMENT(l.get("XpathDepartmentKey"));
				EMPLOYEE.dESIGNATION(l.get("XpathDesignationKey"));
				el.add(EMPLOYEE);
				System.out.println(EMPLOYEE.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}

	public void eMPLOYEEtABLEcREATE() {
		try {
			s = c.createStatement();
			s.executeUpdate(c2.Q("q2"));
			s.executeUpdate(c2.Q("q1"));
		} catch (Exception e) {
		}
	}

	public void eMPLOYEESaDD() {
		try {
			ps = c.prepareStatement(c2.Q("q3"));
			c.setAutoCommit(false);
			for(int i = 0; i < el.size(); i++){
				b e = el.get(i);
				ps.setString(1, e.EMPLOYEEiDgET());
				ps.setString(2, e.fULLnAMEgET());
				ps.setString(3, e.aDDRESSgET());
				ps.setString(4, e.fACULTYnAMEgET());
				ps.setString(5, e.dEPARTMENTgET());
				ps.setString(6, e.dESIGNATIONgET());
				ps.addBatch();
			}
			ps.executeBatch();
			c.commit();
		} catch (Exception e) {
		}
	}

	public void eMPLOYEEGETBYID(String eid) {

		b e = new b();
		try {
			ps = c.prepareStatement(c2.Q("q4"));
			ps.setString(1, eid);
			ResultSet R = ps.executeQuery();
			while (R.next()) {
				e.eMPLOYEEiD(R.getString(1));
				e.fULLnAME(R.getString(2));
				e.aDDRESS(R.getString(3));
				e.fACULTYNAME(R.getString(4));
				e.dEPARTMENT(R.getString(5));
				e.dESIGNATION(R.getString(6));
			}
			ArrayList<b> l = new ArrayList<b>();
			l.add(e);
			eMPLOYEEoUTPUT(l);
		} catch (Exception ex) {
		}
	}

	public void EMPLOYEEDELETE(String eid) {

		try {
			ps = c.prepareStatement(c2.Q("q6"));
			ps.setString(1, eid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eMPLOYEEdISPLAY() {

		ArrayList<b> l = new ArrayList<b>();
		try {
			ps = c.prepareStatement(c2.Q("q5"));
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				b e = new b();
				e.eMPLOYEEiD(r.getString(1));
				e.fULLnAME(r.getString(2));
				e.aDDRESS(r.getString(3));
				e.fACULTYNAME(r.getString(4));
				e.dEPARTMENT(r.getString(5));
				e.dESIGNATION(r.getString(6));
				l.add(e);
			}
		} catch (Exception e) {
		}
		eMPLOYEEoUTPUT(l);
	}
	
	public void eMPLOYEEoUTPUT(ArrayList<b> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		for(int i = 0; i < l.size(); i++){
			b e = l.get(i);
			System.out.println(e.EMPLOYEEiDgET() + "\t" + e.fULLnAMEgET() + "\t\t"
					+ e.aDDRESSgET() + "\t" + e.fACULTYnAMEgET() + "\t" + e.dEPARTMENTgET() + "\t"
					+ e.dESIGNATIONgET() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
