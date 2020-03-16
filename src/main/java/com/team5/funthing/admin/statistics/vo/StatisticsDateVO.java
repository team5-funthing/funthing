package com.team5.funthing.admin.statistics.vo;

import org.springframework.stereotype.Component;

@Component
public class StatisticsDateVO {

	private String statisticsStartDate;
	private String statisticsEndDate;
	
	private String funding;
	private String status;
	private String paymentStatus;
	
	public String getStatisticsStartDate() {
		return statisticsStartDate;
	}
	public void setStatisticsStartDate(String statisticsStartDate) {
		this.statisticsStartDate = statisticsStartDate;
	}
	public String getStatisticsEndDate() {
		return statisticsEndDate;
	}
	public void setStatisticsEndDate(String statisticsEndDate) {
		this.statisticsEndDate = statisticsEndDate;
	}
	public String getFunding() {
		return funding;
	}
	public void setFunding(String funding) {
		this.funding = funding;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "StatisticsDateVO [statisticsStartDate=" + statisticsStartDate + ", statisticsEndDate="
				+ statisticsEndDate + ", funding=" + funding + ", status=" + status + ", paymentStatus=" + paymentStatus
				+ "]";
	}

	
	
	
}
