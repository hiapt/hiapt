package notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{
	private static final long serialVersionUID = 1105l;
	private int noticeNo;
	private String noticeTitle;
	private java.sql.Date noticeDate;
	private String noticeContents;
	private int noticeReadCount;
	private String noticeOriginalFileName;
	private String noticeRenameFileName;
	private String noticeWriter;
	private String fileYorN;
	
	public String getFileYorN() {
		return fileYorN;
	}

	public void setFileYorN(String fileYorN) {
		this.fileYorN = fileYorN;
	}

	public Notice() {}

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

	public String getNoticeOriginalFileName() {
		return noticeOriginalFileName;
	}

	public void setNoticeOriginalFileName(String noticeOriginalFileName) {
		this.noticeOriginalFileName = noticeOriginalFileName;
	}

	public String getNoticeRenameFileName() {
		return noticeRenameFileName;
	}

	public void setNoticeRenameFileName(String noticeRenameFileName) {
		this.noticeRenameFileName = noticeRenameFileName;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Notice(int noticeNo, String noticeTitle, Date noticeDate, String noticeContents, int noticeReadCount,
			String noticeOriginalFileName, String noticeRenameFileName, String noticeWriter, String fileYorN) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContents = noticeContents;
		this.noticeReadCount = noticeReadCount;
		this.noticeOriginalFileName = noticeOriginalFileName;
		this.noticeRenameFileName = noticeRenameFileName;
		this.noticeWriter = noticeWriter;
		this.fileYorN = fileYorN;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeContents=" + noticeContents + ", noticeReadCount=" + noticeReadCount
				+ ", noticeOriginalFileName=" + noticeOriginalFileName + ", noticeRenameFileName="
				+ noticeRenameFileName + ", noticeWriter=" + noticeWriter + ", fileYorN=" + fileYorN + "]";
	}

	
	
}
