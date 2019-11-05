package complain.model.vo;

public class ComplainImgs implements java.io.Serializable{
	private static final long serialVersionUID =3988L;
	
	private int compNo;
	private String compOriginalImgname;
	private String compRenameImgname;
	
	public ComplainImgs() {}

	public ComplainImgs(int compNo, String compOriginalImgname, String compRenameImgname) {
		super();
		this.compNo = compNo;
		this.compOriginalImgname = compOriginalImgname;
		this.compRenameImgname = compRenameImgname;
	}

	public int getCompNo() {
		return compNo;
	}

	public void setCompNo(int compNo) {
		this.compNo = compNo;
	}

	public String getCompOriginalImgname() {
		return compOriginalImgname;
	}

	public void setCompOriginalImgname(String compOriginalImgname) {
		this.compOriginalImgname = compOriginalImgname;
	}

	public String getCompRenameImgname() {
		return compRenameImgname;
	}

	public void setCompRenameImgname(String compRenameImgname) {
		this.compRenameImgname = compRenameImgname;
	}

	@Override
	public String toString() {
		return "ComplainImgs [compNo=" + compNo + ", compOriginalImgname=" + compOriginalImgname
				+ ", compRenameImgname=" + compRenameImgname + "]";
	}
	
}
