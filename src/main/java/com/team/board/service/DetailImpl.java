package com.team.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.board.dao.BoardDAO;
import com.team.board.vo.Board;
@Service
public class DetailImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Board board) {
		String b_idString = request.getParameter("b_id");
		if(b_idString == null) {
			return ;
		}
		try{
			int b_id = Integer.parseInt(b_idString);
			Board result = dao.getBoard(b_id);
			request.setAttribute("board", result);
			System.out.println(result.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
