package ksh.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;

public class LogoutController implements Controller {

	private static Log log = LogFactory.getLog(LogoutController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		String memberId = (String)httpSession.getAttribute("memberId");
		request.setAttribute("memberId", memberId);
		
		httpSession.invalidate();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("memberId")) {
					log.info(cookie.getName().equals("memberId"));
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/login/logout.jsp");
		return handlerAdapter;
	}

}
