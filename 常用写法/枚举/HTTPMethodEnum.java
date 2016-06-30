package com.hking.enums;

import java.util.Map;
import java.util.TreeMap;

public enum HTTPMethodEnum {
	GET("get", "get请求"),
	POST("post", "post请求"),
	PUT("put", "put请求"),
	DELETE("delete", "delete请求");
	
	private String key;
	private String value;
	
	private HTTPMethodEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public static String getValueByKey(String key) {
		for (HTTPMethodEnum httpMethodEnum : HTTPMethodEnum.values()) {
			if (key == httpMethodEnum.getKey()) {
				return httpMethodEnum.getValue();
			}
		}
		return null;
	}
	
	public static Map<String, String> getBalanceTypes(){
		Map<String, String> map  = new TreeMap<String, String>();
		for (HTTPMethodEnum httpMethodEnum : HTTPMethodEnum.values()) {
			map.put(httpMethodEnum.getKey(), httpMethodEnum.getValue());
		}
		return map;
	}
}
