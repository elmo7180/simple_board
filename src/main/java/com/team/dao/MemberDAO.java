package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.JDBC.JDBCUtility;
import com.team.vo.Member;

@Repository
public class MemberDAO {
	
	//@Autowired
	JDBCUtility util=new JDBCUtility();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean isMember(String email) {
		int flag = 0;
		
		conn = util.open();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE email = ?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = 1;
			}else {
				flag = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(conn, pstmt, rs);
		}
		
		return flag==0? false : true;
	}
	public void insert(Member member) {
		//TODO spring 변경시 삭제 
		if(util==null) {
			util=new JDBCUtility();
		}
		conn = util.open();
		
		try{
			pstmt = conn.prepareStatement("INSERT INTO MEMBER(email,name,password,login_date,sign_date) VALUES(?,?,?,?,?)");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, sdf.format(date));
			pstmt.setString(5, sdf.format(date));
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(conn, pstmt, rs);
		}
	}
	public void delete(Member member) {
		
	}
	public void updateLoginDate(Member member,String df) {
		if(util==null) 
			util = new JDBCUtility();
		conn = util.open();
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET login_date = ? WHERE email = ?");
			pstmt.setString(1, df);
			pstmt.setString(2, member.getEmail());
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(conn, pstmt, rs);
		}
	}
	
	public Member getMember(String email,String password) {
		Member member = null;
		if(util==null) {
			util = new JDBCUtility();
		}
		conn = util.open();
		String df = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE email = ? AND password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				df = sdf.format(date);
				member.setEmail(rs.getString("email"));
				member.setLoginDate(df);
				member.setName(rs.getString("name"));
				member.setSignDate(rs.getString("sign_date"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.close(conn, pstmt, rs);
			if(member!=null && df!=null) {
				updateLoginDate(member,df);
			}
		}
		return member;
	}
}
