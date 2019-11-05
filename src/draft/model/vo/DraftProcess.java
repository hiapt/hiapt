package draft.model.vo;

import java.sql.Date;

public class DraftProcess  implements java.io.Serializable{
	private static final long serialVersionUID = 113L;
	
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
	private Date deadline;
	private String appname1;
	private String appname2;
	private String appname3;
	private String appname4;
	private String appname5;
	private String appid1;
	private String appid2;
	private String appid3;
	private String appid4;
	private String appid5;
	private String disname1;
	private String disname2;
	private String disname3;
	private String disname4;
	private String disname5;
	private String disid1;
	private String disid2;
	private String disid3;
	private String disid4;
	private String disid5;
	private Date appdate;
	private String signresult;
	private String appstep;
	private String appno;
	
	public DraftProcess() {}

	public DraftProcess(int docno, String empno, int formcode, String doctitle, String doccontent, String originfile,
			String renamefile, Date draftdate, String docstatus, String display, String approver, String feedback,
			String formname, String empname, String empid, Date deadline, String appname1, String appname2,
			String appname3, String appname4, String appname5, String appid1, String appid2, String appid3,
			String appid4, String appid5, String disname1, String disname2, String disname3, String disname4,
			String disname5, String disid1, String disid2, String disid3, String disid4, String disid5, Date appdate,
			String signresult, String appstep, String appno) {
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
		this.deadline = deadline;
		this.appname1 = appname1;
		this.appname2 = appname2;
		this.appname3 = appname3;
		this.appname4 = appname4;
		this.appname5 = appname5;
		this.appid1 = appid1;
		this.appid2 = appid2;
		this.appid3 = appid3;
		this.appid4 = appid4;
		this.appid5 = appid5;
		this.disname1 = disname1;
		this.disname2 = disname2;
		this.disname3 = disname3;
		this.disname4 = disname4;
		this.disname5 = disname5;
		this.disid1 = disid1;
		this.disid2 = disid2;
		this.disid3 = disid3;
		this.disid4 = disid4;
		this.disid5 = disid5;
		this.appdate = appdate;
		this.signresult = signresult;
		this.appstep = appstep;
		this.appno = appno;
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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getAppname1() {
		return appname1;
	}

	public void setAppname1(String appname1) {
		this.appname1 = appname1;
	}

	public String getAppname2() {
		return appname2;
	}

	public void setAppname2(String appname2) {
		this.appname2 = appname2;
	}

	public String getAppname3() {
		return appname3;
	}

	public void setAppname3(String appname3) {
		this.appname3 = appname3;
	}

	public String getAppname4() {
		return appname4;
	}

	public void setAppname4(String appname4) {
		this.appname4 = appname4;
	}

	public String getAppname5() {
		return appname5;
	}

	public void setAppname5(String appname5) {
		this.appname5 = appname5;
	}

	public String getAppid1() {
		return appid1;
	}

	public void setAppid1(String appid1) {
		this.appid1 = appid1;
	}

	public String getAppid2() {
		return appid2;
	}

	public void setAppid2(String appid2) {
		this.appid2 = appid2;
	}

	public String getAppid3() {
		return appid3;
	}

	public void setAppid3(String appid3) {
		this.appid3 = appid3;
	}

	public String getAppid4() {
		return appid4;
	}

	public void setAppid4(String appid4) {
		this.appid4 = appid4;
	}

	public String getAppid5() {
		return appid5;
	}

	public void setAppid5(String appid5) {
		this.appid5 = appid5;
	}

	public String getDisname1() {
		return disname1;
	}

	public void setDisname1(String disname1) {
		this.disname1 = disname1;
	}

	public String getDisname2() {
		return disname2;
	}

	public void setDisname2(String disname2) {
		this.disname2 = disname2;
	}

	public String getDisname3() {
		return disname3;
	}

	public void setDisname3(String disname3) {
		this.disname3 = disname3;
	}

	public String getDisname4() {
		return disname4;
	}

	public void setDisname4(String disname4) {
		this.disname4 = disname4;
	}

	public String getDisname5() {
		return disname5;
	}

	public void setDisname5(String disname5) {
		this.disname5 = disname5;
	}

	public String getDisid1() {
		return disid1;
	}

	public void setDisid1(String disid1) {
		this.disid1 = disid1;
	}

	public String getDisid2() {
		return disid2;
	}

	public void setDisid2(String disid2) {
		this.disid2 = disid2;
	}

	public String getDisid3() {
		return disid3;
	}

	public void setDisid3(String disid3) {
		this.disid3 = disid3;
	}

	public String getDisid4() {
		return disid4;
	}

	public void setDisid4(String disid4) {
		this.disid4 = disid4;
	}

	public String getDisid5() {
		return disid5;
	}

	public void setDisid5(String disid5) {
		this.disid5 = disid5;
	}

	public Date getAppdate() {
		return appdate;
	}

	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}

	public String getSignresult() {
		return signresult;
	}

	public void setSignresult(String signresult) {
		this.signresult = signresult;
	}

	public String getAppstep() {
		return appstep;
	}

	public void setAppstep(String appstep) {
		this.appstep = appstep;
	}

	public String getAppno() {
		return appno;
	}

	public void setAppno(String appno) {
		this.appno = appno;
	}

	@Override
	public String toString() {
		return "DraftProcess [docno=" + docno + ", empno=" + empno + ", formcode=" + formcode + ", doctitle=" + doctitle
				+ ", doccontent=" + doccontent + ", originfile=" + originfile + ", renamefile=" + renamefile
				+ ", draftdate=" + draftdate + ", docstatus=" + docstatus + ", display=" + display + ", approver="
				+ approver + ", feedback=" + feedback + ", formname=" + formname + ", empname=" + empname + ", empid="
				+ empid + ", deadline=" + deadline + ", appname1=" + appname1 + ", appname2=" + appname2 + ", appname3="
				+ appname3 + ", appname4=" + appname4 + ", appname5=" + appname5 + ", appid1=" + appid1 + ", appid2="
				+ appid2 + ", appid3=" + appid3 + ", appid4=" + appid4 + ", appid5=" + appid5 + ", disname1=" + disname1
				+ ", disname2=" + disname2 + ", disname3=" + disname3 + ", disname4=" + disname4 + ", disname5="
				+ disname5 + ", disid1=" + disid1 + ", disid2=" + disid2 + ", disid3=" + disid3 + ", disid4=" + disid4
				+ ", disid5=" + disid5 + ", appdate=" + appdate + ", signresult=" + signresult + ", appstep=" + appstep
				+ ", appno=" + appno + "]";
	}

	
}
