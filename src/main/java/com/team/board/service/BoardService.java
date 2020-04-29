package com.team.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.vo.Board;

public interface BoardService {
	public void execute(HttpServletRequest request,HttpServletResponse response,Board board);
}
