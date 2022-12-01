package ksh.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.dto.MemberDTO;
import ksh.member.service.MemberService;

public class MemberDAO implements MemberService{
	
	private static Log log = LogFactory.getLog(MemberDAO.class);
	
	@Override
	public int memberInsert(MemberDTO memberDTO) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "INSERT INTO MEMBER_INFO(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, BIRTH, POSTALCODE," + 
					"            ADDRESS, ADDRESS_DETAIL, ADDRESS_EXTRA, CELLPHONE, EMAIL, SUBCELLPHONE," + 
					"            COMPANY_NUMBER) ";
			sql += "VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?,?,?,?,?)";
			log.info("SQL - " + sql);
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMemberId());
			preparedStatement.setString(2, memberDTO.getMemberPwd());
			preparedStatement.setString(3, memberDTO.getMemberName());
			preparedStatement.setString(4, memberDTO.getBirth());
			preparedStatement.setString(5, memberDTO.getPostalcode());
			preparedStatement.setString(6, memberDTO.getAddress());
			preparedStatement.setString(7, memberDTO.getAddressDetail());
			preparedStatement.setString(8, memberDTO.getAddressExtra());
			preparedStatement.setString(9, memberDTO.getCellphone());
			preparedStatement.setString(10, memberDTO.getEmail());
			preparedStatement.setString(11, memberDTO.getSubCellphone());
			preparedStatement.setString(12, memberDTO.getCompanyNumber());
			
			result = preparedStatement.executeUpdate();
			log.info("입력 데이터 확인 - " + memberDTO);
			if(result > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("회원 가입 실패 - " + e);
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) {
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "SELECT * FROM MEMBER_INFO WHERE MEMBER_ID=?";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMemberId());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				memberDTO.setMemberName(resultSet.getString("MEMBER_NAME"));
				memberDTO.setMemberId(resultSet.getString("MEMBER_ID"));
				log.info("MEMBER_NAME 확인 - " + resultSet.getString("MEMBER_NAME"));
				log.info("아이디 확인 - " + resultSet.getString("MEMBER_ID"));
				if(resultSet.getString("MEMBER_PWD").equals(memberDTO.getMemberPwd())) {
					memberDTO.setMemberPwd(resultSet.getString("MEMBER_PWD"));
					log.info("비밀번호 확인 - " + resultSet.getString("MEMBER_PWD"));
				} else {
					memberDTO.setMemberPwd("");
				}
			} else {
				memberDTO.setMemberId("");
			}
		} catch (Exception e) {
			log.info("로그인 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberDTO;
	}
	
	@Override
	public List<MemberDTO> memberSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MemberDTO memberSelectDetail(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int memberUpdate(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int memberDelete(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
