package complain.model.vo;

import java.sql.Date;

public class Complain implements java.io.Serializable{
	private static final long serialVersionUID =3999L;
	
	private int compNo;
	private String compTitle;
	private java.sql.Date compDate;
	private String compContents;
	private String compResultStatus;
	private String compSecret;
	private String compReponse;
	private String empNo;
	private String empName;
	private String userId;
	private String userName;
	private String userPhone;
	
	public Complain() {}

	public Complain(int compNo, String compTitle, Date compDate, String compContents, String compResultStatus,
			String compSecret, String compReponse, String empNo, String empName, String userId, String userName,
			String userPhone) {
		super();
		this.compNo = compNo;
		this.compTitle = compTitle;
		this.compDate = compDate;
		this.compContents = compContents;
		this.compResultStatus = compResultStatus;
		this.compSecret = compSecret;
		this.compReponse = compReponse;
		this.empNo = empNo;
		this.empName = empName;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public int getCompNo() {
		return compNo;
	}

	public void setCompNo(int compNo) {
		this.compNo = compNo;
	}

	public String getCompTitle() {
		return compTitle;
	}

	public void setCompTitle(String compTitle) {
		this.compTitle = compTitle;
	}

	public java.sql.Date getCompDate() {
		return compDate;
	}

	public void setCompDate(java.sql.Date compDate) {
		this.compDate = compDate;
	}

	public String getCompContents() {
		return compContents;
	}

	public void setCompContents(String compContents) {
		this.compContents = compContents;
	}

	public String getCompResultStatus() {
		return compResultStatus;
	}

	public void setCompResultStatus(String compResultStatus) {
		this.compResultStatus = compResultStatus;
	}

	public String getCompSecret() {
		return compSecret;
	}

	public void setCompSecret(String compSecret) {
		this.compSecret = compSecret;
	}

	public String getCompReponse() {
		return compReponse;
	}

	public void setCompReponse(String compReponse) {
		this.compReponse = compReponse;
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

	@Override
	public String toString() {
		return "Complain [compNo=" + compNo + ", compTitle=" + compTitle + ", compDate=" + compDate + ", compContents="
				+ compContents + ", compResultStatus=" + compResultStatus + ", compSecret=" + compSecret
				+ ", compReponse=" + compReponse + ", empNo=" + empNo + ", empName=" + empName + ", userId=" + userId
				+ ", userName=" + userName + ", userPhone=" + userPhone + "]";
	}

	

	
	
}
