package appline.model.vo;

public class Appline  implements java.io.Serializable{
	private static final long serialVersionUID = 567L;
	
	private int lineno;
	private String empno;
	private String linename;
	private String linecontent;
	private String linevalue;
	
	public Appline () {}

	public Appline(int lineno, String empno, String linename, String linecontent, String linevalue) {
		super();
		this.lineno = lineno;
		this.empno = empno;
		this.linename = linename;
		this.linecontent = linecontent;
		this.linevalue = linevalue;
	}

	public int getLineno() {
		return lineno;
	}

	public void setLineno(int lineno) {
		this.lineno = lineno;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getLinename() {
		return linename;
	}

	public void setLinename(String linename) {
		this.linename = linename;
	}

	public String getLinecontent() {
		return linecontent;
	}

	public void setLinecontent(String linecontent) {
		this.linecontent = linecontent;
	}

	public String getLinevalue() {
		return linevalue;
	}

	public void setLinevalue(String linevalue) {
		this.linevalue = linevalue;
	}

	@Override
	public String toString() {
		return "Appline [lineno=" + lineno + ", empno=" + empno + ", linename=" + linename + ", linecontent="
				+ linecontent + ", linevalue=" + linevalue + "]";
	}
	
}
