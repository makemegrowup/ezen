package ksh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;
import ksh.member.dto.MemberDTO;

public class MemberInsertController implements Controller{

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String birth = request.getParameter("birth");
		String postalcode = request.getParameter("postalcode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String addressExtra = request.getParameter("addressExtra");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		String subCellphone = request.getParameter("subCellphone");
		String companyNumber = request.getParameter("companyNumber");
		
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPwd(memberPwd);
		memberDTO.setMemberName(memberName);
		memberDTO.setBirth(birth);
		memberDTO.setPostalcode(postalcode);
		memberDTO.setAddress(address);
		memberDTO.setAddressDetail(addressDetail);
		memberDTO.setAddressExtra(addressExtra);
		memberDTO.setCellphone(cellphone);
		memberDTO.setEmail(email);
		memberDTO.setSubCellphone(subCellphone);
		memberDTO.setCompanyNumber(companyNumber);
		
		int result = memberDAO.memberInsert(memberDTO);
		request.setAttribute("memberId", memberDTO.getMemberId());
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		handlerAdapter.setPath("/WEB-INF/view/member/member_reg_result.jsp");
		return handlerAdapter;
	}
}
