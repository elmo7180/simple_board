package com.team.board.Main;

import java.util.List;

import com.team.dao.BoardDAO;
import com.team.vo.Board;

public class Main {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		List<Board> list = boardDAO.getList();
		for(Board board : list) {
			System.out.println(board.toString());
		}
		
	}
}
