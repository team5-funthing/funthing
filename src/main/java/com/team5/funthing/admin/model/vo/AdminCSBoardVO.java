package com.team5.funthing.admin.model.vo;

import java.sql.Date;

public class AdminCSBoardVO {

	private int CSID;
	private String adminID;
	private String adminCSTitle;
	private String adminCSContent;
	private Date adminCSRegdate;
	
	
	public int getCSID() {
		return CSID;
	}
	public void setCSID(int cSID) {
		CSID = cSID;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getAdminCSTitle() {
		return adminCSTitle;
	}
	public void setAdminCSTitle(String adminCSTitle) {
		this.adminCSTitle = adminCSTitle;
	}
	public String getAdminCSContent() {
		return adminCSContent;
	}
	public void setAdminCSContent(String adminCSContent) {
		this.adminCSContent = adminCSContent;
	}
	public Date getAdminCSRegdate() {
		return adminCSRegdate;
	}
	public void setAdminCSRegdate(Date adminCSRegdate) {
		this.adminCSRegdate = adminCSRegdate;
	}
	
	
	@Override
	public String toString() {
		return "AdminCSBoardVO [CSID=" + CSID + ", adminID=" + adminID + ", adminCSTitle=" + adminCSTitle
				+ ", adminCSContent=" + adminCSContent + ", adminCSRegdate=" + adminCSRegdate + "]";
	}
	
	
	
}
