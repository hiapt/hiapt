package notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{
	private static final long serialVersionUID = 1105l;
	private int noticeNo;
	private String noticeTitle;
	private java.sql.Date noticeDate;
	private String noticeContents;
	private int noticeReadCount;
	private String noticeWriter;
	
	public Notice() {}
	
	public Notice(int noticeNo, String noticeTitle, Date noticeDate, String noticeContents, int noticeReadCount,
			String noticeWriter) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContents = noticeContents;
		this.noticeReadCount = noticeReadCount;
		this.noticeWriter = noticeWriter;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public java.sql.Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(java.sql.Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public int getNoticeReadCount() {
		return noticeReadCount;
	}

	public void setNoticeReadCount(int noticeReadCount) {
		this.noticeReadCount = noticeReadCount;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeContents=" + noticeContents + ", noticeReadCount=" + noticeReadCount + ", noticeWriter="
				+ noticeWriter + "]";
	}
	
	
}
