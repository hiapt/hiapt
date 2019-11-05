package mail.model.vo;

import java.sql.Date;

public class Mailm implements java.io.Serializable{
	private static final long SerialversionUID = 7000L;
	
	private int mailNo;
	private int mailCode;
	private String empEmail;
	private String mailTitle;
	private java.sql.Date mailTime;
	private String mailContents;
	private String recipient;
	private String mailBoxName;
	private String separator;
	private String fileYN;
	
	public Mailm() {}

	public Mailm(int mailNo, int mailCode, String empEmail, String mailTitle, Date mailTime, String mailContents,
			String recipient, String mailBoxName, String separator, String fileYN) {
		super();
		this.mailNo = mailNo;
		this.mailCode = mailCode;
		this.empEmail = empEmail;
		this.mailTitle = mailTitle;
		this.mailTime = mailTime;
		this.mailContents = mailContents;
		this.recipient = recipient;
		this.mailBoxName = mailBoxName;
		this.separator = separator;
		this.fileYN = fileYN;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}

	public int getMailCode() {
		return mailCode;
	}

	public void setMailCode(int mailCode) {
		this.mailCode = mailCode;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public java.sql.Date getMailTime() {
		return mailTime;
	}

	public void setMailTime(java.sql.Date mailTime) {
		this.mailTime = mailTime;
	}

	public String getMailContents() {
		return mailContents;
	}

	public void setMailContents(String mailContents) {
		this.mailContents = mailContents;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMailBoxName() {
		return mailBoxName;
	}

	public void setMailBoxName(String mailBoxName) {
		this.mailBoxName = mailBoxName;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getFileYN() {
		return fileYN;
	}

	public void setFileYN(String fileYN) {
		this.fileYN = fileYN;
	}

	@Override
	public String toString() {
		return "Mailm [mailNo=" + mailNo + ", mailCode=" + mailCode + ", empEmail=" + empEmail + ", mailTitle="
				+ mailTitle + ", mailTime=" + mailTime + ", mailContents=" + mailContents + ", recipient=" + recipient
				+ ", mailBoxName=" + mailBoxName + ", separator=" + separator + ", fileYN=" + fileYN + "]";
	}

	
}
