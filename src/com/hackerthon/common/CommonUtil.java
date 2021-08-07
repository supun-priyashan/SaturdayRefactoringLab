package com.hackerthon.common;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommonUtil {

	public static final Properties p = new Properties();
	public static final Logger log = Logger.getLogger(CommonUtil.class.getName());

	static {
		try {
			p.load(c2.class.getResourceAsStream("../config/config.properties"));
		} catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage());
		}
	}
}
