package com.team5.funthing.user.model.vo;

public class NoRewardAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer amount;

	public NoRewardAmountException() {
		super("�����ִ� ������ ���ų� �����մϴ�");
	}
	
}
