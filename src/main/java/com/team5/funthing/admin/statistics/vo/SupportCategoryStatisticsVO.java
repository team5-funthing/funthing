package com.team5.funthing.admin.statistics.vo;

public class SupportCategoryStatisticsVO {

	private String category;
	private int fundingMoney;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getFundingMoney() {
		return fundingMoney;
	}
	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}
	@Override
	public String toString() {
		return "SupportCategoryStatisticsVO [category=" + category + ", fundingMoney=" + fundingMoney + "]";
	}
	
	
	
}
