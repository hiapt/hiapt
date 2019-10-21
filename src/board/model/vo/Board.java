package board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private static final long serialVersionUID =3102L;
	
	private int boardNo;
	private String boardTitle;
	private java.sql.Date boardDate;
	private String boardContents;
	private int boardReadCount;
	private String userId;
	private String boardWriter;
	
	public Board() {}

	public Board(int boardNo, String boardTitle, Date boardDate, String boardContents, int boardReadCount,
			String userId, String boardWriter) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardContents = boardContents;
		this.boardReadCount = boardReadCount;
		this.userId = userId;
		this.boardWriter = boardWriter;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public java.sql.Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(java.sql.Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate
				+ ", boardContents=" + boardContents + ", boardReadCount=" + boardReadCount + ", userId=" + userId
				+ ", boardWriter=" + boardWriter + "]";
	}
	
	
}
