package com.hackerthon.common;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class QueryUtil extends CommonUtil {
	
	public static String queryByID(String id) throws Exception {

		NodeList nodeList;
		Element element = null;

		try {
			nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File("src/e/EmployeeQuery.xml"))
					.getElementsByTagName("query");

			for (int x = 0; x < nodeList.getLength(); x++) {
				element = (Element) nodeList.item(x);
				if (element.getAttribute("id").equals(id))
					break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return element.getTextContent().trim();
	}
}
