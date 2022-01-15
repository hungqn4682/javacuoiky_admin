package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnect() {
		  Connection connection = null;
		  	String dbUrl = "jdbc:mysql://localhost:3306/ql";
		  	String dbUname="root";
			String dbPassword ="123456";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					connection = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return connection;
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			return connection;
			}
	public static void main(String[] args) {
		if(getConnect()!=null) System.out.println("thành công");
	else System.out.println(" kthành công");
	}	
}
