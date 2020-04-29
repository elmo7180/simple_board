package com.team.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.board.JDBC.JDBCUtility;
import com.team.board.vo.Board;
import com.team.board.vo.type.BoardType;

@Repository
public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Autowired
	JDBCUtility util;
	
	public List<Board> getList(){
		List<Board> list = new ArrayList<Board>();
		if(util == null) {
			System.out.println("util is null");
			util = new JDBCUtility();
		}
		//JDBC...
		// connection -> preparedStatement -> ResultSet -> close
		conn = util.open();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM 'BOARD' ORDER BY 'b_id'");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setB_content(rs.getString("b_content"));
				board.setB_date(rs.getString("b_date"));
				board.setB_id(rs.getInt("b_id"));
				board.setB_readcount(rs.getInt("b_readcount"));
				board.setB_title(rs.getString("b_title"));
				board.setB_type(BoardType.valueOf(rs.getString("b_type")));
				//TODO writer:email -> writer:name 수정작업 
				board.setB_writer(rs.getString("b_writer"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(conn, pstmt, rs);
		}
		return list;
	}
}
