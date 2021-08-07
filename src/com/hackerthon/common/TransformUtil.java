package com.hackerthon.common;

import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.Document;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class TransformUtil extends CommonUtil {

	private static final ArrayList<Map<String, String>> xPaths = new ArrayList<Map<String, String>>();

	private static Map<String, String> xpathOutputMap = null;

	public static void requestTransform() throws Exception {

		Source xmlInput = new StreamSource(new File("src/e/EmployeeRequest.xml"));
		Source xsl = new StreamSource(new File("src/e/Employee-modified.xsl"));
		Result xmlOutput = new StreamResult(new File("src/e/EmployeeResponse.xml"));
		TransformerFactory.newInstance().newTransformer(xsl).transform(xmlInput, xmlOutput);
	}

	public static ArrayList<Map<String, String>> readXmlXPaths() throws Exception {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse("src/e/EmployeeResponse.xml");
		XPath xPath = XPathFactory.newInstance().newXPath();
		int xPathExpLength = Integer.parseInt((String) xPath.compile("count(//Employees/Employee)").evaluate(document, XPathConstants.STRING));
		for (int i = 1; i <= xPathExpLength; i++) {
			xpathOutputMap = new HashMap<String, String>();
			xpathOutputMap.put("XpathEmployeeIDKey", (String) xPath.compile("//Employees/Employee[" + i + "]/EmployeeID/text()")
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put("XpathEmployeeNameKey", (String) xPath.compile("//Employees/Employee[" + i + "]/EmployeeFullName/text()")
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put("XpathEmployeeAddressKey",
					(String) xPath.compile("//Employees/Employee[" + i + "]/EmployeeFullAddress/text()").evaluate(document,
							XPathConstants.STRING));
			xpathOutputMap.put("XpathFacultyNameKey", (String) xPath.compile("//Employees/Employee[" + i + "]/FacultyName/text()")
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put("XpathDepartmentKey", (String) xPath.compile("//Employees/Employee[" + i + "]/Department/text()")
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put("XpathDesignationKey", (String) xPath.compile("//Employees/Employee[" + i + "]/Designation/text()")
					.evaluate(document, XPathConstants.STRING));
			xPaths.add(xpathOutputMap);
		}
		return xPaths;
	}
}
