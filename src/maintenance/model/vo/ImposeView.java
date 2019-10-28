package maintenance.model.vo;

import java.sql.Date;

public class ImposeView implements java.io.Serializable{
	private static final long serialVersionUID = 100051L;
	
	private long merchantUid;
	private String userId;
	private String userName;
	private java.sql.Date billYearMonth;	
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
	private int amount; // 부과금액	
	
	public ImposeView() {}

	public ImposeView(long merchantUid, String userId, String userName, Date billYearMonth, int generalCost,
			int guardCost, int cleanCost, int disinfectCost, int elevatorCost, int repairCost, int commission,
			int fireInsuranceCost, int electricCost, int tvCost, int waterCost, int heatingCost, int hwaterCost,
			int allElectricCost, int allWaterCost, int electricUsage, int waterUsage, double heatingUsage,
			double hwaterUsage, int amount) {
		super();
		this.merchantUid = merchantUid;
		this.userId = userId;
		this.userName = userName;
		this.billYearMonth = billYearMonth;
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
		this.amount = amount;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImposeView [merchantUid=" + merchantUid + ", userId=" + userId + ", userName=" + userName
				+ ", billYearMonth=" + billYearMonth + ", generalCost=" + generalCost + ", guardCost=" + guardCost
				+ ", cleanCost=" + cleanCost + ", disinfectCost=" + disinfectCost + ", elevatorCost=" + elevatorCost
				+ ", repairCost=" + repairCost + ", commission=" + commission + ", fireInsuranceCost="
				+ fireInsuranceCost + ", electricCost=" + electricCost + ", tvCost=" + tvCost + ", waterCost="
				+ waterCost + ", heatingCost=" + heatingCost + ", hwaterCost=" + hwaterCost + ", allElectricCost="
				+ allElectricCost + ", allWaterCost=" + allWaterCost + ", electricUsage=" + electricUsage
				+ ", waterUsage=" + waterUsage + ", heatingUsage=" + heatingUsage + ", hwaterUsage=" + hwaterUsage
				+ ", amount=" + amount + "]";
	}
	
	
	
}
