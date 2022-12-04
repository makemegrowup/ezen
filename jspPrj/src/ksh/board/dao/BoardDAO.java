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
	
	public List<BoardDTO> boardSelectAll(int currentPage, int rowLimitSize) {
		
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		int startRow = (currentPage-1)*10 +1; 		// 해당 페이지 시작 행
		int endRow = startRow+rowLimitSize-1;	// 해당 페이지 마지막 행
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "SELECT*FROM(SELECT ROWNUM RNUM ,BOARD_NUM, TITLE, MEMBER_ID, TO_CHAR(BOARD_REGDATE,'YYYY-MM-DD') WRITEDAY,READCOUNT " + 
					"FROM (SELECT * FROM BOARD ORDER BY BOARD_REGDATE DESC, BOARD_NUM DESC)) " + 
					"WHERE RNUM BETWEEN ? AND ?";
//			String sql = "SELECT * FROM (SELECT ROWNUM, RNUM BOARD_NUM, TITLE, MEMBER_ID, TO_CHAR(BOARD_REGDATE,'YYYY-MM-DD') WRITEDAY,READCOUNT " + 
//					"FROM (SELECT * FROM BOARD ORDER BY BOARD_REGDATE DESC, BOARD_NUM DESC)) ";
//			sql += "WHERE RNUM >= ? AND RNUM <= ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			
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

	public int boardListCount() {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) FROM BOARD";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (Exception e) {
			log.info("게시글 수 구하기 실패 - " + e);
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

	@Override
	public void boardReadCountUp(int boardNum) {
		
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE BOARD_NUM=?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, boardNum);
			result = preparedStatement.executeUpdate();
			log.info("result값 - " + result);
			if(result > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("조회수 업데이트 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public int boardSearchCount(String keyword, String keyfield) {
		log.info("검색 영역 확인 - " + keyfield);
		log.info("검색 단어 확인 - " + keyword);
		String searchCall = "";
		if(!keyword.equals("")) {
			if(keyfield.equals("all")) {
				searchCall = "TITLE LIKE '%" + keyword +"%' OR MEMBER_ID LIKE '%" + keyword +"%' OR CONTENT LIKE '%" + keyword +"%'";
			} else if(keyfield.equals("title")) {
				searchCall = "TITLE LIKE '%" + keyword +"%'";
			} else if(keyfield.equals("memberId")) {
				searchCall = "MEMBER_ID LIKE '%" + keyword +"%'";
			} else if(keyfield.equals("content")) {
				searchCall = "CONTENT LIKE '%\" + keyword +\"%'";
			}
		}
		log.info("검색 - " + searchCall);
		
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM (SELECT BOARD_NUM, TITLE, CONTENT, MEMBER_ID, TO_CHAR(BOARD_REGDATE,'YYYY-MM-DD') WRITEDAY,READCOUNT " 
					+ "FROM (SELECT*FROM BOARD ORDER BY BOARD_REGDATE DESC, BOARD_NUM DESC)) "
					+ "WHERE ";
			sql += searchCall;
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (Exception e) {
			log.info("검색 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}

	@Override
	public List<?> boardSearch(String keyword, String keyfield, int currentPage, int rowLimitSize) {
		log.info("검색 영역 확인 - " + keyfield);
		log.info("검색 단어 확인 - " + keyword);
		String searchCall = "";
		if(!keyword.equals("")) {
			if(keyfield.equals("all")) {
				searchCall = "(TITLE LIKE '%" + keyword +"%') OR (MEMBER_ID LIKE '%" + keyword +"%') OR (CONTENT LIKE '%" + keyword +"%')";
			} else if(keyfield.equals("title")) {
				searchCall = "TITLE LIKE '%" + keyword +"%'";
			} else if(keyfield.equals("memberId")) {
				searchCall = "MEMBER_ID LIKE '%" + keyword +"%'";
			} else if(keyfield.equals("content")) {
				searchCall = "CONTENT LIKE '%" + keyword + "%'";
			}
		} 
		List<BoardDTO> searchList = new ArrayList<BoardDTO>();
		int startRow = (currentPage-1)*10+1;
		int endRow = startRow+rowLimitSize-1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "SELECT * FROM(SELECT ROWNUM RNUM, BOARD_NUM, TITLE, CONTENT, MEMBER_ID, TO_CHAR(BOARD_REGDATE,'YYYY-MM-DD') WRITEDAY,READCOUNT " + 
					"FROM (SELECT*FROM BOARD ORDER BY BOARD_REGDATE DESC, BOARD_NUM DESC) ";
			sql += "WHERE " + searchCall + ") WHERE RNUM BETWEEN ? AND ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startRow);
			preparedStatement.setInt(2, endRow);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setBoardNum(resultSet.getInt("BOARD_NUM"));
				boardDTO.setTitle(resultSet.getString("TITLE"));
				boardDTO.setMemberId(resultSet.getString("MEMBER_ID"));
				boardDTO.setBoardRegdate(resultSet.getString("WRITEDAY"));
				boardDTO.setReadCount(resultSet.getInt("READCOUNT"));
				searchList.add(boardDTO);
			}
			return searchList;
		} catch (Exception e) {
			log.info("검색 실패 - " + e);
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

//	public boolean boardDeleteCheck(String memberId) {
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			Context context = new InitialContext();
//			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
//			connection = dataSource.getConnection();
//			
//			String sql = "SELECT * FROM MEMBER_INFO WHERE MEMBER_ID=?";
//			log.info("SQL 확인 - " + sql);
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, memberId);
//			resultSet = preparedStatement.executeQuery();
//			if(resultSet.next()) {
//				if(memberId.equals(resultSet.getString("MEMBER_ID"))) {
//					return true;					
//				}
//			}
//		} catch (Exception e) {
//			log.info("작성자 확인 실패 - " + e);
//		} finally {
//			try {
//				resultSet.close();
//				preparedStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return false;
//	}
}
