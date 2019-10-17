package vote.model.vo;

import java.sql.Date;

public class Vote implements java.io.Serializable{
	private static final long serialVersionUID =3001L;
	private int voteNo;
	private String voteTitle;
	private String voteWrite;
	private java.sql.Date voteDate;
	private java.sql.Date voteFinalDate;
	private int voteReadCount;
	private String voteSecret; 
	private String voteContents;
	private String voteOne;
	private String voteTwo;
	private String voteThree;
	private String voteFour;
	private String voteFive;
	
	public Vote() {}

	public Vote(int voteNo, String voteTitle, String voteWrite, Date voteDate, Date voteFinalDate, int voteReadCount,
			String voteSecret, String voteContents, String voteOne, String voteTwo, String voteThree, String voteFour,
			String voteFive) {
		super();
		this.voteNo = voteNo;
		this.voteTitle = voteTitle;
		this.voteWrite = voteWrite;
		this.voteDate = voteDate;
		this.voteFinalDate = voteFinalDate;
		this.voteReadCount = voteReadCount;
		this.voteSecret = voteSecret;
		this.voteContents = voteContents;
		this.voteOne = voteOne;
		this.voteTwo = voteTwo;
		this.voteThree = voteThree;
		this.voteFour = voteFour;
		this.voteFive = voteFive;
	}

	public int getVoteNo() {
		return voteNo;
	}

	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}

	public String getVoteTitle() {
		return voteTitle;
	}

	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}

	public String getVoteWrite() {
		return voteWrite;
	}

	public void setVoteWrite(String voteWrite) {
		this.voteWrite = voteWrite;
	}

	public java.sql.Date getVoteDate() {
		return voteDate;
	}

	public void setVoteDate(java.sql.Date voteDate) {
		this.voteDate = voteDate;
	}

	public java.sql.Date getVoteFinalDate() {
		return voteFinalDate;
	}

	public void setVoteFinalDate(java.sql.Date voteFinalDate) {
		this.voteFinalDate = voteFinalDate;
	}

	public int getVoteReadCount() {
		return voteReadCount;
	}

	public void setVoteReadCount(int voteReadCount) {
		this.voteReadCount = voteReadCount;
	}

	public String getVoteSecret() {
		return voteSecret;
	}

	public void setVoteSecret(String voteSecret) {
		this.voteSecret = voteSecret;
	}

	public String getVoteContents() {
		return voteContents;
	}

	public void setVoteContents(String voteContents) {
		this.voteContents = voteContents;
	}

	public String getVoteOne() {
		return voteOne;
	}

	public void setVoteOne(String voteOne) {
		this.voteOne = voteOne;
	}

	public String getVoteTwo() {
		return voteTwo;
	}

	public void setVoteTwo(String voteTwo) {
		this.voteTwo = voteTwo;
	}

	public String getVoteThree() {
		return voteThree;
	}

	public void setVoteThree(String voteThree) {
		this.voteThree = voteThree;
	}

	public String getVoteFour() {
		return voteFour;
	}

	public void setVoteFour(String voteFour) {
		this.voteFour = voteFour;
	}

	public String getVoteFive() {
		return voteFive;
	}

	public void setVoteFive(String voteFive) {
		this.voteFive = voteFive;
	}

	@Override
	public String toString() {
		return "Vote [voteNo=" + voteNo + ", voteTitle=" + voteTitle + ", voteWrite=" + voteWrite + ", voteDate="
				+ voteDate + ", voteFinalDate=" + voteFinalDate + ", voteReadCount=" + voteReadCount + ", voteSecret="
				+ voteSecret + ", voteContents=" + voteContents + ", voteOne=" + voteOne + ", voteTwo=" + voteTwo
				+ ", voteThree=" + voteThree + ", voteFour=" + voteFour + ", voteFive=" + voteFive + "]";
	}
	
	
	
	
}

