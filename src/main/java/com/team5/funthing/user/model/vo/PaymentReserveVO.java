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
	private int fundingMoney;
	
	//펀딩 밀어주기 시 추가항목들
	private int additionalFundingMoney;
	private int shippingFee;
	private String privateName = "off";
	private String privateFundingMoney = "off";
	
	//조인할때 필요한 VO
	private RewardVO reward;
	private RewardSelectionVO rewardSelection;
	
	
	private List<RewardSelectionVO> rewardSelectionList;
	
	
	
	
	public RewardVO getReward() {
		return reward;
	}
	public void setReward(RewardVO reward) {
		this.reward = reward;
	}
	public RewardSelectionVO getRewardSelection() {
		return rewardSelection;
	}
	public void setRewardSelection(RewardSelectionVO rewardSelection) {
		this.rewardSelection = rewardSelection;
	}
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
	public int getAdditionalFundingMoney() {
		return additionalFundingMoney;
	}
	public void setAdditionalFundingMoney(int additionalFundingMoney) {
		this.additionalFundingMoney = additionalFundingMoney;
	}
	public int getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
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
	public List<RewardSelectionVO> getRewardSelectionList() {
		return rewardSelectionList;
	}
	public void setRewardSelectionList(List<RewardSelectionVO> rewardSelectionList) {
		this.rewardSelectionList = rewardSelectionList;
	}
	public int getFundingMoney() {
		return fundingMoney;
	}
	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}
	@Override
	public String toString() {
		return "PaymentReserveVO [orderNo=" + orderNo + ", email=" + email + ", paymentReserveDate="
				+ paymentReserveDate + ", paymentOption=" + paymentOption + ", applyNo=" + applyNo + ", paymentStatus="
				+ paymentStatus + ", deliveryAddressNo=" + deliveryAddressNo + ", fundingMoney=" + fundingMoney
				+ ", additionalFundingMoney=" + additionalFundingMoney + ", shippingFee=" + shippingFee
				+ ", privateName=" + privateName + ", privateFundingMoney=" + privateFundingMoney
				+ ", rewardSelectionList=" + rewardSelectionList + "]";
	}

	
	
}
