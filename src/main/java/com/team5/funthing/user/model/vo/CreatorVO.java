package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class CreatorVO {
	
	private String creator;
	private String email;

	private String creatorProfileImage = "";
	private String makerPhone = "";
	private String businessNumber = "";
	private String businessAddress = "";
	private String businessFileLink = "";
	private String lv;			
	
	private ProjectAskMessageVO projectAskMessage;

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

	public String getCreatorProfileImage() {
		return creatorProfileImage;
	}

	public void setCreatorProfileImage(String creatorProfileImage) {
		this.creatorProfileImage = creatorProfileImage;
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

	public ProjectAskMessageVO getProjectAskMessage() {
		return projectAskMessage;
	}

	public void setProjectAskMessage(ProjectAskMessageVO projectAskMessage) {
		this.projectAskMessage = projectAskMessage;
	}

	@Override
	public String toString() {
		return "CreatorVO [creator=" + creator + ", email=" + email + ", creatorProfileImage=" + creatorProfileImage
				+ ", makerPhone=" + makerPhone + ", businessNumber=" + businessNumber + ", businessAddress="
				+ businessAddress + ", businessFileLink=" + businessFileLink + ", lv=" + lv + ", projectAskMessage="
				+ projectAskMessage + "]";
	}
	
}
