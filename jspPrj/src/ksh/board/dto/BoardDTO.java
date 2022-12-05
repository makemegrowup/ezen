package ksh.board.dto;

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
	    private String boardRegdate;

	    // 조회수 
	    private int readCount;

	    // 게시판 비밀번호
	    private String boardPwd;
	    
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

	    public String getBoardRegdate() {
	        return boardRegdate;
	    }

	    public void setBoardRegdate(String boardRegdate) {
	        this.boardRegdate = boardRegdate;
	    }

	    public int getReadCount() {
	        return readCount;
	    }

	    public void setReadCount(int readCount) {
	        this.readCount = readCount;
	    }

	    
		public String getBoardPwd() {
			return boardPwd;
		}

		public void setBoardPwd(String boardPwd) {
			this.boardPwd = boardPwd;
		}

		@Override
		public String toString() {
			return "BoardDTO [boardNum=" + boardNum + ", memberId=" + memberId + ", title=" + title + ", content="
					+ content + ", boardRegdate=" + boardRegdate + ", readCount=" + readCount + ", boardPwd=" + boardPwd
					+ "]";
		}

		
	    
}
