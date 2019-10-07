package maintenance.model.vo;

public class BillView implements java.io.Serializable{
	private static final long serialVersionUID=100005L;
	
	private String userId; // 동/호수
	private int amount; // 부과총액
	private int arrears; // 미납액
	private int beforeAmount; // 납기내 금액
	private int arrearsFine; // 미납후금액
	private int afterAmount; // 납기후 금액
	private long merchantUid; // 고지서 번호
	
	public BillView() {}
	
	public BillView(String userId, int amount, int arrears, int beforeAmount, int arrearsFine, int afterAmount,
			long merchantUid) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.arrears = arrears;
		this.beforeAmount = beforeAmount;
		this.arrearsFine = arrearsFine;
		this.afterAmount = afterAmount;
		this.merchantUid = merchantUid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getArrears() {
		return arrears;
	}

	public void setArrears(int arrears) {
		this.arrears = arrears;
	}

	public int getBeforeAmount() {
		return beforeAmount;
	}

	public void setBeforeAmount(int beforeAmount) {
		this.beforeAmount = beforeAmount;
	}

	public int getArrearsFine() {
		return arrearsFine;
	}

	public void setArrearsFine(int arrearsFine) {
		this.arrearsFine = arrearsFine;
	}

	public int getAfterAmount() {
		return afterAmount;
	}

	public void setAfterAmount(int afterAmount) {
		this.afterAmount = afterAmount;
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
		return "BillView [userId=" + userId + ", amount=" + amount + ", arrears=" + arrears + ", beforeAmount="
				+ beforeAmount + ", arrearsFine=" + arrearsFine + ", afterAmount=" + afterAmount + ", merchantUid="
				+ merchantUid + "]";
	}

	
	
}
