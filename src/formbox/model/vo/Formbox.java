package formbox.model.vo;

public class Formbox implements java.io.Serializable{
	private static final long serialVersionUID = 888L;
	
	private int formcode;
	private String formtype;
	private String formname;
	private String formcontent;
	
	public Formbox() {}

	public Formbox(int formcode, String formtype, String formname, String formcontent) {
		super();
		this.formcode = formcode;
		this.formtype = formtype;
		this.formname = formname;
		this.formcontent = formcontent;
	}

	public int getFormcode() {
		return formcode;
	}

	public void setFormcode(int formcode) {
		this.formcode = formcode;
	}

	public String getFormtype() {
		return formtype;
	}

	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public String getFormcontent() {
		return formcontent;
	}

	public void setFormcontent(String formcontent) {
		this.formcontent = formcontent;
	}

	@Override
	public String toString() {
		return "Formbox [formcode=" + formcode + ", formtype=" + formtype + ", formname=" + formname + ", formcontent="
				+ formcontent + "]";
	}
	
	
	
}
