package com.team.board.Main;

import java.util.List;

import com.team.board.dao.BoardDAO;
import com.team.board.vo.Board;

public class Main {
	
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		List<Board> list = boardDAO.getList();
		for(Board board : list) {
			System.out.println(board.toString());
		}
		
	}
}
