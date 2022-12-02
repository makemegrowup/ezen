package ksh.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.board.dto.BoardDTO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardUpdateController implements Controller {

	private static Log log = LogFactory.getLog(BoardUpdateController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		BoardDTO boardDTO = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		
		
		String title = request.getParameter("title");
		log.info("파라미터 title 확인 - " + title);
		String content = request.getParameter("content");
//		log.info("파라미터 content 확인 - " + content);
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		log.info("파라미터 boardNum 확인 - " + boardNum);
		
		boardDTO.setBoardNum(boardNum);
		boardDTO.setTitle(title);
		boardDTO.setContent(content);
		
		int result = boardDAO.boardUpdate(boardDTO);
		log.info("Update 된 행의 개수 - " + result);
		
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./BoardListDetail.do?boardNum=" + boardDTO.getBoardNum());
		
		return handlerAdapter;
	}

}
