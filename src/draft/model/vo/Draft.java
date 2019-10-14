package draft.model.vo;

import java.sql.Date;

public class Draft implements java.io.Serializable{
	private static final long serialVersionUID = 999L;
	
	private int docno;
	private String empno;
	private int formcode;
	private String doctitle;
	private String doccontent;
	private String originfile;
	private String renamefile;
	private Date draftdate;
	private String progress;
	private String display;
	private String newcode;
	private String formname;
	private String empname;
	private String empid;
	
	public Draft() {}

	public Draft(int docno, String empno, int formcode, String doctitle, String doccontent, String originfile,
			String renamefile, Date draftdate, String progress, String display, String newcode, String formname,
			String empname, String empid) {
		super();
		this.docno = docno;
		this.empno = empno;
		this.formcode = formcode;
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.originfile = originfile;
		this.renamefile = renamefile;
		this.draftdate = draftdate;
		this.progress = progress;
		this.display = display;
		this.newcode = newcode;
		this.formname = formname;
		this.empname = empname;
		this.empid = empid;
	}

	public int getDocno() {
		return docno;
	}

	public void setDocno(int docno) {
		this.docno = docno;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
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

	public String getRenamefile() {
		return renamefile;
	}

	public void setRenamefile(String renamefile) {
		this.renamefile = renamefile;
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

	public String getNewcode() {
		return newcode;
	}

	public void setNewcode(String newcode) {
		this.newcode = newcode;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
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

	@Override
	public String toString() {
		return "Draft [docno=" + docno + ", empno=" + empno + ", formcode=" + formcode + ", doctitle=" + doctitle
				+ ", doccontent=" + doccontent + ", originfile=" + originfile + ", renamefile=" + renamefile
				+ ", draftdate=" + draftdate + ", progress=" + progress + ", display=" + display + ", newcode="
				+ newcode + ", formname=" + formname + ", empname=" + empname + ", empid=" + empid + "]";
	}
	
	
	
}
