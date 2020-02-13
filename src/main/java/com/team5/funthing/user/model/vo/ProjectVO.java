package com.team5.funthing.user.model.vo;

import java.util.Date;

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
	
//	프로젝트 기본설정
	private int projectNo;
	private String creator; // 창작자|업체명
	private String email;
	
//	프로젝트 설정
	private int goalMoney; // 펀딩 목표 금액
	private MultipartFile projectMainImage;
	private String Category;
	private String projectTitle;
	private String projectSubTitle;
	private MultipartFile projectMainImage;
	private String category;
	private Date startDate; // 펀딩 시작 날짜
	private Date endDate; // 마감 날짜
	private String projectKeyword; // 검색 시 필요한 키워드
	
//	스토리 작성
	private String projectStory; 
	private String projectDetail;
	private String projectCaution;
	private MultipartFile projectVideo; // 소개 컨텐츠 [추후 사진도 가능하게 변경]

	private String supporters; // 후원자
	private int fundingMoney; // 펀딩 진행중 모인 금액
	private char status = 'w'; // 심사 상태  'w'= 대기 'p' = 통과 'f' = 거부
	private char informationAgree = 'n'; // 정보동의
	

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
	public MultipartFile getProjectMainImage() {
		return projectMainImage;
	}
	public void setProjectMainImage(MultipartFile projectMainImage) {
		this.projectMainImage = projectMainImage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
				+ projectTitle + ", goalMoney=" + goalMoney + ", projectMainImage=" + projectMainImage + ", category="
				+ category + ", projectSubTitle=" + projectSubTitle + ", projectStory=" + projectStory
				+ ", projectDetail=" + projectDetail + ", projectCaution=" + projectCaution + ", projectVideo="
				+ projectVideo + ", supporters=" + supporters + ", fundingMoney=" + fundingMoney + ", status=" + status
				+ ", informationAgree=" + informationAgree + ", projectKeyword=" + projectKeyword + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
		
	
	
	
}
