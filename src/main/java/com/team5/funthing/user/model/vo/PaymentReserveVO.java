package com.team5.funthing.user.model.vo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PaymentReserveVO {
	
	private int orderNo;
	private int projectNo;
	private String email;
	private Date paymentReserveDate;
	private String paymentOption = "";
	private int applyNo; //���ι�ȣ
	private String paymentStatus;
	private int deliveryAddressNo;
	private int fundingMoney;
	private String aid; // ����, ���, ������� API ȣ�⿡ ���� ������ȣ. 20�ڸ�
	private String tid; // ���� �� �ǿ� ���� ������ȣ. 20�ڸ�
	
// �ݵ� �о��ֱ� �� �߰� �׸�� 
	private int additionalFundingMoney;
	private int shippingFee;
	private String privateName = "off";
	private String privateFundingMoney = "off";
	
// �����Ҷ� �ʿ��� VO
	private RewardVO reward;
	private RewardSelectionVO rewardSelection;
	
//	����Ҷ��ʿ��� �׸��
	private String sumDate; 
	private int sumFundingMoney;
	private String todayDate;
	
	
	private List<RewardSelectionVO> rewardSelectionList;


	
	
	public String getTodayDate() {
		return todayDate;
	}


	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
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


	public int getFundingMoney() {
		return fundingMoney;
	}


	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
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


	public String getSumDate() {
		return sumDate;
	}


	public void setSumDate(String sumDate) {
		this.sumDate = sumDate;
	}


	public int getSumFundingMoney() {
		return sumFundingMoney;
	}


	public void setSumFundingMoney(int sumFundingMoney) {
		this.sumFundingMoney = sumFundingMoney;
	}


	public List<RewardSelectionVO> getRewardSelectionList() {
		return rewardSelectionList;
	}


	public void setRewardSelectionList(List<RewardSelectionVO> rewardSelectionList) {
		this.rewardSelectionList = rewardSelectionList;
	}


	@Override
	public String toString() {
		return "PaymentReserveVO [orderNo=" + orderNo + ", projectNo=" + projectNo + ", email=" + email
				+ ", paymentReserveDate=" + paymentReserveDate + ", paymentOption=" + paymentOption + ", applyNo="
				+ applyNo + ", paymentStatus=" + paymentStatus + ", deliveryAddressNo=" + deliveryAddressNo
				+ ", fundingMoney=" + fundingMoney + ", aid=" + aid + ", tid=" + tid + ", additionalFundingMoney="
				+ additionalFundingMoney + ", shippingFee=" + shippingFee + ", privateName=" + privateName
				+ ", privateFundingMoney=" + privateFundingMoney + ", reward=" + reward + ", rewardSelection="
				+ rewardSelection + ", sumDate=" + sumDate + ", sumFundingMoney=" + sumFundingMoney
				+ ", rewardSelectionList=" + rewardSelectionList + "]";
	}

	
	
}
