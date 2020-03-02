package com.team5.funthing.user.model.vo;

import java.sql.Date;

public class CSBoardVO {
		
	private int CSID;
	private String email;
	private String csTitle;
	private String csContent;
	private Date csRegdate;
	private char replyProgress;
	
	public int getCSID() {
		return CSID;
	}
	public void setCSID(int cSID) {
		CSID = cSID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCsTitle() {
		return csTitle;
	}
	public void setCsTitle(String csTitle) {
		this.csTitle = csTitle;
	}
	public String getCsContent() {
		return csContent;
	}
	public void setCsContent(String csContent) {
		this.csContent = csContent;
	}
	public Date getCsRegdate() {
		return csRegdate;
	}
	public void setCsRegdate(Date csRegdate) {
		this.csRegdate = csRegdate;
	}
	public char getReplyProgress() {
		return replyProgress;
	}
	public void setReplyProgress(char replyProgress) {
		this.replyProgress = replyProgress;
	}
	@Override
	public String toString() {
		return "CSBoardVO [CSID=" + CSID + ", email=" + email + ", csTitle=" + csTitle + ", csContent=" + csContent
				+ ", csRegdate=" + csRegdate + ", replyProgress=" + replyProgress + "]";
	}
	
	
	
}
