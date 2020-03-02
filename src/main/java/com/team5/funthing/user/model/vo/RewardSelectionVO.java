package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author qpara
 *
 *	�Ѱ��� �����忡 ���� �ֹ� ��� ����
 */

@Component
public class RewardSelectionVO {
	
	private int selectRewardNo;
	private int orderNo;
	private int rewardNo;
	private int paymentAmount; // ���Ұ���?
	private int orderAmount; // �ֹ� ��
	private int shippingFee;
	
	private RewardVO reward;
	
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
	public RewardVO getReward() {
		return reward;
	}
	public void setReward(RewardVO reward) {
		this.reward = reward;
	}
	@Override
	public String toString() {
		return "RewardSelectionVO [selectRewardNo=" + selectRewardNo + ", orderNo=" + orderNo + ", rewardNo=" + rewardNo
				+ ", paymentAmount=" + paymentAmount + ", orderAmount=" + orderAmount + ", shippingFee=" + shippingFee
				+ ", reward=" + reward + "]";
	}
	
	
	
	
}
