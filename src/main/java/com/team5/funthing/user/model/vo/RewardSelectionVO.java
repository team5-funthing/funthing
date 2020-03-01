package com.team5.funthing.user.model.vo;

/**
 * 
 * @author qpara
 *
 *	한가지 리워드에 대한 주문 양과 가격
 */

public class RewardSelectionVO {
	
	private int selectRewardNo;
	private int orderNo;
	private int rewardNo;
	private String email;
	private int paymentAmount; // 지불가격?
	private int orderAmount; // 주문 양
	private int shippingFee;
	private String rewardOptionValue;
	
	public int getSelectRewardNo() {
		return selectRewardNo;
	}
	public void setSelectRewardNo(int selectRewardNo) {
		this.selectRewardNo = selectRewardNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getRewardNo() {
		return rewardNo;
	}
	public void setRewardNo(int rewardNo) {
		this.rewardNo = rewardNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getRewardOptionValue() {
		return rewardOptionValue;
	}
	public void setRewardOptionValue(String rewardOptionValue) {
		this.rewardOptionValue = rewardOptionValue;
	}
	@Override
	public String toString() {
		return "RewardSelectionVO [selectRewardNo=" + selectRewardNo + ", orderNo=" + orderNo + ", rewardNo=" + rewardNo
				+ ", email=" + email + ", paymentAmount=" + paymentAmount + ", orderAmount=" + orderAmount
				+ ", shippingFee=" + shippingFee + ", rewardOptionValue=" + rewardOptionValue + "]";
	}
	
}
