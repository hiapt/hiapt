package mail.model.vo;

public class MailBoxType implements java.io.Serializable{

	private static final long SerialVersionUID = 7002L;
	
	private int mailCode;
	private String mailBoxName;
	private String empEmail;

	public MailBoxType() {}

	public MailBoxType(int mailCode, String mailBoxName, String empEmail) {
		super();
		this.mailCode = mailCode;
		this.mailBoxName = mailBoxName;
		this.empEmail = empEmail;
	}

	public int getMailCode() {
		return mailCode;
	}

	public void setMailCode(int mailCode) {
		this.mailCode = mailCode;
	}

	public String getMailBoxName() {
		return mailBoxName;
	}

	public void setMailBoxName(String mailBoxName) {
		this.mailBoxName = mailBoxName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "MailBoxType [mailCode=" + mailCode + ", mailBoxName=" + mailBoxName + ", empEmail=" + empEmail + "]";
	}
	
	
}
