package com.team5.funthing.admin.model.vo;

public class AdminMemberVO {

	private String adminId;
	private String adminPassword;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "AdminMemberVO [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
	}
	
}
