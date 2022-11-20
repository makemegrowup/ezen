package ksh.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.member.dbcp.Context;
import ksh.member.dto.MemDTO;
import ksh.member.service.MemService;

public class MemDAO implements MemService {
	private static final Log log = LogFactory.getLog(MemDAO.class);

	@Override
	public ArrayList<MemDTO> memSelectAll() {
		ArrayList<MemDTO> arrayList = new ArrayList<MemDTO>();
		// 전체 데이터 저장할 ArrayList 인스턴스 생성
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();

			String sql = "SELECT NO,IDENTITY,PASSWD,NAME,TO_CHAR(BIRTH,'YYYY-MM-DD') BIRTH,"
					+ "GENDER,ADDRESS,PHONENUM,EMAIL,PHONENUM2,COMPANYNUM,COMPANYADDRESS FROM MEMBER";
			log.info("SQL - " + sql);
//			String sql2 = "SELECT NO,NAME,IDENTITY,ADDRESS,PHONENUM FROM MEMBER";

			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MemDTO memDTO = new MemDTO();
				memDTO.setNo(resultSet.getInt("NO"));
				memDTO.setIdentity(resultSet.getString("IDENTITY"));
				memDTO.setPassWd(resultSet.getString("PASSWD"));
				memDTO.setName(resultSet.getString("NAME"));
				memDTO.setBirth(resultSet.getString("BIRTH"));
				memDTO.setGender(resultSet.getString("GENDER"));
				memDTO.setAddress(resultSet.getString("ADDRESS"));
				memDTO.setPhoneNum(resultSet.getString("PHONENUM"));
				memDTO.setEmail(resultSet.getString("EMAIL"));
				memDTO.setPhoneNum2(resultSet.getString("PHONENUM2"));
				memDTO.setCompanyNum(resultSet.getString("COMPANYNUM"));
				memDTO.setCompanyAddress(resultSet.getString("COMPANYADDRESS"));
				arrayList.add(memDTO);
			}
//			while(resultSet.next()) {
//				MemDTO memDTO = new MemDTO();
//				memDTO.setNo(resultSet.getInt("NO"));
//				memDTO.setIdentity(resultSet.getString("IDENTITY"));
//				memDTO.setName(resultSet.getString("NAME"));
//				memDTO.setAddress(resultSet.getString("ADDRESS"));
//				memDTO.setPhoneNum(resultSet.getString("PHONENUM"));
//				arrayList.add(memDTO);
//			}
			System.out.println(resultSet.getRow() + "행이 조회되었습니다.");

