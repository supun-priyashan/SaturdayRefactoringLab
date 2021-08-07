package com.hackerthon.common;

import java.util.Properties;


public class c1 {

	public static final Properties p = new Properties();

	static {
		try {
			p.load(c2.class.getResourceAsStream("../config/config.properties"));
		} catch (Exception e) {
			
		}
	}
}
