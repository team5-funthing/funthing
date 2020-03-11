package com.team5.funthing.admin.model.vo;

public class AdminMainViewVO {
	
	private char status;
	private String funding;

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getFunding() {
		return funding;
	}

	public void setFunding(String funding) {
		this.funding = funding;
	}

	@Override
	public String toString() {
		return "AdminMainViewVO [status=" + status + ", funding=" + funding + "]";
	}
	
	
	
	
}
