package maintenance.model.vo;

import java.sql.Date;

public class Bill implements java.io.Serializable {
	private static final long serialVersionUID = 100001L;
	
	private long merchantUid; // 고유고지서번호
	private String userId; // 동/홍수
	private String userName; // 이름
	private java.sql.Date billYearMonth; // 부과년월
	private java.sql.Date calculateStartDay; // 산출기간시작
	private java.sql.Date calculateEndDay; // 산출기간 마감일
	private java.sql.Date imposeEndDay; // 부과마감일
	private java.sql.Date acceptDate; // 출력의뢰일
	private java.sql.Date cutoffDate; // 납부마감일
	private String imposeStatus; // 부과진행
	private int imposeCount; // 부과마감 횟수
	private String imposeFinish;	 // 부과완료(char)
	private int generalCost; // 일반관리비
	private int guardCost; // 경비비
	private int cleanCost;//	청소비
	private int disinfectCost;//	소독비
	private int elevatorCost;//	승강기유지비
	private int repairCost;//	수선유지비
	private int commission;//	위탁관리수수료
	private int fireInsuranceCost;//	화재보험료
	private int electricCost;//	세대전기료
	private int tvCost;//	TV수신료
	private int waterCost;//	세대수도료
	private int heatingCost;//	난방사용료
	private int hwaterCost;//	온수사용료
	private int allElectricCost;//	공동전기료
	private int allWaterCost;//	공동수도료
	private int electricUsage;//	전기사용량
	private int waterUsage;//	수도사용량
	private double heatingUsage;//	난방사용량
	private double hwaterUsage;//	온수사용량
	private int arrears;//	미납액
	private String etc;//	비고
	private String vbankNum; //	계좌번호
	private int amount; // 부과금액
	private double beforeAmount; // 납기내 금액
	private double afterAmount; // 납기후 금액
	private double arrearsFine; // 미납후금액
	
	// 기본 생성자
	public Bill(){}

	public Bill(long merchantUid, String userId, String userName, Date billYearMonth, Date calculateStartDay,
			Date calculateEndDay, Date imposeEndDay, Date acceptDate, Date cutoffDate, String imposeStatus,
			int imposeCount, String imposeFinish, int generalCost, int guardCost, int cleanCost, int disinfectCost,
			int elevatorCost, int repairCost, int commission, int fireInsuranceCost, int electricCost, int tvCost,
			int waterCost, int heatingCost, int hwaterCost, int allElectricCost, int allWaterCost, int electricUsage,
			int waterUsage, double heatingUsage, double hwaterUsage, int arrears, String etc, String vbankNum,
			int amount, double beforeAmount, double afterAmount, double arrearsFine) {
		super();
		this.merchantUid = merchantUid;
		this.userId = userId;
		this.userName = userName;
		this.billYearMonth = billYearMonth;
		this.calculateStartDay = calculateStartDay;
		this.calculateEndDay = calculateEndDay;
		this.imposeEndDay = imposeEndDay;
		this.acceptDate = acceptDate;
		this.cutoffDate = cutoffDate;
		this.imposeStatus = imposeStatus;
		this.imposeCount = imposeCount;
		this.imposeFinish = imposeFinish;
		this.generalCost = generalCost;
		this.guardCost = guardCost;
		this.cleanCost = cleanCost;
		this.disinfectCost = disinfectCost;
		this.elevatorCost = elevatorCost;
		this.repairCost = repairCost;
		this.commission = commission;
		this.fireInsuranceCost = fireInsuranceCost;
		this.electricCost = electricCost;
		this.tvCost = tvCost;
		this.waterCost = waterCost;
		this.heatingCost = heatingCost;
		this.hwaterCost = hwaterCost;
		this.allElectricCost = allElectricCost;
		this.allWaterCost = allWaterCost;
		this.electricUsage = electricUsage;
		this.waterUsage = waterUsage;
		this.heatingUsage = heatingUsage;
		this.hwaterUsage = hwaterUsage;
		this.arrears = arrears;
		this.etc = etc;
		this.vbankNum = vbankNum;
		this.amount = amount;
		this.beforeAmount = beforeAmount;
		this.afterAmount = afterAmount;
		this.arrearsFine = arrearsFine;
	}

