package chat.model.vo;

public class ChatPerson implements java.io.Serializable{
	private static final long serialVersionUID =3201L;
	
	private String empNo;
	private String empName;
	private String empId;
	private String empPhone;
	private String empEmail;
	
	public ChatPerson() {}

	public ChatPerson(String empNo, String empName, String empId, String empPhone, String empEmail) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empId = empId;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
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

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "ChatPerson [empNo=" + empNo + ", empName=" + empName + ", empId=" + empId + ", empPhone=" + empPhone
				+ ", empEmail=" + empEmail + "]";
	}
	
	
}
