package org.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBM {

	private static Connection conn = null;
	static {
		try {
			        Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///bbs2?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "root", "123123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下午8:04:45 2017年10月23日
	 * 获得链接
	 */
	public static  Connection getConn() {
		return conn;
	}

}
