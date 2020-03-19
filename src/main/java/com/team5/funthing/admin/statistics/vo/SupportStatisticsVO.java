package com.team5.funthing.admin.statistics.vo;

public class SupportStatisticsVO {
	
	private int fundingMoney = 0;
	private String statisticsDate;
	
	public int getFundingMoney() {
		return fundingMoney;
	}
	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}
	public String getStatisticsDate() {
		return statisticsDate;
	}
	public void setStatisticsDate(String statisticsDate) {
		this.statisticsDate = statisticsDate;
	}
	@Override
	public String toString() {
		return "SupportStatisticsVO [fundingMoney=" + fundingMoney + ", statisticsDate=" + statisticsDate + "]";
	}
	
	
	
	
}
