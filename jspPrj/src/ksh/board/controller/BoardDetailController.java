package ksh.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.board.dto.BoardDTO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardDetailController implements Controller{

	private static Log log = LogFactory.getLog(BoardDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDTO boardDTO = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		log.info("게시글 번호 확인 - " + boardNum);
		
		boardDTO = boardDAO.boardSelectDetail(boardNum);
//		log.info(boardDTO);
		request.setAttribute("boardDTO", boardDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/board/board_detail_view.jsp");
		return handlerAdapter;
	}
}
