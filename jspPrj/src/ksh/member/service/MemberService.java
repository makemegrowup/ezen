package ksh.member.service;

import java.util.List;

import ksh.member.dto.MemberDTO;

public interface MemberService {

	// 회원 전체조회
	public List<MemberDTO> memberSelectAll();
	// 회원 상세조회 
	public MemberDTO memberSelectDetail(String memberId);
	// 회원 가입
	public int memberInsert(MemberDTO memberDTO);
	// 회원 삭제
	public int memberDelete(String memberId);
	// 회원 수정
	public int memberUpdate(MemberDTO memberDTO);
	// 로그인
	public MemberDTO memberLogin(MemberDTO memberDTO);
	// 아이디 중복체크
	public int memberIdCheck(String memberId);
}
