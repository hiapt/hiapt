package maintenance.model.vo;

public class ImposeViewAptuser implements java.io.Serializable {
	private static final long serialVersionUID = 100052L;
	
	private String userId;
	private String userName;
	private String userPhone;
	
	public ImposeViewAptuser() {}

	public ImposeViewAptuser(String userId, String userName, String userPhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImposeViewAptuser [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + "]";
	}
	
	
	
}