			if (resultSet.getRow() == 0) {
				log.info("등록된 회원이 없습니다.");
			}
		} catch (Exception e) {
			log.info("예외 확인 - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public MemDTO memInsert(int no, String identity, String passWd, String name, String birth, String gender,
			String address, String phoneNum, String email, String phoneNum2, String companyNum, String companyAddress) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		MemDTO memDTO = new MemDTO();
		memDTO.setNo(no);
		memDTO.setIdentity(identity);
		memDTO.setPassWd(passWd);
		memDTO.setName(name);
		memDTO.setBirth(birth);
		memDTO.setGender(gender);
		memDTO.setAddress(address);
		memDTO.setPhoneNum(phoneNum);
		memDTO.setEmail(email);
		memDTO.setPhoneNum2(phoneNum2);
		memDTO.setCompanyNum(companyNum);
		memDTO.setCompanyAddress(companyAddress);

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();

			String sql = "INSERT INTO MEMBER(NO,IDENTITY,PASSWD,NAME,BIRTH,GENDER,ADDRESS,PHONENUM,EMAIL,PHONENUM2,COMPANYNUM,COMPANYADDRESS) ";
			sql += "VALUES(?,?,?,?,TO_DATE(?,('YYYY-MM-DD')),?,?,?,?,?,?,?)";
			log.info("SQL - " + sql);

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, memDTO.getNo());
			preparedStatement.setString(2, memDTO.getIdentity());
			preparedStatement.setString(3, memDTO.getPassWd());
			preparedStatement.setString(4, memDTO.getName());
			preparedStatement.setString(5, memDTO.getBirth());
			preparedStatement.setString(6, memDTO.getGender());
			preparedStatement.setString(7, memDTO.getAddress());
			preparedStatement.setString(8, memDTO.getPhoneNum());
			preparedStatement.setString(9, memDTO.getEmail());
			preparedStatement.setString(10, memDTO.getPhoneNum2());
			preparedStatement.setString(11, memDTO.getCompanyNum());
			preparedStatement.setString(12, memDTO.getCompanyAddress());

			int cnt = preparedStatement.executeUpdate();
			log.info("수행한 행의 갯수 = " + cnt);

		} catch (Exception e) {
			log.info("예외 확인 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return memDTO;
	}

	@Override
	public MemDTO memUpdate(int no, String identity, String passWd, String name, String birth, String gender,
			String phoneNum, String address, String email, String phoneNum2, String companyNum, String companyAddress) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		MemDTO memDTO = new MemDTO();
		memDTO.setNo(no);
		memDTO.setIdentity(identity);
		memDTO.setPassWd(passWd);
		memDTO.setName(name);
		memDTO.setBirth(birth);
		memDTO.setGender(gender);
		memDTO.setPhoneNum(phoneNum);
		memDTO.setAddress(address);
		memDTO.setEmail(email);
		memDTO.setPhoneNum2(phoneNum2);
		memDTO.setCompanyNum(companyNum);
		memDTO.setCompanyAddress(companyAddress);

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();

			String sql = "UPDATE MEMBER SET IDENTITY=?,PASSWD=?,NAME=?,BIRTH=TO_DATE(?,('YYYY-MM-DD')),"
					+ "GENDER=?,PHONENUM=?,ADDRESS=?,EMAIL=?," + "PHONENUM2=?,COMPANYNUM=?,COMPANYADDRESS=? ";
			sql += "WHERE NO=?";
			log.info("SQL - " + sql);
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, memDTO.getIdentity());
			preparedStatement.setString(2, memDTO.getPassWd());
			preparedStatement.setString(3, memDTO.getName());
			preparedStatement.setString(4, memDTO.getBirth());
			preparedStatement.setString(5, memDTO.getGender());
			preparedStatement.setString(6, memDTO.getPhoneNum());
			preparedStatement.setString(7, memDTO.getAddress());
			preparedStatement.setString(8, memDTO.getEmail());
			preparedStatement.setString(9, memDTO.getPhoneNum2());
			preparedStatement.setString(10, memDTO.getCompanyNum());
			preparedStatement.setString(11, memDTO.getCompanyAddress());
			preparedStatement.setInt(12, memDTO.getNo());

			int cnt = preparedStatement.executeUpdate();
			log.info("수행한 행의 갯수 = " + cnt);

		} catch (Exception e) {
			log.info("예외 확인 - " + e);

		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return memDTO;
	}

	@Override
	public MemDTO memDelete(int no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		MemDTO memDTO = new MemDTO();
		memDTO.setNo(no);

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			String sql = "DELETE FROM MEMBER ";
			sql += "WHERE NO = ?";
			log.info("SQL - " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, memDTO.getNo());

			int cnt = preparedStatement.executeUpdate();
			log.info("수행한 행의 갯수 = " + cnt);

		} catch (Exception e) {
			log.info("예외 확인 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memDTO;
	}

	@Override
	public MemDTO memSelect(int no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		MemDTO memDTO = new MemDTO();

		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();

			String sql = "SELECT * FROM MEMBER ";
			sql += "WHERE NO=?";
			log.info("SQL - " + sql);

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, no);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				memDTO.setNo(resultSet.getInt("NO"));
				memDTO.setIdentity(resultSet.getString("IDENTITY"));
				memDTO.setPassWd(resultSet.getString("PASSWD"));
				memDTO.setName(resultSet.getString("NAME"));
				memDTO.setBirth(resultSet.getString("BIRTH"));
				memDTO.setGender(resultSet.getString("GENDER"));
				memDTO.setAddress(resultSet.getString("ADDRESS"));
				memDTO.setPhoneNum(resultSet.getString("PHONENUM"));
				memDTO.setEmail(resultSet.getString("EMAIL"));
				memDTO.setPhoneNum2(resultSet.getString("PHONENUM2"));
				memDTO.setCompanyNum(resultSet.getString("COMPANYNUM"));
				memDTO.setCompanyAddress(resultSet.getString("COMPANYADDRESS"));
			}
		} catch (Exception e) {
			log.info("예외 확인 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memDTO;
	}

}
