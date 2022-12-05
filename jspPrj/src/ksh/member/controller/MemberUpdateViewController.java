package ksh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;
import ksh.member.dto.MemberDTO;

public class MemberUpdateViewController implements Controller {

	private static Log log = LogFactory.getLog(MemberUpdateViewController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		String memberId = request.getParameter("memberId");
		log.info("memberId 값 확인 - " + memberId);
		memberDTO = memberDAO.memberSelectDetail(memberId);
		log.info("memberDTO - " + memberDTO);
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/member/member_update_view.jsp");
		return handlerAdapter;
	}

}
