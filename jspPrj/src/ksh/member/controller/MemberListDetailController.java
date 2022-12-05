package ksh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;
import ksh.member.dto.MemberDTO;

public class MemberListDetailController implements Controller {

	private static Log log = LogFactory.getLog(MemberListDetailController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		log.info("파라미터 memberId 확인 - " + memberId);
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		memberDTO = memberDAO.memberSelectDetail(memberId);
		log.info("memberDTO 확인 - " + memberDTO);
		String removeNull = memberDTO.getMemberAddress();
		if(removeNull.contains("null")) {
			removeNull = removeNull.replaceAll("null", "");
			memberDTO.setMemberAddress(removeNull);
		}
//		System.out.println(memberDTO.getMemberAddress());
		request.setAttribute("memberDTO", memberDTO);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/member/member_detail_view.jsp");
		return handlerAdapter;
	}

}
