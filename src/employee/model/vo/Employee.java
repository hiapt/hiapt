package employee.model.vo;

import java.sql.Date;

public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = 521L;
	
	private String empNo;
	private String empPwd;
	private String empName;
	private String empId;
	private java.sql.Date empHireDate;
	private String empPhone;
	private String empSSN;
	private String empZipcode;
	private String empAddress;
	private String empEmail;
	private String empGender;
	private int salary;
	private int pension;
	private int insurance;
	private int longIns;
	private int hireIns;
	private int incomeTax;
	private int localTax;
	private int salaryTot;
	private int minusTot;
	private int realSalary;
	private String empEtc;
	private String fRelation;
	private String fName;
	private String fSSN;
	private String fDisability;
	private String fDeduction;
	private String fTogether;
	private String fTax;
	private String fChild;
	
	public Employee() {}

	public Employee(String empNo, String empPwd, String empName, String empId, Date empHireDate, String empPhone,
			String empSSN, String empZipcode, String empAddress, String empEmail, String empGender, int salary,
			int pension, int insurance, int longIns, int hireIns, int incomeTax, int localTax, int salaryTot,
			int minusTot, int realSalary, String empEtc, String fRelation, String fName, String fSSN,
			String fDisability, String fDeduction, String fTogether, String fTax, String fChild) {
		super();
		this.empNo = empNo;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empId = empId;
		this.empHireDate = empHireDate;
		this.empPhone = empPhone;
		this.empSSN = empSSN;
		this.empZipcode = empZipcode;
		this.empAddress = empAddress;
		this.empEmail = empEmail;
		this.empGender = empGender;
		this.salary = salary;
		this.pension = pension;
		this.insurance = insurance;
		this.longIns = longIns;
		this.hireIns = hireIns;
		this.incomeTax = incomeTax;
		this.localTax = localTax;
		this.salaryTot = salaryTot;
		this.minusTot = minusTot;
		this.realSalary = realSalary;
		this.empEtc = empEtc;
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

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public java.sql.Date getEmpHireDate() {
		return empHireDate;
	}

	public void setEmpHireDate(java.sql.Date empHireDate) {
		this.empHireDate = empHireDate;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpSSN() {
		return empSSN;
	}

	public void setEmpSSN(String empSSN) {
		this.empSSN = empSSN;
	}

	public String getEmpZipcode() {
		return empZipcode;
	}

	public void setEmpZipcode(String empZipcode) {
		this.empZipcode = empZipcode;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	public int getInsurance() {
		return insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	public int getLongIns() {
		return longIns;
	}

	public void setLongIns(int longIns) {
		this.longIns = longIns;
	}

	public int getHireIns() {
		return hireIns;
	}

	public void setHireIns(int hireIns) {
		this.hireIns = hireIns;
	}

	public int getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}

	public int getLocalTax() {
		return localTax;
	}

	public void setLocalTax(int localTax) {
		this.localTax = localTax;
	}

	public int getSalaryTot() {
		return salaryTot;
	}

	public void setSalaryTot(int salaryTot) {
		this.salaryTot = salaryTot;
	}

	public int getMinusTot() {
		return minusTot;
	}

	public void setMinusTot(int minusTot) {
		this.minusTot = minusTot;
	}

	public int getRealSalary() {
		return realSalary;
	}

	public void setRealSalary(int realSalary) {
		this.realSalary = realSalary;
	}

	public String getEmpEtc() {
		return empEtc;
	}

	public void setEmpEtc(String empEtc) {
		this.empEtc = empEtc;
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
		return "Employee [empNo=" + empNo + ", empPwd=" + empPwd + ", empName=" + empName + ", empId=" + empId
				+ ", empHireDate=" + empHireDate + ", empPhone=" + empPhone + ", empSSN=" + empSSN + ", empZipcode="
				+ empZipcode + ", empAddress=" + empAddress + ", empEmail=" + empEmail + ", empGender=" + empGender
				+ ", salary=" + salary + ", pension=" + pension + ", insurance=" + insurance + ", longIns=" + longIns
				+ ", hireIns=" + hireIns + ", incomeTax=" + incomeTax + ", localTax=" + localTax + ", salaryTot="
				+ salaryTot + ", minusTot=" + minusTot + ", realSalary=" + realSalary + ", empEtc=" + empEtc
				+ ", fRelation=" + fRelation + ", fName=" + fName + ", fSSN=" + fSSN + ", fDisability=" + fDisability
				+ ", fDeduction=" + fDeduction + ", fTogether=" + fTogether + ", fTax=" + fTax + ", fChild=" + fChild
				+ "]";
	}

	public Employee(String empNo, String fRelation, String fName, String fSSN, String fDisability, String fDeduction,
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

			
}
