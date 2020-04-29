package com.team.board.JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;
import org.sqlite.SQLiteConfig;

@Component
public class JDBCUtility {
	//서버에서 쓸 db의 URL
	//singleton
	private final static String DB_URL = "jdbc:sqlite:c:\\sqlite\\simple_board.db";
	private SQLiteConfig config = new SQLiteConfig();
	private Connection conn = null;
	
	public Connection open() {
		try {
			config.setReadOnly(false);
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection(DB_URL,config.toProperties());
			System.out.println("connection is ended successfully.");
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			
			while (rs.next()) {
			  System.out.println(rs.getString(3));
			}
			
			if(!rs.isClosed()) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try{	
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
