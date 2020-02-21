package com.team5.funthing.user.model.vo;

public class CreatorVO {

	private String creator;
	private String email;
	private String makerPhone;
	private String businessNumber;
	private String businessAddress;
	private String businessFileLink;
	private String lv;					//메이커의 등급
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMakerPhone() {
		return makerPhone;
	}
	public void setMakerPhone(String makerPhone) {
		this.makerPhone = makerPhone;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getBusinessFileLink() {
		return businessFileLink;
	}
	public void setBusinessFileLink(String businessFileLink) {
		this.businessFileLink = businessFileLink;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	
	@Override
	public String toString() {
		return "UserMakerMemberVO [creator=" + creator + ", email=" + email + ", makerPhone=" + makerPhone
				+ ", businessNumber=" + businessNumber + ", businessAddress=" + businessAddress + ", businessFileLink="
				+ businessFileLink + ", lv=" + lv + "]";
	}
		
}
