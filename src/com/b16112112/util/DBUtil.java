package com.b16112112.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String url="jdbc:mysql://120.26.175.170:3306/resource";
	private static String driverClass="com.mysql.jdbc.Driver";
	private static String username="root";
	private static String password="root";
	private static Connection conn=null;
	//装载驱动
	static{
		try{
			Class.forName(driverClass);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//获取数据库连接
	public Connection getConnection(){
		try{
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("数据库连接成功");
		}
		catch(SQLException e){
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return conn;
	}
	//建立数据库连接
	public static void main(String[] args){
		DBUtil dbUtil = new DBUtil();
		dbUtil.getConnection();
	}
	//关闭数据库连接
	public void Close(){
		if(conn!=null){
			try{
				conn.close();
				System.out.println("数据库连接已关闭");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
