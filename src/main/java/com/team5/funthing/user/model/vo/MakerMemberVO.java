package com.team5.funthing.user.model.vo;

public class MakerMemberVO {

	private String creator;
	private String email;
	private String MakerPhone;
	private String businessSelect;
	private String businessNumber;
	private String businessAddress;
	private String businessFilelink;
	private String lv;
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
		return MakerPhone;
	}
	public void setMakerPhone(String makerPhone) {
		MakerPhone = makerPhone;
	}
	public String getBusinessSelect() {
		return businessSelect;
	}
	public void setBusinessSelect(String businessSelect) {
		this.businessSelect = businessSelect;
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
	public String getBusinessFilelink() {
		return businessFilelink;
	}
	public void setBusinessFilelink(String businessFilelink) {
		this.businessFilelink = businessFilelink;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	@Override
	public String toString() {
		return "MakerMemberVO [creator=" + creator + ", email=" + email + ", MakerPhone=" + MakerPhone
				+ ", businessSelect=" + businessSelect + ", businessNumber=" + businessNumber + ", businessAddress="
				+ businessAddress + ", businessFilelink=" + businessFilelink + ", lv=" + lv + "]";
	}
	
	
	
}