	public long getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(long merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.sql.Date getBillYearMonth() {
		return billYearMonth;
	}

	public void setBillYearMonth(java.sql.Date billYearMonth) {
		this.billYearMonth = billYearMonth;
	}

	public java.sql.Date getCalculateStartDay() {
		return calculateStartDay;
	}

	public void setCalculateStartDay(java.sql.Date calculateStartDay) {
		this.calculateStartDay = calculateStartDay;
	}

	public java.sql.Date getCalculateEndDay() {
		return calculateEndDay;
	}

	public void setCalculateEndDay(java.sql.Date calculateEndDay) {
		this.calculateEndDay = calculateEndDay;
	}

	public java.sql.Date getImposeEndDay() {
		return imposeEndDay;
	}

	public void setImposeEndDay(java.sql.Date imposeEndDay) {
		this.imposeEndDay = imposeEndDay;
	}

	public java.sql.Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(java.sql.Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public java.sql.Date getCutoffDate() {
		return cutoffDate;
	}

	public void setCutoffDate(java.sql.Date cutoffDate) {
		this.cutoffDate = cutoffDate;
	}

	public String getImposeStatus() {
		return imposeStatus;
	}

	public void setImposeStatus(String imposeStatus) {
		this.imposeStatus = imposeStatus;
	}

	public int getImposeCount() {
		return imposeCount;
	}

	public void setImposeCount(int imposeCount) {
		this.imposeCount = imposeCount;
	}

	public String getImposeFinish() {
		return imposeFinish;
	}

	public void setImposeFinish(String imposeFinish) {
		this.imposeFinish = imposeFinish;
	}

	public int getGeneralCost() {
		return generalCost;
	}

	public void setGeneralCost(int generalCost) {
		this.generalCost = generalCost;
	}

	public int getGuardCost() {
		return guardCost;
	}

	public void setGuardCost(int guardCost) {
		this.guardCost = guardCost;
	}

	public int getCleanCost() {
		return cleanCost;
	}

	public void setCleanCost(int cleanCost) {
		this.cleanCost = cleanCost;
	}

	public int getDisinfectCost() {
		return disinfectCost;
	}

	public void setDisinfectCost(int disinfectCost) {
		this.disinfectCost = disinfectCost;
	}

	public int getElevatorCost() {
		return elevatorCost;
	}

	public void setElevatorCost(int elevatorCost) {
		this.elevatorCost = elevatorCost;
	}

	public int getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(int repairCost) {
		this.repairCost = repairCost;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getFireInsuranceCost() {
		return fireInsuranceCost;
	}

	public void setFireInsuranceCost(int fireInsuranceCost) {
		this.fireInsuranceCost = fireInsuranceCost;
	}

	public int getElectricCost() {
		return electricCost;
	}

	public void setElectricCost(int electricCost) {
		this.electricCost = electricCost;
	}

	public int getTvCost() {
		return tvCost;
	}

	public void setTvCost(int tvCost) {
		this.tvCost = tvCost;
	}

	public int getWaterCost() {
		return waterCost;
	}

	public void setWaterCost(int waterCost) {
		this.waterCost = waterCost;
	}

	public int getHeatingCost() {
		return heatingCost;
	}

	public void setHeatingCost(int heatingCost) {
		this.heatingCost = heatingCost;
	}

	public int getHwaterCost() {
		return hwaterCost;
	}

	public void setHwaterCost(int hwaterCost) {
		this.hwaterCost = hwaterCost;
	}

	public int getAllElectricCost() {
		return allElectricCost;
	}

	public void setAllElectricCost(int allElectricCost) {
		this.allElectricCost = allElectricCost;
	}

	public int getAllWaterCost() {
		return allWaterCost;
	}

	public void setAllWaterCost(int allWaterCost) {
		this.allWaterCost = allWaterCost;
	}

	public int getElectricUsage() {
		return electricUsage;
	}

	public void setElectricUsage(int electricUsage) {
		this.electricUsage = electricUsage;
	}

	public int getWaterUsage() {
		return waterUsage;
	}

	public void setWaterUsage(int waterUsage) {
		this.waterUsage = waterUsage;
	}

	public double getHeatingUsage() {
		return heatingUsage;
	}

	public void setHeatingUsage(double heatingUsage) {
		this.heatingUsage = heatingUsage;
	}

	public double getHwaterUsage() {
		return hwaterUsage;
	}

	public void setHwaterUsage(double hwaterUsage) {
		this.hwaterUsage = hwaterUsage;
	}

	public int getArrears() {
		return arrears;
	}

	public void setArrears(int arrears) {
		this.arrears = arrears;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getVbankNum() {
		return vbankNum;
	}

	public void setVbankNum(String vbankNum) {
		this.vbankNum = vbankNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getBeforeAmount() {
		return beforeAmount;
	}

	public void setBeforeAmount(double beforeAmount) {
		this.beforeAmount = beforeAmount;
	}

	public double getAfterAmount() {
		return afterAmount;
	}

	public void setAfterAmount(double afterAmount) {
		this.afterAmount = afterAmount;
	}

	public double getArrearsFine() {
		return arrearsFine;
	}

	public void setArrearsFine(double arrearsFine) {
		this.arrearsFine = arrearsFine;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bill [merchantUid=" + merchantUid + ", userId=" + userId + ", userName=" + userName + ", billYearMonth="
				+ billYearMonth + ", calculateStartDay=" + calculateStartDay + ", calculateEndDay=" + calculateEndDay
				+ ", imposeEndDay=" + imposeEndDay + ", acceptDate=" + acceptDate + ", cutoffDate=" + cutoffDate
				+ ", imposeStatus=" + imposeStatus + ", imposeCount=" + imposeCount + ", imposeFinish=" + imposeFinish
				+ ", generalCost=" + generalCost + ", guardCost=" + guardCost + ", cleanCost=" + cleanCost
				+ ", disinfectCost=" + disinfectCost + ", elevatorCost=" + elevatorCost + ", repairCost=" + repairCost
				+ ", commission=" + commission + ", fireInsuranceCost=" + fireInsuranceCost + ", electricCost="
				+ electricCost + ", tvCost=" + tvCost + ", waterCost=" + waterCost + ", heatingCost=" + heatingCost
				+ ", hwaterCost=" + hwaterCost + ", allElectricCost=" + allElectricCost + ", allWaterCost="
				+ allWaterCost + ", electricUsage=" + electricUsage + ", waterUsage=" + waterUsage + ", heatingUsage="
				+ heatingUsage + ", hwaterUsage=" + hwaterUsage + ", arrears=" + arrears + ", etc=" + etc
				+ ", vbankNum=" + vbankNum + ", amount=" + amount + ", beforeAmount=" + beforeAmount + ", afterAmount="
				+ afterAmount + ", arrearsFine=" + arrearsFine + "]";
	}

	
	
}
