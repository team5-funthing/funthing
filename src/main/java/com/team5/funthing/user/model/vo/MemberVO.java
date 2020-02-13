package com.team5.funthing.user.model.vo;

public class MemberVO {
	
	private String email;
	private String password;
	private String name;
	private String phone;
	private String introduce;
	private String myImage;
	private String report;
	
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
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", introduce=" + introduce + ", myImage=" + myImage + ", report=" + report + "]";
	}
	
	
}
