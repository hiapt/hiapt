package mybox.model.vo;

import java.sql.Date;

public class Mybox implements java.io.Serializable{
	private static final long serialVersionUID = 777L;
	
	private String myboxcode;
	private String empno;
	private int docno;
	private String myboxname;
	private int formcode;
	private String doctitle;
	private String doccontent;
	private String originfile;
	private Date draftdate;
	private String progress;
	private String display;
	private String empname;
	private String empid;
	private String formname;
	
	public Mybox() {}

	public Mybox(String myboxcode, String empno, int docno, String myboxname, int formcode, String doctitle,
			String doccontent, String originfile, Date draftdate, String progress, String display, String empname,
			String empid, String formname) {
		super();
		this.myboxcode = myboxcode;
		this.empno = empno;
		this.docno = docno;
		this.myboxname = myboxname;
		this.formcode = formcode;
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.originfile = originfile;
		this.draftdate = draftdate;
		this.progress = progress;
		this.display = display;
		this.empname = empname;
		this.empid = empid;
		this.formname = formname;
	}

	public String getMyboxcode() {
		return myboxcode;
	}

	public void setMyboxcode(String myboxcode) {
		this.myboxcode = myboxcode;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public int getDocno() {
		return docno;
	}

	public void setDocno(int docno) {
		this.docno = docno;
	}

	public String getMyboxname() {
		return myboxname;
	}

	public void setMyboxname(String myboxname) {
		this.myboxname = myboxname;
	}

	public int getFormcode() {
		return formcode;
	}

	public void setFormcode(int formcode) {
		this.formcode = formcode;
	}

	public String getDoctitle() {
		return doctitle;
	}

	public void setDoctitle(String doctitle) {
		this.doctitle = doctitle;
	}

	public String getDoccontent() {
		return doccontent;
	}

	public void setDoccontent(String doccontent) {
		this.doccontent = doccontent;
	}

	public String getOriginfile() {
		return originfile;
	}

	public void setOriginfile(String originfile) {
		this.originfile = originfile;
	}

	public Date getDraftdate() {
		return draftdate;
	}

	public void setDraftdate(Date draftdate) {
		this.draftdate = draftdate;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	@Override
	public String toString() {
		return "Mybox [myboxcode=" + myboxcode + ", empno=" + empno + ", docno=" + docno + ", myboxname=" + myboxname
				+ ", formcode=" + formcode + ", doctitle=" + doctitle + ", doccontent=" + doccontent + ", originfile="
				+ originfile + ", draftdate=" + draftdate + ", progress=" + progress + ", display=" + display
				+ ", empname=" + empname + ", empid=" + empid + ", formname=" + formname + "]";
	}
	
	


}
