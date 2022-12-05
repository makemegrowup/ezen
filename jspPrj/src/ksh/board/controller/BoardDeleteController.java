package ksh.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
 
public class BoardDeleteController implements Controller{
	
	private static Log log = LogFactory.getLog(BoardListDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
//		boolean userCheck = false;
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		log.info("게시판 번호 - " + boardNum);
		String writer = request.getParameter("memberId");
		log.info("작성자 ID - " + writer);
		HttpSession session = request.getSession();
		String userCheck = (String)session.getAttribute("memberId");
		log.info("현재 로그인 중인 사용자 - " + userCheck);
//		userCheck = boardDAO.boardDeleteCheck(memberId);
		
		if(!userCheck.equals(writer) & !userCheck.equals("admin")) {
			handlerAdapter.setPath("/WEB-INF/view/board/board_delete_fail.jsp");
			return handlerAdapter;
		}
		
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.boardDelete(boardNum);
		log.info("삭제한 게시글 숫자 - " + result);
		handlerAdapter.setRedirect(true);
		handlerAdapter.setPath("./BoardList.do");
		
		return handlerAdapter;
	}
}
