package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class JDBCUtil {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(dburl, dbUser, dbpasswd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(PreparedStatement stmt,Connection conn) {
		if(stmt!=null) {
			try {
				if(!stmt.isClosed())stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}
	public static void close(ResultSet rs,PreparedStatement stmt,Connection conn) {
		if(rs!=null) {
			try {
				if(!rs.isClosed())rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		if(stmt!=null) {
			try {
				if(!stmt.isClosed())stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}
	
}
