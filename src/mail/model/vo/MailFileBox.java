package mail.model.vo;

import java.sql.Date;

public class MailFileBox implements java.io.Serializable {

	private final static long SerialVersionUID = 7001L;
	
	private int mailNo;
	private String originalfile;
	private String renamefile;
	private String filesize;
	private java.sql.Date downloadterm;
	
	public MailFileBox() {}
	
	public MailFileBox(int mailNo, String originalfile, String renamefile, String filesize, Date downloadterm) {
		super();
		this.mailNo = mailNo;
		this.originalfile = originalfile;
		this.renamefile = renamefile;
		this.filesize = filesize;
		this.downloadterm = downloadterm;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}

	public String getOriginalfile() {
		return originalfile;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public String getRenamefile() {
		return renamefile;
	}

	public void setRenamefile(String renamefile) {
		this.renamefile = renamefile;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public java.sql.Date getDownloadterm() {
		return downloadterm;
	}

	public void setDownloadterm(java.sql.Date downloadterm) {
		this.downloadterm = downloadterm;
	}

	@Override
	public String toString() {
		return "MailFileBox [mailNo=" + mailNo + ", originalfile=" + originalfile + ", renamefile=" + renamefile
				+ ", filesize=" + filesize + ", downloadterm=" + downloadterm + "]";
	}
	
	
	
}
