package ksh.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.action.MemAction;
import ksh.member.dao.MemDAO;
import ksh.member.dto.MemDTO;

public class MemUpdate implements MemAction {
	private static final Log log = LogFactory.getLog(MemUpdate.class);

	@Override
	public void execute(Scanner scanner) {
		MemDAO memDAO = new MemDAO();
		ArrayList<MemDTO> arrayList = new ArrayList<MemDTO>();
		System.out.println("회원정보를 수정하세요.");
		System.out.print("회원 번호 : ");
		int no = scanner.nextInt();

		arrayList = memDAO.memSelectAll();
		log.info("데이터 확인 - " + arrayList);
		boolean check = false;
		for (MemDTO memDTO2 : arrayList) {
			if (memDTO2.getNo() == no) {
				System.out.print("회원 아이디 : ");
				String identity = scanner.next();
				System.out.print("비밀번호 : ");
				String passWd = scanner.next();
				System.out.print("이름 : ");
				String name = scanner.next();
				System.out.print("생년월일(8자리) : ");
				String birth = scanner.next();
				System.out.print("성별(M,W) : ");
				String gender = scanner.next();
				scanner.nextLine();
				System.out.print("주소 : ");
				String address = scanner.nextLine();
				System.out.print("연락처 : ");
				String phoneNum = scanner.next();
				System.out.print("이메일 : ");
				String email = scanner.next();
				System.out.print("휴대폰('-'구분자 없이 숫자만 11자리) : ");
				String phoneNum2 = scanner.next();
				scanner.nextLine();
				System.out.print("회사번호 : ");
				String companyNum = scanner.nextLine();
				System.out.print("회사주소 : ");
				String companyAddress = scanner.nextLine();

				MemDTO memDTO = new MemDTO();
				memDTO = memDAO.memUpdate(no, identity, passWd, name, birth, gender, phoneNum, address, email,
						phoneNum2, companyNum, companyAddress);
				log.info("데이터 확인 - " + memDTO);
				System.out.println("회원정보를 수정했습니다.");
				check = true;
				break;
			}
		}
		if (check == false) {
			System.out.println("수정할 회정 정보가 없습니다.");
		}
	}
}
