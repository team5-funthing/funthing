package com.team5.funthing.admin.model.vo;

import java.sql.Date;

public class AdminNoticeBoardVO {

	private int noticeNo;
	private String adminId;
	private String noticeTitle;
	private	String noticeContents;
	private Date noticeDate;
	private String noticeCategory;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	@Override
	public String toString() {
		return "AdminNoticeBoardVO [noticeNo=" + noticeNo + ", adminId=" + adminId + ", noticeTitle=" + noticeTitle
				+ ", noticeContents=" + noticeContents + ", noticeDate=" + noticeDate + ", noticeCategory="
				+ noticeCategory + "]";
	}
	
	
	
	
}
