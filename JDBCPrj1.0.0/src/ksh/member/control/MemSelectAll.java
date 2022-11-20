package ksh.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.action.MemAction;
import ksh.member.dao.MemDAO;
import ksh.member.dto.MemDTO;

public class MemSelectAll implements MemAction {
	private static final Log log = LogFactory.getLog(MemSelectAll.class);

	@Override
	public void execute(Scanner scanner) {
		ArrayList<MemDTO> arrayList = new ArrayList<MemDTO>();
		MemDAO memDAO = new MemDAO();
		arrayList = memDAO.memSelectAll();
		log.info("데이터 확인 - " + arrayList);
		boolean check = false;

		for (MemDTO memDTO : arrayList) {
			int no = memDTO.getNo();
			String identity = memDTO.getIdentity();
			String passWd = memDTO.getPassWd();
			String name = memDTO.getName();
			String birth = memDTO.getBirth();
			String gender = memDTO.getGender();
			String address = memDTO.getAddress();
			String phoneNum = memDTO.getPhoneNum();
			String email = memDTO.getEmail();
			String phoneNum2 = memDTO.getPhoneNum2();
			String companyNum = memDTO.getCompanyNum();
			String companyAddress = memDTO.getCompanyAddress();
			System.out.println(
					no + " " + identity + " " + passWd + " " + name + " " + birth + " " + gender + " " + address + " "
							+ phoneNum + " " + email + " " + phoneNum2 + " " + companyNum + " " + companyAddress);
			check = true;
		}

		if (check == false) {
			System.out.println("등록된 회원이 없습니다. 회원을 등록해 주세요.");
		}
	}
}
