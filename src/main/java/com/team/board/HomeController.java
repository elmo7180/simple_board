package com.team.board;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.board.service.BoardListImpl;
import com.team.board.service.BoardService;
import com.team.board.vo.Board;

@Controller
public class HomeController {
	@Autowired
	ApplicationContext ctx;
	BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale,HttpServletRequest request,HttpServletResponse response, Board board) {
		service = ctx.getBean(BoardListImpl.class);
		service.execute(request, response, board);
		return "home";
	}
	
}
