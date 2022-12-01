package ksh.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;
import ksh.member.dto.MemberDTO;

public class LoginController implements Controller{

	private static Log log = LogFactory.getLog(LoginController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
//		String save = request.getParameter("save");
//		log.info(save);
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPwd(memberPwd);
		log.info(memberDTO);
		
		MemberDAO memberDAO = new MemberDAO();
		memberDTO = memberDAO.memberLogin(memberDTO);
		log.info("로그인 내용 - " + memberDTO);
//		request.setAttribute("memberName", memberDTO.getMemberName());
		request.setAttribute("memberDTO", memberDTO);
		if(!memberDTO.getMemberId().equals("") & !memberDTO.getMemberPwd().equals("")) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("memberId", memberDTO.getMemberId());
			httpSession.setAttribute("memberName", memberDTO.getMemberName());
			Cookie cookie = new Cookie("memberId", memberDTO.getMemberId());
			cookie.setMaxAge(60 * 60 * 24);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/login/login_check.jsp");
		return handlerAdapter;
	}
}
