package board.model.vo;

public class BoardFiles implements java.io.Serializable{
	private static final long serialVersionUID =3105L;
	
	private int boardNo;
	private String boardOriginalFileName;
	private String boardRnameFileName;
	
	public BoardFiles() {}
	
	public BoardFiles(int boardNo, String boardOriginalFileName, String boardRnameFileName) {
		super();
		this.boardNo = boardNo;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRnameFileName = boardRnameFileName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}

	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}

	public String getBoardRnameFileName() {
		return boardRnameFileName;
	}

	public void setBoardRnameFileName(String boardRnameFileName) {
		this.boardRnameFileName = boardRnameFileName;
	}

	@Override
	public String toString() {
		return "BoardFiles [boardNo=" + boardNo + ", boardOriginalFileName=" + boardOriginalFileName
				+ ", boardRnameFileName=" + boardRnameFileName + "]";
	}
	
	
	
}
