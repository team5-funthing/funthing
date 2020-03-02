package com.team5.funthing.user.model.vo;

import java.util.Date;
import java.util.List;

public class PaymentReserveVO {
	
	private int orderNo;
	private String email;
	private Date paymentDate;
	private String paymentOption;
	private int applyNo; // ½ÂÀÎ¹øÈ£
	private String paymentStatus;
	
	private DeliveryAddressVO deliveryAddress;
	private List<RewardSelectionVO> RewardSelection;
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
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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
	public DeliveryAddressVO getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(DeliveryAddressVO deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<RewardSelectionVO> getRewardSelection() {
		return RewardSelection;
	}
	public void setRewardSelection(List<RewardSelectionVO> rewardSelection) {
		RewardSelection = rewardSelection;
	}
	@Override
	public String toString() {
		return "PaymentReserveVO [orderNo=" + orderNo + ", email=" + email + ", paymentDate=" + paymentDate
				+ ", paymentOption=" + paymentOption + ", applyNo=" + applyNo + ", paymentStatus=" + paymentStatus
				+ ", deliveryAddress=" + deliveryAddress + ", RewardSelection=" + RewardSelection + "]";
	}
	
	
	
	

}
