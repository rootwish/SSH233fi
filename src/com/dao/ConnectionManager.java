package com.dao;

import java.sql.*;

public class ConnectionManager {
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost:16699;DatabaseName=notice";
	private static final String DATABASE_USER = "sa";
	private static final String DATABASE_PASSWORD = "zhbit";
	
	public static Connection getConnection(){
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER ,DATABASE_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbConnection;
	}
	
	public static void closeConnection(Connection dbConnection){
		try {
			if (dbConnection!=null&&(!dbConnection.isClosed())){
				dbConnection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet res){
		try {
			if (res!=null){
				res.close();
				res = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(PreparedStatement statement){
		try {
			if (statement!=null){
				statement.close();
				statement = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
