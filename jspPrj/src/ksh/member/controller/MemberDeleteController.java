package ksh.member.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;
import ksh.member.dto.MemberDTO;

public class MemberDeleteController implements Controller{

	private static Log log = LogFactory.getLog(MemberDeleteController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		log.info(memberId);
		MemberDTO memberDTO= new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		memberDTO = memberDAO.memberSelectDetail(memberId);
		log.info("회원 정보 - " + memberDTO);
		int result = memberDAO.memberDelete(memberId);
		log.info("DB반영(회원삭제) 개수 - " + result);
		
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/member/member_delete_result.jsp");
		return handlerAdapter;
	}
}
