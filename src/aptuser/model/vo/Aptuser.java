package aptuser.model.vo;

import java.sql.Date;

public class Aptuser implements java.io.Serializable{
	private static final Long SerialversionUID = 1002L;
	
	private String userId;
	private String userPwd;
	private String userName;
	private java.sql.Date userEnroll;
	private java.sql.Date userBirth;
	private String userPhone;
	private String userEmail;
	private String userEtc;
	private String carType;
	private String carNo;
	private java.sql.Date carEnroll;
	
	public Aptuser () {}

	public Aptuser(String userId, String userPwd, String userName, Date userEnroll, Date userBirth, String userPhone,
			String userEmail, String userEtc, String carType, String carNo, Date carEnroll) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEnroll = userEnroll;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userEtc = userEtc;
		this.carType = carType;
		this.carNo = carNo;
		this.carEnroll = carEnroll;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.sql.Date getUserEnroll() {
		return userEnroll;
	}

	public void setUserEnroll(java.sql.Date userEnroll) {
		this.userEnroll = userEnroll;
	}

	public java.sql.Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(java.sql.Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEtc() {
		return userEtc;
	}

	public void setUserEtc(String userEtc) {
		this.userEtc = userEtc;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public java.sql.Date getCarEnroll() {
		return carEnroll;
	}

	public void setCarEnroll(java.sql.Date carEnroll) {
		this.carEnroll = carEnroll;
	}

	@Override
	public String toString() {
		return "Aptuser [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userEnroll="
				+ userEnroll + ", userBirth=" + userBirth + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userEtc=" + userEtc + ", carType=" + carType + ", carNo=" + carNo + ", carEnroll=" + carEnroll
				+ "]";
	}

	
	
	
}




