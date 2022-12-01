package ksh.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardDeleteController implements Controller{
	
	private static Log log = LogFactory.getLog(BoardDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		log.info("게시판 번호 - " + boardNum);
//		String memberId = request.getParameter("memberId");
//		log.info("로그인 아이디 - " + memberId);
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.boardDelete(boardNum);
		log.info("삭제한 게시글 숫자 - " + result);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./BoardList.do");
		
		return handlerAdapter;
	}
}