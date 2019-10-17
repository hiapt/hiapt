package vote.model.vo;

public class VoteResult implements java.io.Serializable{
	private static final long serialVersionUID =3002L;
	private int voteNo;
	private int voteOneResult;
	private int voteTwoResult;
	private int voteThreeResult;
	private int voteFourResult;
	private int voteFiveResult;
	
	public VoteResult() {}

	public VoteResult(int voteNo, int voteOneResult, int voteTwoResult, int voteThreeResult, int voteFourResult,
			int voteFiveResult) {
		super();
		this.voteNo = voteNo;
		this.voteOneResult = voteOneResult;
		this.voteTwoResult = voteTwoResult;
		this.voteThreeResult = voteThreeResult;
		this.voteFourResult = voteFourResult;
		this.voteFiveResult = voteFiveResult;
	}

	public int getVoteNo() {
		return voteNo;
	}

	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}

	public int getVoteOneResult() {
		return voteOneResult;
	}

	public void setVoteOneResult(int voteOneResult) {
		this.voteOneResult = voteOneResult;
	}

	public int getVoteTwoResult() {
		return voteTwoResult;
	}

	public void setVoteTwoResult(int voteTwoResult) {
		this.voteTwoResult = voteTwoResult;
	}

	public int getVoteThreeResult() {
		return voteThreeResult;
	}

	public void setVoteThreeResult(int voteThreeResult) {
		this.voteThreeResult = voteThreeResult;
	}

	public int getVoteFourResult() {
		return voteFourResult;
	}

	public void setVoteFourResult(int voteFourResult) {
		this.voteFourResult = voteFourResult;
	}

	public int getVoteFiveResult() {
		return voteFiveResult;
	}

	public void setVoteFiveResult(int voteFiveResult) {
		this.voteFiveResult = voteFiveResult;
	}

	@Override
	public String toString() {
		return "VoteResult [voteNo=" + voteNo + ", voteOneResult=" + voteOneResult + ", voteTwoResult=" + voteTwoResult
				+ ", voteThreeResult=" + voteThreeResult + ", voteFourResult=" + voteFourResult + ", voteFiveResult="
				+ voteFiveResult + "]";
	}
	
	
}
