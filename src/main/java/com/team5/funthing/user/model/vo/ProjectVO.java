package com.team5.funthing.user.model.vo;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author bummit
 * 
 * 	Funthing Project 
 * 
 */

public class ProjectVO {
	
//	프로젝트 기본설정 멤버
	private Integer projectNo = -1; 
	private String creator = ""; 
	private String email = "";
	
//	프로젝트 설정 멤버
	private int goalMoney; 
	private String projectMainImage = "";
	private String projectIntroduceImage = ""; // 추후 여러장 가능하게 변경
	private String projectIntroduceVideo = "";
	private String projectTitle = "";
	private String projectSubTitle = "";
	private String category=""; 
	private Date startDate = new Date(); 
	private Date endDate = new Date(); 
	
//	프로젝트 소개 멤버
	private String projectStory=""; 
	private String projectStoryImage="";
	private String projectSummary="";
	private String projectCaution="";
	 // null ok

//	그 외 멤버
	private String supporters; 
	private int fundingMoney; 
	private char status = 'w'; 
	private char informationAgree = 'n'; 
	private char writeStatus = 'n';
	public Integer getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Integer projectNo) {
		this.projectNo = projectNo;
	}
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
	public int getGoalMoney() {
		return goalMoney;
	}
	public void setGoalMoney(int goalMoney) {
		this.goalMoney = goalMoney;
	}
	public String getProjectMainImage() {
		return projectMainImage;
	}
	public void setProjectMainImage(String projectMainImage) {
		this.projectMainImage = projectMainImage;
	}
	public String getProjectIntroduceImage() {
		return projectIntroduceImage;
	}
	public void setProjectIntroduceImage(String projectIntroduceImage) {
		this.projectIntroduceImage = projectIntroduceImage;
	}
	public String getProjectIntroduceVideo() {
		return projectIntroduceVideo;
	}
	public void setProjectIntroduceVideo(String projectIntroduceVideo) {
		this.projectIntroduceVideo = projectIntroduceVideo;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectSubTitle() {
		return projectSubTitle;
	}
	public void setProjectSubTitle(String projectSubTitle) {
		this.projectSubTitle = projectSubTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getProjectStory() {
		return projectStory;
	}
	public void setProjectStory(String projectStory) {
		this.projectStory = projectStory;
	}
	public String getProjectStoryImage() {
		return projectStoryImage;
	}
	public void setProjectStoryImage(String projectStoryImage) {
		this.projectStoryImage = projectStoryImage;
	}
	public String getProjectSummary() {
		return projectSummary;
	}
	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}
	public String getProjectCaution() {
		return projectCaution;
	}
	public void setProjectCaution(String projectCaution) {
		this.projectCaution = projectCaution;
	}
	public String getSupporters() {
		return supporters;
	}
	public void setSupporters(String supporters) {
		this.supporters = supporters;
	}
	public int getFundingMoney() {
		return fundingMoney;
	}
	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public char getInformationAgree() {
		return informationAgree;
	}
	public void setInformationAgree(char informationAgree) {
		this.informationAgree = informationAgree;
	}
	public char getWriteStatus() {
		return writeStatus;
	}
	public void setWriteStatus(char writeStatus) {
		this.writeStatus = writeStatus;
	}
	
	@Override
	public String toString() {
		return "ProjectVO [projectNo=" + projectNo + ", creator=" + creator + ", email=" + email + ", goalMoney="
				+ goalMoney + ", projectMainImage=" + projectMainImage + ", projectIntroduceImage="
				+ projectIntroduceImage + ", projectIntroduceVideo=" + projectIntroduceVideo + ", projectTitle="
				+ projectTitle + ", projectSubTitle=" + projectSubTitle + ", category=" + category + ", startDate="
				+ startDate + ", endDate=" + endDate + ", projectStory=" + projectStory + ", projectStoryImage="
				+ projectStoryImage + ", projectSummary=" + projectSummary + ", projectCaution=" + projectCaution
				+ ", supporters=" + supporters + ", fundingMoney=" + fundingMoney + ", status=" + status
				+ ", informationAgree=" + informationAgree + ", writeStatus=" + writeStatus + "]";
	}
	
	
}