package com.team.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.board.dao.BoardDAO;
import com.team.board.vo.Board;

@Service
public class BoardListImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, Board board) {
		List<Board> list = dao.getList();
		for(Board var : list) {
			System.out.println(var.toString());
		}
		request.setAttribute("boards", list);
	}

}
