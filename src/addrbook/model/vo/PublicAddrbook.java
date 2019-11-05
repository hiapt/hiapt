package addrbook.model.vo;

public class PublicAddrbook implements java.io.Serializable{
	public static final long SerialVersionUID = 7004L;
	
	private String empName;
	private String empAddress;
	private String empPhone;
	private String empEmail;
	private String empEtc;
	
	public PublicAddrbook() {}

	public PublicAddrbook(String empName, String empAddress, String empPhone, String empEmail, String empEtc) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.empEtc = empEtc;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
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

	public String getEmpEtc() {
		return empEtc;
	}

	public void setEmpEtc(String empEtc) {
		this.empEtc = empEtc;
	}

	@Override
	public String toString() {
		return "PublicAddrbook [empName=" + empName + ", empAddress=" + empAddress + ", empPhone=" + empPhone
				+ ", empEmail=" + empEmail + ", empEtc=" + empEtc + "]";
	}
	
	

}
