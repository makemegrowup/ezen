package ksh.common.frontcontroller;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.controller.BoardDeleteController;
import ksh.board.controller.BoardListDetailController;
import ksh.board.controller.BoardSearchController;
import ksh.board.controller.BoardInsertController;
import ksh.board.controller.BoardListController;
import ksh.board.controller.BoardUpdateController;
import ksh.board.controller.BoardUpdateViewController;
import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class BoardDispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(BoardDispatcherServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURI = requestURI.substring(contextPath.length());
		HandlerAdapter handlerAdapter = null;
		Controller controller = null;
		
		if(pathURI.equals("/BoardList.do")) {
			controller = new BoardListController();
			handlerAdapter = controller.execute(request, response);
			log.info("글 전체 조회 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardInsertView.do")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("WEB-INF/view/board/board_insert_view.jsp");
			log.info("게시글 등록 화면 뷰 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardInsert.do")) {
			controller = new BoardInsertController();
			handlerAdapter = controller.execute(request, response);
			log.info("게시글 등록 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardListDetail.do")) {
			controller = new BoardListDetailController();
			handlerAdapter = controller.execute(request, response);
			log.info("게시글 상세 내용 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardDeleteConfirm.do")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/board/board_delete_confirm.jsp");
			log.info("게시글 삭제 메세지창 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardDelete.do")) {
			controller = new BoardDeleteController();
			handlerAdapter = controller.execute(request, response);
			log.info("게시글 삭제 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardUpdateView.do")) {
			controller = new BoardUpdateViewController();
			handlerAdapter = controller.execute(request, response);
			log.info("게시글 수정페이지 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardUpdate.do")) {
			controller = new BoardUpdateController();
			handlerAdapter = controller.execute(request, response);
			log.info("게시글 수정완료 - " + handlerAdapter);
		}
		else if(pathURI.equals("/BoardSearch.do")) {
			controller = new BoardSearchController();
			handlerAdapter = controller.execute(request, response);
			log.info("검색 확인 - " + handlerAdapter);
		}
		if(handlerAdapter != null) {
			if(handlerAdapter.isRedirect()) {
				response.sendRedirect(handlerAdapter.getPath());
			} else {
				request.getRequestDispatcher(handlerAdapter.getPath()).forward(request, response);
			}
		}
	}
}
