package com.team5.funthing.user.model.vo;

public class FundingAdditionsVO {
	
	private int additionalFundingMoney;
	private String privateName;
	private String privateFundingMoney;
	
	public int getAdditionalFundingMoney() {
		return additionalFundingMoney;
	}
	public void setAdditionalFundingMoney(int additionalFundingMoney) {
		this.additionalFundingMoney = additionalFundingMoney;
	}
	public String getPrivateName() {
		return privateName;
	}
	public void setPrivateName(String privateName) {
		this.privateName = privateName;
	}
	public String getPrivateFundingMoney() {
		return privateFundingMoney;
	}
	public void setPrivateFundingMoney(String privateFundingMoney) {
		this.privateFundingMoney = privateFundingMoney;
	}
	@Override
	public String toString() {
		return "FundingAdditionsVO [additionalFundingMoney=" + additionalFundingMoney + ", privateName=" + privateName
				+ ", privateFundingMoney=" + privateFundingMoney + "]";
	}
	
	
	
	
	
	
}
