package com.team5.funthing.user.model.vo;

import java.io.File;
import java.util.Date;

/**
 * 
 * @author bummit
 * 
 * 	Funthing Project 
 *  
 *
 */

public class ProjectVO {
	
	private int projectNo;
	private String creator; // 창작자
	private String email;
	private String projectTitle; 
	private int goalMoney; // 펀딩 목표 금액
	private File projectMainImage;
	private String Category;
	private String projectSubTitle;
	private String projectStory; 
	private String projectDetail;
	private String projectCaution;
	private String projectVideo; 
	private String supporters; // 후원자
	private int fundingMoney; // 펀딩 진행중 모인 금액
	private String status = "작성중"; // 심사 상태 
	private char informationAgree = 'n'; // 정보동의
	private String projectKeyword; // 검색 시 필요한 키워드
	private Date startDate; // 펀딩 시작 날짜
	private Date endDate; // 마감 날짜
	
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
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public int getGoalMoney() {
		return goalMoney;
	}
	public void setGoalMoney(int goalMoney) {
		this.goalMoney = goalMoney;
	}
	public Fil getProjectMainImage() {
		return projectMainImage;
	}
	public void setProjectMainImage(String projectMainImage) {
		this.projectMainImage = projectMainImage;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getProjectSubTitle() {
		return projectSubTitle;
	}
	public void setProjectSubTitle(String projectSubTitle) {
		this.projectSubTitle = projectSubTitle;
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
	public String getProjectVideo() {
		return projectVideo;
	}
	public void setProjectVideo(String projectVideo) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public char getInformationAgree() {
		return informationAgree;
	}
	public void setInformationAgree(char informationAgree) {
		this.informationAgree = informationAgree;
	}
	public String getProjectKeyword() {
		return projectKeyword;
	}
	public void setProjectKeyword(String projectKeyword) {
		this.projectKeyword = projectKeyword;
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
	
	@Override
	public String toString() {
		return "ProjectVO [projectNo=" + projectNo + ", creator=" + creator + ", email=" + email + ", projectTitle="
				+ projectTitle + ", goalMoney=" + goalMoney + ", projectMainImage=" + projectMainImage + ", Category="
				+ Category + ", projectSubTitle=" + projectSubTitle + ", projectStory=" + projectStory
				+ ", projectDetail=" + projectDetail + ", projectCaution=" + projectCaution + ", projectVideo="
				+ projectVideo + ", supporters=" + supporters + ", fundingMoney=" + fundingMoney + ", status=" + status
				+ ", informationAgree=" + informationAgree + ", projectKeyword=" + projectKeyword + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	
}
