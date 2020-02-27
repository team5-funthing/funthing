package com.team5.funthing.user.model.vo;

public class RewardOptionVO {
	
	private Integer rewardOptionNo;
	private Integer rewardNo;
	private String rewardOptionKey;
	private String rewardOptionValue;
	
	public Integer getRewardOptionNo() {
		return rewardOptionNo;
	}
	public void setRewardOptionNo(Integer rewardOptionNo) {
		this.rewardOptionNo = rewardOptionNo;
	}
	public Integer getRewardNo() {
		return rewardNo;
	}
	public void setRewardNo(Integer rewardNo) {
		this.rewardNo = rewardNo;
	}
	public String getRewardOptionKey() {
		return rewardOptionKey;
	}
	public void setRewardOptionKey(String rewardOptionKey) {
		this.rewardOptionKey = rewardOptionKey;
	}
	public String getRewardOptionValue() {
		return rewardOptionValue;
	}
	public void setRewardOptionValue(String rewardOptionValue) {
		this.rewardOptionValue = rewardOptionValue;
	}
	
	@Override
	public String toString() {
		return "RewardOptionVO [rewardOptionNo=" + rewardOptionNo + ", rewardNo=" + rewardNo + ", rewardOptionKey="
				+ rewardOptionKey + ", rewardOptionValue=" + rewardOptionValue + "]";
	}
	
}
