package chat.model.vo;


public class ChatMessage implements java.io.Serializable{
	private static final long serialVersionUID =3271L;
	
	private String chatWriteDate;
	private String chatContents;
	private int chatOrder;
	private int chatNo;
	private String empNo;
	private String empName;
	
	public ChatMessage() {}

	public ChatMessage(String chatWriteDate, String chatContents, int chatOrder, int chatNo, String empNo,
			String empName) {
		super();
		this.chatWriteDate = chatWriteDate;
		this.chatContents = chatContents;
		this.chatOrder = chatOrder;
		this.chatNo = chatNo;
		this.empNo = empNo;
		this.empName = empName;
	}

	public String getChatWriteDate() {
		return chatWriteDate;
	}

	public void setChatWriteDate(String chatWriteDate) {
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

	@Override
	public String toString() {
		return "ChatMessage [chatWriteDate=" + chatWriteDate + ", chatContents=" + chatContents + ", chatOrder="
				+ chatOrder + ", chatNo=" + chatNo + ", empNo=" + empNo + ", empName=" + empName + "]";
	}

	
	
	
}
