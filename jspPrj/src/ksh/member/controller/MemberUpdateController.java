package ksh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;
import ksh.member.dto.MemberDTO;

public class MemberUpdateController implements Controller{

	private static Log log = LogFactory.getLog(MemberUpdateController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		
		memberDTO.setMemberId(request.getParameter("memberId"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setBirth(request.getParameter("birth"));
		memberDTO.setPostalcode(request.getParameter("postalcode"));
		memberDTO.setAddress(request.getParameter("address"));
		memberDTO.setAddressDetail(request.getParameter("addressDetail"));
		memberDTO.setAddressExtra(request.getParameter("addressExtra"));
		memberDTO.setCellphone(request.getParameter("cellphone"));
		memberDTO.setEmail(request.getParameter("email"));
		memberDTO.setSubCellphone(request.getParameter("subCellphone"));
		memberDTO.setCompanyNumber(request.getParameter("companyNumber"));
		log.info("업데이트 항목 - " + memberDTO);
		System.out.println(memberDTO);
		int result = memberDAO.memberUpdate(memberDTO);
		log.info("업데이트 결과 - " + result);
		request.setAttribute("memberDTO", memberDTO);
		handlerAdapter.setPath("/WEB-INF/view/member/member_update_result.jsp");
		return handlerAdapter;
	}
}
