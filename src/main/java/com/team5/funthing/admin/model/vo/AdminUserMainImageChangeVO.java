package com.team5.funthing.admin.model.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminUserMainImageChangeVO {
	
	private int imageNo;
	private String imagePath;
	private String imageContent;
	
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getImageContent() {
		return imageContent;
	}
	public void setImageContent(String imageContent) {
		this.imageContent = imageContent;
	}
	@Override
	public String toString() {
		return "AdminUserMainImageChangeVO [imageNo=" + imageNo + ", imagePath=" + imagePath + ", imageContent="
				+ imageContent + "]";
	}
	

	
	
	

}
