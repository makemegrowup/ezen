package ksh.board.service;

import java.util.List;

import ksh.board.dto.BoardDTO;

public interface BoardService {
	
	// 게시판 전체 리스트 조회
	public List<BoardDTO> boardSelectAll();
	// 게시판 조회
	public BoardDTO boardSelectDetail(int boardNum);
	// 게시판 글쓰기
	public int boardInsert(BoardDTO boardDTO);
	// 게시판 삭제
	public int boardDelete(int boardNum);
	// 게시판 수정
	public int boardUpdate(BoardDTO boardDTO);
	// 게시글 개수
	public int boardCount();
	// 게시글 조회수
	public void boardReadCountUp(int boardNum);
}