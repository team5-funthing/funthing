package com.team5.funthing.user.model.vo;

import java.util.List;

public class RewardVO {
	
	private int rewardPrice;						
	private int rewardNo;
	private int projectNo;
	private String rewardName;
	private String rewardContent;
	private String rewardOption;		//CRUD 테스트를 위하여 한줄의 글로 입력
	//private List<String> rewardOption;
	private int shippingFee;
	private int rewardAmount;
	
	public int getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
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
//	public List<String> getRewardOption() {
//		return rewardOption;
//	}
//	public void setRewardOption(List<String> rewardOption) {
//		this.rewardOption = rewardOption;
//	}
	public String getRewardContent() {
		return rewardContent;
	}
	public String getRewardOption() {
		return rewardOption;
	}
	public void setRewardOption(String rewardOption) {
		this.rewardOption = rewardOption;
	}
	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}
	public int getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(int rewardAmount) {
		this.rewardAmount = rewardAmount;
	}
	@Override
	public String toString() {
		return "RewardVO [rewardPrice=" + rewardPrice + ", rewardNo=" + rewardNo + ", projectNo=" + projectNo
				+ ", rewardName=" + rewardName + ", rewardContent=" + rewardContent + ", rewardOption=" + rewardOption
				+ ", shippingFee=" + shippingFee + ", rewardAmount=" + rewardAmount + "]";
	}
	
	
	
	
	
	
	
}
