/**
 * author - 2021S2_REG_WE_64
 *
 */
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

	/**
	 *
	 * @throws Exception
	 */
	public static void requestTransform() throws Exception {

		Source xmlInput = new StreamSource(new File(CommonConstants.EMPLOYEE_REQUEST));
		Source xsl = new StreamSource(new File(CommonConstants.EMPLOYEE_MODIFIED));
		Result xmlOutput = new StreamResult(new File(CommonConstants.EMPLOYEE_RESPONSE));
		TransformerFactory.newInstance().newTransformer(xsl).transform(xmlInput, xmlOutput);

	}

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Map<String, String>> readXmlXPaths() throws Exception {

		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(CommonConstants.EMPLOYEE_RESPONSE);
		XPath xPath = XPathFactory.newInstance().newXPath();
		int xPathExpLength = Integer.parseInt((String) xPath.compile(CommonConstants.EMPLYOEE_COUNT).evaluate(document, XPathConstants.STRING));
		for (int i = 1; i <= xPathExpLength; i++) {
			xpathOutputMap = new HashMap<String, String>();
			xpathOutputMap.put(CommonConstants.XPATH_EMP_ID, (String) xPath.compile(CommonConstants.EMPLOYEE_ID_1 + i + CommonConstants.EMPLOYEE_ID_2)
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put(CommonConstants.XPATH_EMP_NAME, (String) xPath.compile(CommonConstants.EMPLOYEE_ID_1 + i + CommonConstants.EMPLOYEE_NAME_KEY)
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put(CommonConstants.XPATH_EMP_ADDRESS,
					(String) xPath.compile(CommonConstants.EMPLOYEE_ID_1 + i + CommonConstants.EMPLOYEE_ADRESS_KEY).evaluate(document,
							XPathConstants.STRING));
			xpathOutputMap.put(CommonConstants.XPATH_EMP_FACULTY, (String) xPath.compile(CommonConstants.EMPLOYEE_ID_1 + i + CommonConstants.EMPLOYEE_FACULTY_KEY)
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put(CommonConstants.XPATH_EMP_DEPARTMENT, (String) xPath.compile(CommonConstants.EMPLOYEE_ID_1 + i + CommonConstants.EMPLOYEE_DEPARTMENT_KEY)
					.evaluate(document, XPathConstants.STRING));
			xpathOutputMap.put(CommonConstants.XPATH_EMP_DESIGNATION, (String) xPath.compile(CommonConstants.EMPLOYEE_ID_1 + i + CommonConstants.EMPLOYEE_DESIGNATION_KEY)
					.evaluate(document, XPathConstants.STRING));
			xPaths.add(xpathOutputMap);
		}
		return xPaths;
	}
}
