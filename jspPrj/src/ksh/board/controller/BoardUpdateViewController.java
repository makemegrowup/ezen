package ksh.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.board.dto.BoardDTO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardUpdateViewController implements Controller{

	private static Log log = LogFactory.getLog(BoardUpdateViewController.class);
	
@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		BoardDTO boardDTO = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
	
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		log.info("파라미터 boardNum - " + boardNum);
		String writer = request.getParameter("memberId");
		log.info("작성자 ID - " + writer);
		HttpSession session = request.getSession();
		String userCheck = (String)session.getAttribute("memberId");
		log.info("현재 로그인 중인 사용자 - " + userCheck);
		
		if(!userCheck.equals(writer) & !userCheck.equals("admin")) {
			handlerAdapter.setPath("/WEB-INF/view/board/board_update_fail.jsp");
			return handlerAdapter;
		}
		
		boardDTO = boardDAO.boardSelectDetail(boardNum);
		log.info("DTO 확인 - " + boardDTO);
		request.setAttribute("boardDTO", boardDTO);
		
		handlerAdapter.setPath("/WEB-INF/view/board/board_update_view.jsp");
		return handlerAdapter;
	}
}
