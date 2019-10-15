package maintenance.model.vo;

import java.sql.Date;

public class BaseView implements java.io.Serializable{
	private static final long serialVersionUID = 100031L;
	
	private String imposeStatus; // 상태
	private java.sql.Date billYearMonth; // 부과년월
	private java.sql.Date calculateStartDay; // 산출기간시작
	private java.sql.Date calculateEndDay; // 산출기간마감일
	private java.sql.Date imposeEndDate; // 
	private java.sql.Date acceptDate; // 출력의뢰일시
	private java.sql.Date cutoffDate; // 납부마감일
	private int imposeCount; // 부과마감횟수
	private long merchantUid; // 고유고지서번호
	
	public BaseView() {
		
		
	}

	public BaseView(String imposeStatus, Date billYearMonth, Date calculateStartDay, Date calculateEndDay,
			Date imposeEndDate, Date acceptDate, Date cutoffDate, int imposeCount, long merchantUid) {
		super();
		this.imposeStatus = imposeStatus;
		this.billYearMonth = billYearMonth;
		this.calculateStartDay = calculateStartDay;
		this.calculateEndDay = calculateEndDay;
		this.imposeEndDate = imposeEndDate;
		this.acceptDate = acceptDate;
		this.cutoffDate = cutoffDate;
		this.imposeCount = imposeCount;
		this.merchantUid = merchantUid;
	}

	public String getImposeStatus() {
		return imposeStatus;
	}

	public void setImposeStatus(String imposeStatus) {
		this.imposeStatus = imposeStatus;
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

	public java.sql.Date getImposeEndDate() {
		return imposeEndDate;
	}

	public void setImposeEndDate(java.sql.Date imposeEndDate) {
		this.imposeEndDate = imposeEndDate;
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

	public int getImposeCount() {
		return imposeCount;
	}

	public void setImposeCount(int imposeCount) {
		this.imposeCount = imposeCount;
	}

	public long getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(long merchantUid) {
		this.merchantUid = merchantUid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BaseView [imposeStatus=" + imposeStatus + ", billYearMonth=" + billYearMonth + ", calculateStartDay="
				+ calculateStartDay + ", calculateEndDay=" + calculateEndDay + ", imposeEndDate=" + imposeEndDate
				+ ", acceptDate=" + acceptDate + ", cutoffDate=" + cutoffDate + ", imposeCount=" + imposeCount
				+ ", merchantUid=" + merchantUid + "]";
	}

	
	
	
}
