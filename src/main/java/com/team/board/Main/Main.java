package com.team.board.Main;

import com.team.dao.MemberDAO;
import com.team.vo.Member;

public class Main {
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		System.out.println(memberDAO.isMember("elmo7180@naver.com"));
	}
}
