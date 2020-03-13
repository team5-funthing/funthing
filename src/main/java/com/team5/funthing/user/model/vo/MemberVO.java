package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	
	private String email;
	private String password;
	private String name;
	private String phone;
	private String introduce;
	private String myImage;
	private String report;
	private String socialjoined;

	private String position;


	private CreatorVO creator;
	
	
	

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getMyImage() {
		return myImage;
	}

	public void setMyImage(String myImage) {
		this.myImage = myImage;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public CreatorVO getCreator() {
		return creator;
	}

	public void setCreator(CreatorVO creator) {
		this.creator = creator;
	}

	public String getSocialjoined() {
		return socialjoined;
	}

	public void setSocialjoined(String socialjoined) {
		this.socialjoined = socialjoined;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", introduce=" + introduce + ", myImage=" + myImage + ", report=" + report + ", socialjoined="
				+ socialjoined + ", position=" + position + ", creator=" + creator + "]";
	}


	

	
	
	
	
	
}
