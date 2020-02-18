package com.team5.funthing.user.model.vo;

public class ReportVO {
	
	private String email;
	private int projectNo;
	private String reasonSelect;
	private String reason;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getReasonSelect() {
		return reasonSelect;
	}
	public void setReasonSelect(String reasonSelect) {
		this.reasonSelect = reasonSelect;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "ReportVO [email=" + email + ", projectNo=" + projectNo + ", reasonSelect=" + reasonSelect + ", reason="
				+ reason + "]";
	}
	
	
}
