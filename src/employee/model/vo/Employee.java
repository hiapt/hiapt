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
	private String empAddress;
	private String empEmail;
	private int empFamily;
	private int salary;
	private Double pension;
	private Double insurance;
	private Double longIns;
	private Double hireIns;
	private Double incomeTax;
	private Double localTax;
	private String empEtc;
	
	public Employee() {}

	public Employee(String empNo, String empPwd, String empName, String empId, Date empHireDate, String empPhone,
			String empSSN, String empAddress, String empEmail, int empFamily, int salary, Double pension,
			Double insurance, Double longIns, Double hireIns, Double incomeTax, Double localTax, String empEtc) {
		super();
		this.empNo = empNo;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empId = empId;
		this.empHireDate = empHireDate;
		this.empPhone = empPhone;
		this.empSSN = empSSN;
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

	public Double getPension() {
		return pension;
	}

	public void setPension(Double pension) {
		this.pension = pension;
	}

	public Double getInsurance() {
		return insurance;
	}

	public void setInsurance(Double insurance) {
		this.insurance = insurance;
	}

	public Double getLongIns() {
		return longIns;
	}

	public void setLongIns(Double longIns) {
		this.longIns = longIns;
	}

	public Double getHireIns() {
		return hireIns;
	}

	public void setHireIns(Double hireIns) {
		this.hireIns = hireIns;
	}

	public Double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
	}

	public Double getLocalTax() {
		return localTax;
	}

	public void setLocalTax(Double localTax) {
		this.localTax = localTax;
	}

	public String getEmpEtc() {
		return empEtc;
	}

	public void setEmpEtc(String empEtc) {
		this.empEtc = empEtc;
	}

	@Override
	public String toString() {
		return "Member [empNo=" + empNo + ", empPwd=" + empPwd + ", empName=" + empName + ", empId=" + empId
				+ ", empHireDate=" + empHireDate + ", empPhone=" + empPhone + ", empSSN=" + empSSN + ", empAddress="
				+ empAddress + ", empEmail=" + empEmail + ", empFamily=" + empFamily + ", salary=" + salary
				+ ", pension=" + pension + ", insurance=" + insurance + ", longIns=" + longIns + ", hireIns=" + hireIns
				+ ", incomeTax=" + incomeTax + ", localTax=" + localTax + ", empEtc=" + empEtc + "]";
	}

		
}
