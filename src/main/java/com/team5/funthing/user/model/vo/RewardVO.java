package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class RewardVO {
	
	private int rewardPrice;						
	private int rewardNo;
	private int projectNo;
	private String rewardName;
	private String rewardContent;
	private String rewardOption;
	private int shippingFee;
	private int rewardAmount;
	private String shippingNeed;
	
	private List<RewardOptionVO> rewardOptionList;
	
	public String getShippingNeed() {
		return shippingNeed;
	}
	public void setShippingNeed(String shippingNeed) {
		this.shippingNeed = shippingNeed;
	}
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
				+ ", rewardOptionList=" + rewardOptionList + "]";
	}

	
}
