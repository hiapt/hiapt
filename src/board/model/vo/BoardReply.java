package board.model.vo;

public class BoardReply  implements java.io.Serializable{
	private static final long serialVersionUID =4515L;
	
	private int boardNo;
	private int boardReplyOriginalNo;
	private int boardReplyGroupNo;
	private int boardReplyGroupOrder;
	private int boardReplyGroupLayer;
	private String boardReplyDate;
	private String boardReplyContents;
	private String userId;
	private String userName;
	
	public BoardReply() {}

	public BoardReply(int boardNo, int boardReplyOriginalNo, int boardReplyGroupNo, int boardReplyGroupOrder,
			int boardReplyGroupLayer, String boardReplyDate, String boardReplyContents, String userId,
			String userName) {
		super();
		this.boardNo = boardNo;
		this.boardReplyOriginalNo = boardReplyOriginalNo;
		this.boardReplyGroupNo = boardReplyGroupNo;
		this.boardReplyGroupOrder = boardReplyGroupOrder;
		this.boardReplyGroupLayer = boardReplyGroupLayer;
		this.boardReplyDate = boardReplyDate;
		this.boardReplyContents = boardReplyContents;
		this.userId = userId;
		this.userName = userName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getBoardReplyOriginalNo() {
		return boardReplyOriginalNo;
	}

	public void setBoardReplyOriginalNo(int boardReplyOriginalNo) {
		this.boardReplyOriginalNo = boardReplyOriginalNo;
	}

	public int getBoardReplyGroupNo() {
		return boardReplyGroupNo;
	}

	public void setBoardReplyGroupNo(int boardReplyGroupNo) {
		this.boardReplyGroupNo = boardReplyGroupNo;
	}

	public int getBoardReplyGroupOrder() {
		return boardReplyGroupOrder;
	}

	public void setBoardReplyGroupOrder(int boardReplyGroupOrder) {
		this.boardReplyGroupOrder = boardReplyGroupOrder;
	}

	public int getBoardReplyGroupLayer() {
		return boardReplyGroupLayer;
	}

	public void setBoardReplyGroupLayer(int boardReplyGroupLayer) {
		this.boardReplyGroupLayer = boardReplyGroupLayer;
	}

	public String getBoardReplyDate() {
		return boardReplyDate;
	}

	public void setBoardReplyDate(String boardReplyDate) {
		this.boardReplyDate = boardReplyDate;
	}

	public String getBoardReplyContents() {
		return boardReplyContents;
	}

	public void setBoardReplyContents(String boardReplyContents) {
		this.boardReplyContents = boardReplyContents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "BoardReply [boardNo=" + boardNo + ", boardReplyOriginalNo=" + boardReplyOriginalNo
				+ ", boardReplyGroupNo=" + boardReplyGroupNo + ", boardReplyGroupOrder=" + boardReplyGroupOrder
				+ ", boardReplyGroupLayer=" + boardReplyGroupLayer + ", boardReplyDate=" + boardReplyDate
				+ ", boardReplyContents=" + boardReplyContents + ", userId=" + userId + ", userName=" + userName + "]";
	}

	

}