package ksh.member.view;

import java.util.Scanner;

import ksh.member.control.MemDelete;
import ksh.member.control.MemInsert;
import ksh.member.control.MemSelect;
import ksh.member.control.MemSelectAll;
import ksh.member.control.MemUpdate;

public class MemMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("\n 메뉴 번호를 선택하세요.");
			System.out.println("1. 회원 전체 조회 " + "2. 회원 등록 " + "3. 회원 수정 " + "4. 회원 삭제 " + "5. 회원 상세 조회 " + "6. 종료");
			System.out.print("번호 입력 : ");
			String menu = scanner.next();
			
			switch (menu) {
			case "1":
				MemSelectAll memSelectAll = new MemSelectAll();
				memSelectAll.execute(scanner);
				break;
			case "2":
				MemInsert memInsert= new MemInsert();
				memInsert.execute(scanner);
				break;
			case "3":
				MemUpdate memUpdate = new MemUpdate();
				memUpdate.execute(scanner);
				break;
			case "4":
				MemDelete memDelete= new MemDelete();
				memDelete.execute(scanner);
				break;
			case "5":
				MemSelect memSelect= new MemSelect();
				memSelect.execute(scanner);
				break;
			case "6":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("1번에서 6번 중의 번호를 선택하세요.");
				break;
			}
		} while (true);
	}
}
