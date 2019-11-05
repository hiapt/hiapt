package chat.model.vo;

public class ChatRoomMaster implements java.io.Serializable{
	private static final long serialVersionUID =3611L;
	
	private int chatNo;
	private String empNo;
	
	public ChatRoomMaster() {}

	public ChatRoomMaster(int chatNo, String empNo) {
		super();
		this.chatNo = chatNo;
		this.empNo = empNo;
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

	@Override
	public String toString() {
		return "ChatRoomMaster [chatNo=" + chatNo + ", empNo=" + empNo + "]";
	}
	
	
}
