package ksh.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardListController implements Controller{

	private static Log log = LogFactory.getLog(BoardListController.class);
	
@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO boardDAO = new BoardDAO();
		List<?> boardList = new ArrayList<Object>();
		boardList = boardDAO.boardSelectAll();
		int listCount = boardDAO.boardCount();
		
		request.setAttribute("listCount", listCount);
		request.setAttribute("boardList", boardList);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("WEB-INF/view/board/board_list.jsp");
		return handlerAdapter;
	}
}
