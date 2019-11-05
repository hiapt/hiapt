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
	private String docstatus;
	private String display;
	private String approver;
	private String feedback;
	private String formname;
	private String empname;
	private String empid;
	private String appname;
	private String appid;
	private Date deadline;
	private int lineno;
	private String sresult;
	
	public Draft () {}

	public Draft(int docno, String empno, int formcode, String doctitle, String doccontent, String originfile,
			String renamefile, Date draftdate, String docstatus, String display, String approver, String feedback,
			String formname, String empname, String empid, String appname, String appid, Date deadline, int lineno,
			String sresult) {
		super();
		this.docno = docno;
		this.empno = empno;
		this.formcode = formcode;
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.originfile = originfile;
		this.renamefile = renamefile;
		this.draftdate = draftdate;
		this.docstatus = docstatus;
		this.display = display;
		this.approver = approver;
		this.feedback = feedback;
		this.formname = formname;
		this.empname = empname;
		this.empid = empid;
		this.appname = appname;
		this.appid = appid;
		this.deadline = deadline;
		this.lineno = lineno;
		this.sresult = sresult;
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

	public String getDocstatus() {
		return docstatus;
	}

	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getLineno() {
		return lineno;
	}

	public void setLineno(int lineno) {
		this.lineno = lineno;
	}

	public String getSresult() {
		return sresult;
	}

	public void setSresult(String sresult) {
		this.sresult = sresult;
	}

	@Override
	public String toString() {
		return "Draft [docno=" + docno + ", empno=" + empno + ", formcode=" + formcode + ", doctitle=" + doctitle
				+ ", doccontent=" + doccontent + ", originfile=" + originfile + ", renamefile=" + renamefile
				+ ", draftdate=" + draftdate + ", docstatus=" + docstatus + ", display=" + display + ", approver="
				+ approver + ", feedback=" + feedback + ", formname=" + formname + ", empname=" + empname + ", empid="
				+ empid + ", appname=" + appname + ", appid=" + appid + ", deadline=" + deadline + ", lineno=" + lineno
				+ ", sresult=" + sresult + "]";
	}

	
	

}
