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
		
		int currentPage = 1;
		int rowLimitSize = 10;
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		log.info("현재 페이지 파라미터 - " + currentPage);
		
		BoardDAO boardDAO = new BoardDAO();
		List<?> boardList = new ArrayList<Object>();
		boardList = boardDAO.boardSelectAll(currentPage, rowLimitSize);
		int boardListCount = boardDAO.boardListCount();
		
		int maxPage = (boardListCount%rowLimitSize == 0)? boardListCount/rowLimitSize : (boardListCount/rowLimitSize)+1;
		int endPage = (int)(Math.ceil(currentPage/5.0))*5;	
		// Page네비 5개 단위로 보여주기 위해 5.0과 5
		// Math.ceil 소수점은 무조건 반올림->정수만들어줌
		int startPage = endPage-4;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		request.setAttribute("page", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("boardListCount", boardListCount);
		request.setAttribute("boardList", boardList);
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("WEB-INF/view/board/board_list.jsp");
		return handlerAdapter;
	}
}
