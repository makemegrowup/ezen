package ksh.board.dto;

import java.util.Date;

public class BoardDTO {

	    // 게시글번호 
	    private int boardNum;

	    // 아이디 
	    private String memberId;

	    // 제목 
	    private String title;

	    // 내용 
	    private String content;

	    // 게시글등록일 
	    private Date boardRegdate;

	    // 조회수 
	    private int readcount;

	    public int getBoardNum() {
	        return boardNum;
	    }

	    public void setBoardNum(int boardNum) {
	        this.boardNum = boardNum;
	    }

	    public String getMemberId() {
	        return memberId;
	    }

	    public void setMemberId(String memberId) {
	        this.memberId = memberId;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public Date getBoardRegdate() {
	        return boardRegdate;
	    }

	    public void setBoardRegdate(Date boardRegdate) {
	        this.boardRegdate = boardRegdate;
	    }

	    public int getReadcount() {
	        return readcount;
	    }

	    public void setReadcount(int readcount) {
	        this.readcount = readcount;
	    }

		@Override
		public String toString() {
			return "BoardDTO [boardNum=" + boardNum + ", memberId=" + memberId + ", title=" + title + ", content="
					+ content + ", readcount=" + readcount + "]";
		}

	    
}
