package com.hking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtils
 * 获取properties文件的参数
 * 
 * @author Lynch 2014-09-15
 * 
 */
public class PropertiesUtil2 {

	public static Properties getProperties(String propertiesName) { //配置文件名称

		Properties p = new Properties();

		try {
			InputStream inputStream = PropertiesUtil2.class.getClassLoader().getResourceAsStream(propertiesName);
			p.load(inputStream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static String getProperty(String key) {
		String values = PropertiesUtil2.getProperties("abc.properties").getProperty(key); //参数名
		return values;
	}
	
}
