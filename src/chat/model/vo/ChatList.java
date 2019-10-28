package chat.model.vo;

import java.sql.Date;

public class ChatList implements java.io.Serializable{
	private static final long serialVersionUID =3475L;
	
	private java.sql.Date chatWriteDate;
	private String chatContents;
	private int chatOrder;
	private int chatNo;
	private String empNo;
	private String empName;
	private String chatTitle;
	
	public ChatList() {}

	public ChatList(Date chatWriteDate, String chatContents, int chatOrder, int chatNo, String empNo, String empName,
			String chatTitle) {
		super();
		this.chatWriteDate = chatWriteDate;
		this.chatContents = chatContents;
		this.chatOrder = chatOrder;
		this.chatNo = chatNo;
		this.empNo = empNo;
		this.empName = empName;
		this.chatTitle = chatTitle;
	}

	public java.sql.Date getChatWriteDate() {
		return chatWriteDate;
	}

	public void setChatWriteDate(java.sql.Date chatWriteDate) {
		this.chatWriteDate = chatWriteDate;
	}

	public String getChatContents() {
		return chatContents;
	}

	public void setChatContents(String chatContents) {
		this.chatContents = chatContents;
	}

	public int getChatOrder() {
		return chatOrder;
	}

	public void setChatOrder(int chatOrder) {
		this.chatOrder = chatOrder;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getChatTitle() {
		return chatTitle;
	}

	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}

	@Override
	public String toString() {
		return "ChatList [chatWriteDate=" + chatWriteDate + ", chatContents=" + chatContents + ", chatOrder="
				+ chatOrder + ", chatNo=" + chatNo + ", empNo=" + empNo + ", empName=" + empName + ", chatTitle="
				+ chatTitle + "]";
	}
	
	
}
