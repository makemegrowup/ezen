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
			log.info("?????? ????????? ?????? - " + memberDTO);
			if(result > 0) {
				connection.commit();
				log.info("?????????????????????.");
			} else {
				connection.rollback();
				log.info("?????????????????????.");
			}
		} catch (Exception e) {
			log.info("?????? ?????? ?????? - " + e);
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
				log.info("MEMBER_NAME ?????? - " + resultSet.getString("MEMBER_NAME"));
				log.info("????????? ?????? - " + resultSet.getString("MEMBER_ID"));
				if(resultSet.getString("MEMBER_PWD").equals(memberDTO.getMemberPwd())) {
					memberDTO.setMemberPwd(resultSet.getString("MEMBER_PWD"));
					log.info("???????????? ?????? - " + resultSet.getString("MEMBER_PWD"));
				} else {
					memberDTO.setMemberPwd("");
				}
			} else {
				memberDTO.setMemberId("");
			}
		} catch (Exception e) {
			log.info("????????? ?????? - " + e);
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
		
		MemberDTO memberDTO = new MemberDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "SELECT MEMBER_ID,MEMBER_NAME,TO_CHAR(BIRTH,'YYYY-MM-DD') BIRTH,POSTALCODE,ADDRESS,ADDRESS_DETAIL,ADDRESS_EXTRA,CELLPHONE,EMAIL,"
					+ "SUBCELLPHONE,COMPANY_NUMBER,TO_CHAR(MEMBER_REGDATE,'YYYY-MM-DD') MEMBER_REGDATE "
					+ "FROM MEMBER_INFO WHERE MEMBER_ID=?";
			log.info("SQL ?????? - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				memberDTO.setMemberId(resultSet.getString("MEMBER_ID"));
				memberDTO.setMemberName(resultSet.getString("MEMBER_NAME"));
				memberDTO.setBirth(resultSet.getString("BIRTH"));
				memberDTO.setPostalcode(resultSet.getString("POSTALCODE"));
				memberDTO.setAddress(resultSet.getString("ADDRESS"));
				memberDTO.setAddressDetail(resultSet.getString("ADDRESS_DETAIL"));
				memberDTO.setAddressExtra(resultSet.getString("ADDRESS_EXTRA"));
				memberDTO.setCellphone(resultSet.getString("CELLPHONE"));
				memberDTO.setEmail(resultSet.getString("EMAIL"));
				memberDTO.setSubCellphone(resultSet.getString("SUBCELLPHONE"));
				memberDTO.setCompanyNumber(resultSet.getString("COMPANY_NUMBER"));
				memberDTO.setMemberRegdate(resultSet.getString("MEMBER_REGDATE"));
				memberDTO.setMemberAddress(resultSet.getString("POSTALCODE"), resultSet.getString("ADDRESS"), resultSet.getString("ADDRESS_DETAIL"), resultSet.getString("ADDRESS_EXTRA"));
			}
		} catch (Exception e) {
			log.info("?????? ???????????? ?????? - " + e);
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
	public int memberUpdate(MemberDTO memberDTO) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "UPDATE MEMBER_INFO SET MEMBER_NAME=?, BIRTH = TO_DATE(?,'YYYY-MM-DD'), POSTALCODE=?, ADDRESS=?, ADDRESS_DETAIL=?, ";
			sql += "ADDRESS_EXTRA=?, CELLPHONE=?, EMAIL=?, SUBCELLPHONE=?, COMPANY_NUMBER=? ";
			sql += "WHERE MEMBER_ID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMemberName());
			preparedStatement.setString(2, memberDTO.getBirth());
			preparedStatement.setString(3, memberDTO.getPostalcode());
			preparedStatement.setString(4, memberDTO.getAddress());
			preparedStatement.setString(5, memberDTO.getAddressDetail());
			preparedStatement.setString(6, memberDTO.getAddressExtra());
			preparedStatement.setString(7, memberDTO.getCellphone());
			preparedStatement.setString(8, memberDTO.getEmail());
			preparedStatement.setString(9, memberDTO.getSubCellphone());
			preparedStatement.setString(10, memberDTO.getCompanyNumber());
			preparedStatement.setString(11, memberDTO.getMemberId());
			
			result = preparedStatement.executeUpdate();
			log.info("???????????? ?????? ?????? - " + result);
			if(result == 1) {
				connection.commit();
				log.info("?????????????????????.");
			} else {
				connection.rollback();
				log.info("?????????????????????.");
			}
		} catch (Exception e) {
			log.info("???????????? ?????? - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public int memberDelete(String memberId) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "DELETE FROM MEMBER_INFO WHERE MEMBER_ID=?";
			log.info("SQL ?????? - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberId);
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				log.info("?????????????????????.");
			} else {
				connection.rollback();
				log.info("?????????????????????.");
			}
		} catch (Exception e) {
			log.info("?????? ?????? ?????? - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@Override
	public int memberIdCheck(String memberId) {
		int result = 0;
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
			preparedStatement.setString(1, memberId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next() || memberId.equals("")) {
				result = 1;		// ???????????? ??????
			} else {
				result = 0;		// ???????????? ?????? ??????
			}
			
		} catch (Exception e) {
			log.info("?????? ????????? ?????? ?????? - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
