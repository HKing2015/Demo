package com.hking.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	/**
	 * 解析JSON
	 * @param json JSON字符串
	 * @param key 要获取的key值
	 * @return
	 */
	public static String getJsonValue(String json, String key) {
		JSONObject jo = JSON.parseObject(json);
		return jo.getString(key);
	}
	
	/**
	 * 把集合类转换成JSON
	 * @param obj
	 * @return
	 */
	public static String parseJson(Object obj) {
		return JSON.toJSONString(obj);
	}
}
