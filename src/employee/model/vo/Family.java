package employee.model.vo;

import java.sql.Date;

public class Family implements java.io.Serializable {
	private static final long serialVersionUID = 522L;
	
	private String empNo;
	private String fRelation;
	private String fName;
	private String fSSN;
	private String fDisability;
	private String fDeduction;
	private String fTogether;
	private String fTax;
	private String fChild;
	
	public Family() {}

	public Family(String empNo, String fRelation, String fName, String fSSN, String fDisability, String fDeduction,
			String fTogether, String fTax, String fChild) {
		super();
		this.empNo = empNo;
		this.fRelation = fRelation;
		this.fName = fName;
		this.fSSN = fSSN;
		this.fDisability = fDisability;
		this.fDeduction = fDeduction;
		this.fTogether = fTogether;
		this.fTax = fTax;
		this.fChild = fChild;
	}
	
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getfRelation() {
		return fRelation;
	}

	public void setfRelation(String fRelation) {
		this.fRelation = fRelation;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfSSN() {
		return fSSN;
	}

	public void setfSSN(String fSSN) {
		this.fSSN = fSSN;
	}

	public String getfDisability() {
		return fDisability;
	}

	public void setfDisability(String fDisability) {
		this.fDisability = fDisability;
	}

	public String getfDeduction() {
		return fDeduction;
	}

	public void setfDeduction(String fDeduction) {
		this.fDeduction = fDeduction;
	}

	public String getfTogether() {
		return fTogether;
	}

	public void setfTogether(String fTogether) {
		this.fTogether = fTogether;
	}

	public String getfTax() {
		return fTax;
	}

	public void setfTax(String fTax) {
		this.fTax = fTax;
	}

	public String getfChild() {
		return fChild;
	}

	public void setfChild(String fChild) {
		this.fChild = fChild;
	}

	@Override
	public String toString() {
		return "Family [empNo=" + empNo + ", fRelation=" + fRelation + ", fName=" + fName + 
				", fSSN=" + fSSN + ", fDisability=" + fDisability + ", fDeduction=" + fDeduction + 
				", fTogether=" + fTogether + ", fTax=" + fTax + ", fChild=" + fChild + "]";
	}

	

			
}
