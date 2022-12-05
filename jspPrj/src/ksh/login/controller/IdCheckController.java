package ksh.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.common.control.Controller;
import ksh.common.handler.HandlerAdapter;
import ksh.member.dao.MemberDAO;

public class IdCheckController implements Controller {

	private static Log log = LogFactory.getLog(IdCheckController.class);
	
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		
		String memberId = request.getParameter("memberId");
		log.info(memberId);
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.memberIdCheck(memberId);
		if(result == 1) {
			log.info("존재하는 아이디 - " + memberId);
		} else {
			log.info("존재하지 않는 아이디 - " + memberId);
		}
		try {
			PrintWriter out = response.getWriter();
			out.write(result+"");
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		HandlerAdapter handlerAdapter = new HandlerAdapter();
//		handlerAdapter.setPath("WEB-INF/view/member/member_reg_view.jsp");
		return null;
	}

}
