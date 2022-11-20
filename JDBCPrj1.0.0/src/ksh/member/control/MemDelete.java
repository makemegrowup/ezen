package ksh.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.action.MemAction;
import ksh.member.dao.MemDAO;
import ksh.member.dto.MemDTO;

public class MemDelete implements MemAction{
	private static final Log log = LogFactory.getLog(MemDelete.class);
	@Override
	public void execute(Scanner scanner) {
		MemDAO memDAO= new MemDAO();
		ArrayList<MemDTO> arrayList= new ArrayList<MemDTO>();
		System.out.println("삭제할 회원의 번호를 입력하세요.");
		System.out.print("회원 번호 : ");
		int no = scanner.nextInt();
		
		arrayList = memDAO.memSelectAll();
		log.info("데이터 확인 - " + arrayList);
		boolean check = false;
		
		for (MemDTO memDTO2 : arrayList) {
			if (memDTO2.getNo() == no) {
				MemDTO memDTO = new MemDTO();
				memDTO = memDAO.memDelete(no);
				log.info("데이터 확인 - " + memDTO);
				System.out.println("회원정보를 삭제했습니다.");
				check = true;
				break;
			}
		}
		if(check == false) {
			System.out.println("삭제할 회원정보가 없습니다.");
		}
	}
}
