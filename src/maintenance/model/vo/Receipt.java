package maintenance.model.vo;

import java.sql.Date;

public class Receipt implements java.io.Serializable {
	private static final long serialVersionUID = 100222L;	
	
	private String impUid; // 고유영수증 번호
	private long merchantUid; // 고유고지서 번호
	private int applyNum; // 카드 승인 번호
	private String name; // 고지서 명칭
	private String  pg; // 결제명칭
	private String	payMethod; // 결제 종류
	private int  amount; // 결제할 금액
	private int paidAmount; // 결제 금액
	private java.sql.Date paiDate;
	private String	buyerName;
	private String	buyerTel;
	private String	buyerEmail;
	private String  buyerAddr;
	private String  buyerPostcode;
	
	public Receipt() {}

	public Receipt(String impUid, long merchantUid, int applyNum, String name, String pg, String payMethod, int amount,
			int paidAmount, Date paiDate, String buyerName, String buyerTel, String buyerEmail, String buyerAddr,
			String buyerPostcode) {
		super();
		this.impUid = impUid;
		this.merchantUid = merchantUid;
		this.applyNum = applyNum;
		this.name = name;
		this.pg = pg;
		this.payMethod = payMethod;
		this.amount = amount;
		this.paidAmount = paidAmount;
		this.paiDate = paiDate;
		this.buyerName = buyerName;
		this.buyerTel = buyerTel;
		this.buyerEmail = buyerEmail;
		this.buyerAddr = buyerAddr;
		this.buyerPostcode = buyerPostcode;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public long getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(long merchantUid) {
		this.merchantUid = merchantUid;
	}

	public int getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public java.sql.Date getPaiDate() {
		return paiDate;
	}

	public void setPaiDate(java.sql.Date paiDate) {
		this.paiDate = paiDate;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerAddr() {
		return buyerAddr;
	}

	public void setBuyerAddr(String buyerAddr) {
		this.buyerAddr = buyerAddr;
	}

	public String getBuyerPostcode() {
		return buyerPostcode;
	}

	public void setBuyerPostcode(String buyerPostcode) {
		this.buyerPostcode = buyerPostcode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Receipt [impUid=" + impUid + ", merchantUid=" + merchantUid + ", applyNum=" + applyNum + ", name="
				+ name + ", pg=" + pg + ", payMethod=" + payMethod + ", amount=" + amount + ", paidAmount=" + paidAmount
				+ ", paiDate=" + paiDate + ", buyerName=" + buyerName + ", buyerTel=" + buyerTel + ", buyerEmail="
				+ buyerEmail + ", buyerAddr=" + buyerAddr + ", buyerPostcode=" + buyerPostcode + "]";
	}
	
	

}
