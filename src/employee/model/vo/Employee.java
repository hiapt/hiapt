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
	private int empZipcode;
	private String empAddress;
	private String empEmail;
	private int empFamily;
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
	
	public Employee() {}

	public Employee(String empNo, String empPwd, String empName, String empId, Date empHireDate, String empPhone,
			String empSSN, int empZipcode, String empAddress, String empEmail, int empFamily, int salary, int pension,
			int insurance, int longIns, int hireIns, int incomeTax, int localTax, int salaryTot, int minusTot,
			int realSalary, String empEtc) {
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
		this.empFamily = empFamily;
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

	public int getEmpZipcode() {
		return empZipcode;
	}

	public void setEmpZipcode(int empZipcode) {
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

	public int getEmpFamily() {
		return empFamily;
	}

	public void setEmpFamily(int empFamily) {
		this.empFamily = empFamily;
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

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empPwd=" + empPwd + ", empName=" + empName + ", empId=" + empId
				+ ", empHireDate=" + empHireDate + ", empPhone=" + empPhone + ", empSSN=" + empSSN + ", empZipcode="
				+ empZipcode + ", empAddress=" + empAddress + ", empEmail=" + empEmail + ", empFamily=" + empFamily
				+ ", salary=" + salary + ", pension=" + pension + ", insurance=" + insurance + ", longIns=" + longIns
				+ ", hireIns=" + hireIns + ", incomeTax=" + incomeTax + ", localTax=" + localTax + ", salaryTot="
				+ salaryTot + ", minusTot=" + minusTot + ", realSalary=" + realSalary + ", empEtc=" + empEtc + "]";
	}

	

	
		
}
