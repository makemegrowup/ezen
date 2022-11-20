package ksh.member.control;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.action.MemAction;
import ksh.member.dao.MemDAO;
import ksh.member.dto.MemDTO;

public class MemSelect implements MemAction {
	private static final Log log = LogFactory.getLog(MemSelect.class);

	@Override
	public void execute(Scanner scanner) {
		MemDAO memDAO = new MemDAO();
		MemDTO memDTO = new MemDTO();
		System.out.println("회원 번호를 입력하세요.");
		System.out.print("회원 번호 : ");
		int no = scanner.nextInt();

		memDTO = memDAO.memSelect(no);
		log.info("데이터 확인 - " + memDTO);
		no = memDTO.getNo();
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
		if (memDTO.getNo() == 0) {
			System.out.println("등록된 회원 번호가 없습니다.");
		} else {
			System.out.println(
					no + " " + identity + " " + passWd + " " + name + " " + birth + " " + gender + " " + address + " "
							+ phoneNum + " " + email + " " + phoneNum2 + " " + companyNum + " " + companyAddress);
		}

	}
}
