package com.team5.funthing.admin.model.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminUserMainImageChangeVO {
	
	private int imageNo;
	private String imagePath;
	private String imageName;
	
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "AdminUserMainImageChangeVO [imageNo=" + imageNo + ", imagePath=" + imagePath + ", imageName="
				+ imageName + "]";
	}

	
	
	

}
