package com.team5.funthing.user.model.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author bummit
 * 
 * 	Funthing Project 
 *  
 *
 */
public class ProjectVO {
	
//	프로젝트 기본설정 멤버
	private int projectNo = -1; 
	private String creator=""; 
	private String email="";
	
//	프로젝트 설정 멤버
	private int goalMoney; 
	private MultipartFile projectMainImage;
	private String projectTitle="";
	private String projectSubTitle="";
	private String category=""; 
	private Date startDate= new Date(); 
	private Date endDate = new Date(); 
	private List<String> projectKeyword; // null ok
	
//	프로젝트 소개 멤버
	private String projectStory=""; 
	private String projectSummary="";
	private String projectDetail="";
	private String projectCaution="";
	private MultipartFile projectVideo; // null ok

//	그 외 멤버
	private String supporters; 
	private int fundingMoney; 
	private char status = 'w'; 
	private char informationAgree = 'n'; 
	private char writeStatus = 'n';
	
	
	
	public String getProjectSummary() {
		return projectSummary;
	}
	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
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
	public MultipartFile getProjectMainImage() {
		return projectMainImage;
	}
	public void setProjectMainImage(MultipartFile projectMainImage) {
		this.projectMainImage = projectMainImage;
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
	public List<String> getProjectKeyword() {
		return projectKeyword;
	}
	public void setProjectKeyword(List<String> projectKeyword) {
		this.projectKeyword = projectKeyword;
	}
	public String getProjectStory() {
		return projectStory;
	}
	public void setProjectStory(String projectStory) {
		this.projectStory = projectStory;
	}
	public String getProjectDetail() {
		return projectDetail;
	}
	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}
	public String getProjectCaution() {
		return projectCaution;
	}
	public void setProjectCaution(String projectCaution) {
		this.projectCaution = projectCaution;
	}
	public MultipartFile getProjectVideo() {
		return projectVideo;
	}
	public void setProjectVideo(MultipartFile projectVideo) {
		this.projectVideo = projectVideo;
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
				+ goalMoney + ", projectMainImage=" + projectMainImage + ", projectTitle=" + projectTitle
				+ ", projectSubTitle=" + projectSubTitle + ", category=" + category + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", projectKeyword=" + projectKeyword + ", projectStory=" + projectStory
				+ ", projectDetail=" + projectDetail + ", projectCaution=" + projectCaution + ", projectVideo="
				+ projectVideo + ", supporters=" + supporters + ", fundingMoney=" + fundingMoney + ", status=" + status
				+ ", informationAgree=" + informationAgree + ", writeStatus=" + writeStatus + "]";
	}

	
	
}