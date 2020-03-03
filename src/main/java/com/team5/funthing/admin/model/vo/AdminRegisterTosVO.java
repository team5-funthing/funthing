package com.team5.funthing.admin.model.vo;

public class AdminRegisterTosVO {

	private int registerNo;
	private String registerTosTitle;
	private String registerTosContent;
	
	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public String getRegisterTosTitle() {
		return registerTosTitle;
	}
	public void setRegisterTosTitle(String registerTosTitle) {
		this.registerTosTitle = registerTosTitle;
	}
	public String getRegisterTosContent() {
		return registerTosContent;
	}
	public void setRegisterTosContent(String registerTosContent) {
		this.registerTosContent = registerTosContent;
	}
	
	@Override
	public String toString() {
		return "AdminRegisterTosVO [registerNo=" + registerNo + ", registerTosTitle=" + registerTosTitle
				+ ", registerTosContent=" + registerTosContent + "]";
	}
	
	
	
}
