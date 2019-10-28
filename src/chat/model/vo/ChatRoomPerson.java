package chat.model.vo;

public class ChatRoomPerson implements java.io.Serializable{
	private static final long serialVersionUID =3211L;
	
	private int chatNo;
	private String empNo;
	private String chatTitle;
	
	public ChatRoomPerson() {}

	public ChatRoomPerson(int chatNo, String empNo, String chatTitle) {
		super();
		this.chatNo = chatNo;
		this.empNo = empNo;
		this.chatTitle = chatTitle;
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

	public String getChatTitle() {
		return chatTitle;
	}

	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}

	@Override
	public String toString() {
		return "ChatRoomPerson [chatNo=" + chatNo + ", empNo=" + empNo + ", chatTitle=" + chatTitle + "]";
	}
	
	
}
