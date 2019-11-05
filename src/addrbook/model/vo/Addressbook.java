package addrbook.model.vo;

public class Addressbook implements java.io.Serializable {
	private static final long SerialVersionUID = 7005L;
	
	private int addrbookNO;
	private String addrbookAddress;
	private String addrbookEtc;
	private String addrbookName;
	private String addrbookPhone;
	private String addrbookMail;
	private String addrbookCode;
	
	public Addressbook() {}

	public Addressbook(int addrbookNO, String addrbookAddress, String addrbookEtc, String addrbookName,
			String addrbookPhone, String addrbookMail, String addrbookCode) {
		super();
		this.addrbookNO = addrbookNO;
		this.addrbookAddress = addrbookAddress;
		this.addrbookEtc = addrbookEtc;
		this.addrbookName = addrbookName;
		this.addrbookPhone = addrbookPhone;
		this.addrbookMail = addrbookMail;
		this.addrbookCode = addrbookCode;
	}

	public int getAddrbookNO() {
		return addrbookNO;
	}

	public void setAddrbookNO(int addrbookNO) {
		this.addrbookNO = addrbookNO;
	}

	public String getAddrbookAddress() {
		return addrbookAddress;
	}

	public void setAddrbookAddress(String addrbookAddress) {
		this.addrbookAddress = addrbookAddress;
	}

	public String getAddrbookEtc() {
		return addrbookEtc;
	}

	public void setAddrbookEtc(String addrbookEtc) {
		this.addrbookEtc = addrbookEtc;
	}

	public String getAddrbookName() {
		return addrbookName;
	}

	public void setAddrbookName(String addrbookName) {
		this.addrbookName = addrbookName;
	}

	public String getAddrbookPhone() {
		return addrbookPhone;
	}

	public void setAddrbookPhone(String addrbookPhone) {
		this.addrbookPhone = addrbookPhone;
	}

	public String getAddrbookMail() {
		return addrbookMail;
	}

	public void setAddrbookMail(String addrbookMail) {
		this.addrbookMail = addrbookMail;
	}

	public String getAddrbookCode() {
		return addrbookCode;
	}

	public void setAddrbookCode(String addrbookCode) {
		this.addrbookCode = addrbookCode;
	}

	@Override
	public String toString() {
		return "Addressbook [addrbookNO=" + addrbookNO + ", addrbookAddress=" + addrbookAddress + ", addrbookEtc="
				+ addrbookEtc + ", addrbookName=" + addrbookName + ", addrbookPhone=" + addrbookPhone
				+ ", addrbookMail=" + addrbookMail + ", addrbookCode=" + addrbookCode + "]";
	}
	
	

}
