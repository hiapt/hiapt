package notice.model.vo;

public class NoticeFiles implements java.io.Serializable{
	private static final long serialVersionUID =1106L;
	
	private int noticeNo;
	private String noticeOriginalFileName;
	private String noticeRnameFileName;
	private String noticeFileSize;
	
	public NoticeFiles() {}
	
	public NoticeFiles(int noticeNo, String noticeOriginalFileName, String noticeRnameFileName, String noticeFileSize) {
		
		this.noticeNo = noticeNo;
		this.noticeOriginalFileName = noticeOriginalFileName;
		this.noticeRnameFileName = noticeRnameFileName;
		this.noticeFileSize = noticeFileSize;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeOriginalFileName() {
		return noticeOriginalFileName;
	}

	public void setNoticeOriginalFileName(String noticeOriginalFileName) {
		this.noticeOriginalFileName = noticeOriginalFileName;
	}

	public String getNoticeRnameFileName() {
		return noticeRnameFileName;
	}

	public void setNoticeRnameFileName(String noticeRnameFileName) {
		this.noticeRnameFileName = noticeRnameFileName;
	}

	public String getNoticeFileSize() {
		return noticeFileSize;
	}

	public void setNoticeFileSize(String noticeFileSize) {
		this.noticeFileSize = noticeFileSize;
	}

	@Override
	public String toString() {
		return "NoticeFiles [noticeNo=" + noticeNo + ", noticeOriginalFileName=" + noticeOriginalFileName
				+ ", noticeRnameFileName=" + noticeRnameFileName + ", noticeFileSize=" + noticeFileSize + "]";
	}


	
	
	
	
	
}
