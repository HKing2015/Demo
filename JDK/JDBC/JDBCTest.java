package com.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.configuration.FileConfiguration;

import com.hking.util.PropertiesUtil;

public class JDBCTest {
	
	public static void main(String[] args) throws Exception {
		
		FileConfiguration properties = PropertiesUtil.getInstance("/properties/jdbc.properties");
		String driver = properties.getString("driver");
		String url = properties.getString("url");
		String username = properties.getString("username");
		String password = properties.getString("password");
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("insert into t_product (id,name,price,category) values (?,?,1,1)"); //SQL
		for(int i = 0; i < 10; i++) {
			pstmt.setInt(1,i);
			pstmt.setString(2, "test" + i);
			pstmt.executeUpdate();
		}
		
		if(pstmt != null) {
			pstmt.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
}
