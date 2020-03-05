package com.team5.funthing.user.model.vo;

import java.util.Date;
import java.util.List;

public class PaymentReserveVO {
	
	private int orderNo;
	private String email;
	private Date paymentReserveDate;
	private String paymentOption = "카카오페이";
	private int applyNo; // 승인번호
	private String paymentStatus;
	private int deliveryAddressNo;
	
	private FundingAdditionsVO fundingAdditions;
	
	private List<RewardSelectionVO> RewardSelectionList;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getPaymentReserveDate() {
		return paymentReserveDate;
	}

	public void setPaymentReserveDate(Date paymentReserveDate) {
		this.paymentReserveDate = paymentReserveDate;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getDeliveryAddressNo() {
		return deliveryAddressNo;
	}

	public void setDeliveryAddressNo(int deliveryAddressNo) {
		this.deliveryAddressNo = deliveryAddressNo;
	}

	public FundingAdditionsVO getFundingAdditions() {
		return fundingAdditions;
	}

	public void setFundingAdditions(FundingAdditionsVO fundingAdditions) {
		this.fundingAdditions = fundingAdditions;
	}

	public List<RewardSelectionVO> getRewardSelectionList() {
		return RewardSelectionList;
	}

	public void setRewardSelectionList(List<RewardSelectionVO> rewardSelectionList) {
		RewardSelectionList = rewardSelectionList;
	}

	@Override
	public String toString() {
		return "PaymentReserveVO [orderNo=" + orderNo + ", email=" + email + ", paymentReserveDate="
				+ paymentReserveDate + ", paymentOption=" + paymentOption + ", applyNo=" + applyNo + ", paymentStatus="
				+ paymentStatus + ", deliveryAddressNo=" + deliveryAddressNo + ", fundingAdditions=" + fundingAdditions
				+ ", RewardSelectionList=" + RewardSelectionList + "]";
	}

	
	


	
		
}
