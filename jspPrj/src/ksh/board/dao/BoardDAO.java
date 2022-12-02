package ksh.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ksh.board.dto.BoardDTO;
import ksh.board.service.BoardService;

public class BoardDAO implements BoardService{

	private static Log log = LogFactory.getLog(BoardDAO.class);
	
	public List<BoardDTO> boardSelectAll() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "SELECT BOARD_NUM, TITLE, MEMBER_ID, TO_CHAR(BOARD_REGDATE,'YYYY-MM-DD') WRITEDAY,READCOUNT FROM " + 
					"(SELECT * FROM BOARD ORDER BY BOARD_REGDATE DESC, BOARD_NUM DESC)";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setBoardNum(resultSet.getInt("BOARD_NUM"));
				boardDTO.setTitle(resultSet.getString("TITLE"));
				boardDTO.setMemberId(resultSet.getString("MEMBER_ID"));
				boardDTO.setBoardRegdate(resultSet.getString("WRITEDAY"));
				boardDTO.setReadCount(resultSet.getInt("READCOUNT"));
				boardList.add(boardDTO);
			}
			return boardList;
		} catch (Exception e) {
			log.info("글 목록 불러오기 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public int boardInsert(BoardDTO boardDTO) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "INSERT INTO BOARD(MEMBER_ID,TITLE,CONTENT,BOARD_PWD) VALUES(?,?,?,?)";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getMemberId());
			preparedStatement.setString(2, boardDTO.getTitle());
			preparedStatement.setString(3, boardDTO.getContent());
			preparedStatement.setString(4, boardDTO.getBoardPwd());
			result = preparedStatement.executeUpdate();
			if(result > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("게시글 등록 실패 - " + e);
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
	public BoardDTO boardSelectDetail(int boardNum) {
		BoardDTO boardDTO = new BoardDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "SELECT BOARD_NUM, MEMBER_ID, TITLE, CONTENT, TO_CHAR(BOARD_REGDATE,'YYYY-MM-DD HH24:MI:SS') BOARD_REGDATE, READCOUNT"
					+ " FROM BOARD WHERE BOARD_NUM = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, boardNum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				boardDTO.setBoardNum(resultSet.getInt("BOARD_NUM"));
				boardDTO.setMemberId(resultSet.getString("MEMBER_ID"));
				boardDTO.setTitle(resultSet.getString("TITLE"));
				boardDTO.setContent(resultSet.getString("CONTENT"));
				boardDTO.setBoardRegdate(resultSet.getString("BOARD_REGDATE"));
				boardDTO.setReadCount(resultSet.getInt("READCOUNT"));
			}
			return boardDTO;
		} catch (Exception e) {
			log.info("게시글 상세보기 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public int boardUpdate(BoardDTO boardDTO) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE BOARD_NUM=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getTitle());
			preparedStatement.setString(2, boardDTO.getContent());
			preparedStatement.setInt(3, boardDTO.getBoardNum());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
			
			return result;
		} catch (Exception e) {
			log.info("게시글 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public int boardDelete(int boardNum) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "DELETE FROM BOARD WHERE BOARD_NUM=?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, boardNum);
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("게시글 삭제 실패 - " + e);
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

}
