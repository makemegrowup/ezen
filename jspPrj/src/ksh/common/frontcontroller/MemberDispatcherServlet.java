package ksh.common.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.login.controller.LoginController;
import ksh.login.controller.LogoutController;
import ksh.member.controller.MemberListDetailController;
import ksh.member.controller.MemberDeleteController;
import ksh.member.controller.MemberInsertController;
import ksh.member.controller.MemberSelectAllController;


public class MemberDispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(MemberDispatcherServlet.class);
	
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
		
		if(pathURI.equals("/MemberSelectAll.me")) {
			controller = new MemberSelectAllController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 전체 조회 확인 - " + handlerAdapter);
		}
		
		else if(pathURI.equals("/MemberRegisterView.me")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/member/member_reg_view.jsp");
			log.info("회원 가입 화면 뷰 확인 - " + handlerAdapter);
		}
		
		else if(pathURI.equals("/MemberRegister.me")) {
			controller = new MemberInsertController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 가입 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/LoginView.me")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/login/login_view.jsp");
			log.info("로그인 화면 뷰 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/Login.me")) {
			controller = new LoginController();
			handlerAdapter = controller.execute(request, response);
			log.info("로그인 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/Logout.me")) {
			controller = new LogoutController();
			handlerAdapter = controller.execute(request, response);
			log.info("로그아웃 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/MemberListDetail.me")) {
			controller = new MemberListDetailController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 개별 조회 확인 - " + handlerAdapter);
		}
		else if(pathURI.equals("/MemberDelete.me")) {
			controller = new MemberDeleteController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 삭제 확인 - " + handlerAdapter);
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
