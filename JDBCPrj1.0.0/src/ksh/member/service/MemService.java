package ksh.member.service;

import java.util.ArrayList;

import ksh.member.dto.MemDTO;

public interface MemService {
	public ArrayList<MemDTO> memSelectAll();
	
	public MemDTO memSelect(int no);
	
	public MemDTO memInsert(
		int no,
		String identity,
		String passWd,
		String name,
		String birth,
		String gender,
		String address,
		String phoneNum,
		String email,
		String phoneNum2,
		String companyNum,
		String companyAddress);
	
	public MemDTO memUpdate(
		int no,
		String identity,
		String passWd,
		String name,
		String birth,
		String gender,
		String phoneNum,
		String address,
		String email,
		String phoneNum2,
		String companyNum,
		String companyAddress
	);
	
	public MemDTO memDelete(int no);
}
