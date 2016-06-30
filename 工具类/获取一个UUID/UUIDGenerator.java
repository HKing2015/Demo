package com.hking.util;

import java.util.UUID;

	public class UUIDGenerator {

	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.replaceAll("-", "");
	}
	/**
	 * 获取指定长度的uuid
	 * 
	 * @param number
	 * @return
	 */
	public static String getUUID(int number){
		String s = UUID.randomUUID().toString();
		s = s.replaceAll("-", "");
		s = s.substring(0, number);
		
		return s;
	}
}
