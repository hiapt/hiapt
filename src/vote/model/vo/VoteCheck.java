package vote.model.vo;

public class VoteCheck implements java.io.Serializable{
	private static final long serialVersionUID =3902L;
	
	private String userId;
	private String userName;
	private int voteNo;
	private String voteResult;
	
	public VoteCheck() {}

	public VoteCheck(String userId, String userName, int voteNo, String voteResult) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.voteNo = voteNo;
		this.voteResult = voteResult;
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

	public int getVoteNo() {
		return voteNo;
	}

	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}

	public String getVoteResult() {
		return voteResult;
	}

	public void setVoteResult(String voteResult) {
		this.voteResult = voteResult;
	}

	@Override
	public String toString() {
		return "VoteCheck [userId=" + userId + ", userName=" + userName + ", voteNo=" + voteNo + ", voteResult="
				+ voteResult + "]";
	}
	
	
}
