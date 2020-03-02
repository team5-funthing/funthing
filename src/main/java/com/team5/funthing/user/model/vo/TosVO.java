package com.team5.funthing.user.model.vo;

public class TosVO {

	private int tosNo;
	private String tosTitle;
	private String tosContent;
	
	public int getTosNo() {
		return tosNo;
	}
	public void setTosNo(int tosNo) {
		this.tosNo = tosNo;
	}
	public String getTosTitle() {
		return tosTitle;
	}
	public void setTosTitle(String tosTitle) {
		this.tosTitle = tosTitle;
	}
	public String getTosContent() {
		return tosContent;
	}
	public void setTosContent(String tosContent) {
		this.tosContent = tosContent;
	}
	
	@Override
	public String toString() {
		return "AdminTOSInputVO [tosNo=" + tosNo + ", tosTitle=" + tosTitle + ", tosContent=" + tosContent + "]";
	}
	
}
