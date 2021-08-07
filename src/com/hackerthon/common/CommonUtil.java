/**
 * author - 2021S2_REG_WE_64
 *
 */
package com.hackerthon.common;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommonUtil {

	public static final Properties properties = new Properties();
	public static final Logger log = Logger.getLogger(CommonUtil.class.getName());

	static {
		try {
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.CONFIG_PROPERTIES));
		} catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage());
		}
	}
}
