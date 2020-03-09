package com.team5.funthing.admin.model.vo;

public class AdminPersonalInfoProcessingVO {

	private int infoNo;
	private String infoTitle;
	private String infoContent;
	
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	
	@Override
	public String toString() {
		return "AdminPersonalInfoProcessingVO [infoNo=" + infoNo + ", infoTitle=" + infoTitle + ", infoContent="
				+ infoContent + "]";
	}

}
