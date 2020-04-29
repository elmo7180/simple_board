package com.team.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.board.JDBC.JDBCUtility;

@Repository
public class ReplyDAO {
	@Autowired
	JDBCUtility util;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
}
