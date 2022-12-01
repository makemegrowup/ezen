package ksh.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.board.dto.BoardDTO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardInsertController implements Controller{

	private static Log log = LogFactory.getLog(BoardInsertController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		log.info("memberID 파라미터 확인 - " + memberId);
		String title = request.getParameter("title");
		log.info("title 파라미터 확인 - " + title);
		String boardPwd = request.getParameter("boardPwd");
		log.info("boardPwd 파라미터 확인 - " + boardPwd);
		String content = request.getParameter("content");
//		log.info("content 파라미터 확인 - " + content);
		
		BoardDTO boardDTO = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		
		boardDTO.setMemberId(memberId);
		boardDTO.setTitle(title);
		boardDTO.setBoardPwd(boardPwd);
		boardDTO.setContent(content);
		
		int result = boardDAO.boardInsert(boardDTO);
		log.info("게시글 등록 반영 : " + result + "개");
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./BoardList.do");
		
		return handlerAdapter;
	}
}
