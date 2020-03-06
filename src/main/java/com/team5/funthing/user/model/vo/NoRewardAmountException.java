package com.team5.funthing.user.model.vo;

public class NoRewardAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer amount;

	public NoRewardAmountException() {
		super("남아있는 수량이 없거나 부족합니다");
	}
	
}
