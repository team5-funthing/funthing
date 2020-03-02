package com.team5.funthing.user.model.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RewardVO {
	
	private int rewardPrice;						
	private int rewardNo;
	private int projectNo = -1;
	private String rewardName;
	private String rewardContent;
	private String rewardOption;
	private int shippingFee;
	private int rewardAmount;
	private String shippingNeed;
	private String rewardMonth;
	private String rewardDay;

	private List<RewardOptionVO> rewardOptionList;

	public int getRewardPrice() {
		return rewardPrice;
	}

	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}

	public int getRewardNo() {
		return rewardNo;
	}

	public void setRewardNo(int rewardNo) {
		this.rewardNo = rewardNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getRewardContent() {
		return rewardContent;
	}

	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}

	public String getRewardOption() {
		return rewardOption;
	}

	public void setRewardOption(String rewardOption) {
		this.rewardOption = rewardOption;
	}

	public int getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}

	public int getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(int rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public String getShippingNeed() {
		return shippingNeed;
	}

	public void setShippingNeed(String shippingNeed) {
		this.shippingNeed = shippingNeed;
	}

	public String getRewardMonth() {
		return rewardMonth;
	}

	public void setRewardMonth(String rewardMonth) {
		this.rewardMonth = rewardMonth;
	}

	public String getRewardDay() {
		return rewardDay;
	}

	public void setRewardDay(String rewardDay) {
		this.rewardDay = rewardDay;
	}

	public List<RewardOptionVO> getRewardOptionList() {
		return rewardOptionList;
	}

	public void setRewardOptionList(List<RewardOptionVO> rewardOptionList) {
		this.rewardOptionList = rewardOptionList;
	}

	@Override
	public String toString() {
		return "RewardVO [rewardPrice=" + rewardPrice + ", rewardNo=" + rewardNo + ", projectNo=" + projectNo
				+ ", rewardName=" + rewardName + ", rewardContent=" + rewardContent + ", rewardOption=" + rewardOption
				+ ", shippingFee=" + shippingFee + ", rewardAmount=" + rewardAmount + ", shippingNeed=" + shippingNeed
				+ ", rewardMonth=" + rewardMonth + ", rewardDay=" + rewardDay + ", rewardOptionList=" + rewardOptionList
				+ "]";
	}



}
