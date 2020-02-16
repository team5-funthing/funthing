package com.team5.funthing.user.model.vo;

import org.springframework.web.multipart.MultipartFile;



public class uploadTestVO {
	
	private MultipartFile uploadFile;

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	

}
