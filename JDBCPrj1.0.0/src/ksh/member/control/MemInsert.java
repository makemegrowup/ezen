package ksh.member.control;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.action.MemAction;
import ksh.member.dao.MemDAO;
import ksh.member.dto.MemDTO;

public class MemInsert implements MemAction {
	private static final Log log = LogFactory.getLog(MemInsert.class);

	@Override
	public void execute(Scanner scanner) {
		MemDAO memDAO = new MemDAO();
		MemDTO memDTO = new MemDTO();
		ArrayList<MemDTO> arrayList = new ArrayList<MemDTO>();
		System.out.println("회원을 등록하세요.");
		System.out.print("회원 번호 : ");
		int no = scanner.nextInt();
		arrayList = memDAO.memSelectAll();
		log.info("데이터 확인 - " + arrayList);

		for (MemDTO memDTO2 : arrayList) {
			if (memDTO2.getNo() == no) {
				System.out.println("이미 등록한 회원번호가 있습니다.");
				return;
			}
		}
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

		memDTO = memDAO.memInsert(no, identity, passWd, name, birth, gender, address, phoneNum, email, phoneNum2,
				companyNum, companyAddress);
		log.info("데이터 확인 - " + memDTO);
		System.out.println("새로운 회원을 등록했습니다.");

	}
}
