package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class RewardOptionValueListVO {
	
	private int selectRewardNo;
	private String rewardOptionValue;
	
	public int getSelectRewardNo() {
		return selectRewardNo;
	}
	public void setSelectRewardNo(int selectRewardNo) {
		this.selectRewardNo = selectRewardNo;
	}
	public String getRewardOptionValue() {
		return rewardOptionValue;
	}
	public void setRewardOptionValue(String rewardOptionValue) {
		this.rewardOptionValue = rewardOptionValue;
	}
	
	@Override
	public String toString() {
		return "RewardOptionValueListVO [selectRewardNo=" + selectRewardNo + ", rewardOptionValue=" + rewardOptionValue
				+ "]";
	}
	
	
}
