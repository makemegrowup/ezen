package ksh.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dao.BoardDAO;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardSearchController implements Controller {

	private static Log log = LogFactory.getLog(BoardSearchController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		log.info("keyfield,keyword 확인 - " + keyfield + " " + keyword);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		
		HttpSession session = request.getSession();
		session.setAttribute("keyfield", keyfield);
		session.setAttribute("keyword", keyword);
		BoardDAO boardDAO = new BoardDAO();
		List<?> searchBoardList = new ArrayList<Object>();
		
		int currentPage = 1;
		int rowLimitSize = 10;
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			log.info("현재 페이지 확인 - " + currentPage);
		}
		
		int searchBoardCount = boardDAO.boardSearchCount(keyword, keyfield);
		System.out.println("searchBoardCount = " + searchBoardCount);
		searchBoardList = boardDAO.boardSearch(keyword, keyfield, currentPage, rowLimitSize);
		
		int maxPage = (searchBoardCount%rowLimitSize == 0)? searchBoardCount/rowLimitSize : searchBoardCount/rowLimitSize+1;
		int endPage = (int)(Math.ceil(currentPage/5.0))*5;
		int startPage = endPage-4;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		request.setAttribute("page", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("searchBoardCount", searchBoardCount);
		request.setAttribute("searchBoardList", searchBoardList);
		request.setAttribute("keyword", keyword);
		request.setAttribute("keyfield", keyfield);
		
		handlerAdapter.setPath("WEB-INF/view/board/board_search_view.jsp");
		return handlerAdapter;
		}
	

}
