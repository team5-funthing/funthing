package com.team5.funthing.user.model.vo;

public class ShowProjectListVO {
	
	private String category;
	private String funding = "y";
	private int fundingMoney = 0;
	private int goalMoney = 0;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFunding() {
		return funding;
	}
	public void setFunding(String funding) {
		this.funding = funding;
	}
	public int getFundingMoney() {
		return fundingMoney;
	}
	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}
	public int getGoalMoney() {
		return goalMoney;
	}
	public void setGoalMoney(int goalMoney) {
		this.goalMoney = goalMoney;
	}
	@Override
	public String toString() {
		return "ShowProjectList [category=" + category + ", funding=" + funding + ", fundingMoney=" + fundingMoney
				+ ", goalMoney=" + goalMoney + "]";
	}
	
	
	
	
	
	

}
