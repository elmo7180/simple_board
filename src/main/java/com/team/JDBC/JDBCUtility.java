package com.team.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class JDBCUtility {
	//서버에서 쓸 db의 URL
	//singleton
	private final static String DB_URL = "jdbc:sqlite:simple_board.db";
	private Connection conn = null;
	
	public Connection open() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection(DB_URL);
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
