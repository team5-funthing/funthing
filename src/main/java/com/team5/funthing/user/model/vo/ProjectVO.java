package com.team5.funthing.user.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 
 * @author bummit
 * 
 * 	Funthing Project 
 * 
 */

@Component
public class ProjectVO {
	
//	������Ʈ �⺻���� ���
	private Integer projectNo = -1; 
	private String creator = ""; 
	private String email = "";
	
//	������Ʈ ���� ���
	private int goalMoney; 
	private String projectMainImage = "";
	private String projectTitle = "";
	private String projectSubTitle = "";
	private String category=""; 
	private Date startDate;
	private Date endDate; 
	
//	������Ʈ �Ұ� ���
	private String projectSummary="";
	private String projectCaution="";
//	private List<String> projectIntroduceImage;
	private String projectIntroduceVideo="";
	private String projectStory="";


//  ��Ÿ ���
	private char writeStatus = 'n'; // �ۼ� �Ϸ�� 
	private char status = 'n'; // ���� ���� - n: �ɻ� ������, w : wating[�����], f : fail[����], m : modify[���� �䱸]
	private char funding = 'n'; // �ݵ������� ����
	
//  sql���� ���� �ȵ� ���
	private int fundingMoney; 
	private String supporters; 
	private char informationAgree = 'n'; 
	
//	sql�� ���ν� �ʿ��� VO
	private MemberActivityVO memberActivity;
	
	
	
	
	
	public MemberActivityVO getMemberActivity() {
		return memberActivity;
	}
	public void setMemberActivity(MemberActivityVO memberActivity) {
		this.memberActivity = memberActivity;
	}
	public char getFunding() {
		return funding;
	}
	public void setFunding(char funding) {
		this.funding = funding;
	}
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
	public String getProjectIntroduceVideo() {
		return projectIntroduceVideo;
	}
	public void setProjectIntroduceVideo(String projectIntroduceVideo) {
		this.projectIntroduceVideo = projectIntroduceVideo;
	}
	public String getProjectStory() {
		return projectStory;
	}
	public void setProjectStory(String projectStory) {
		this.projectStory = projectStory;
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
				+ ", endDate=" + endDate + ", projectSummary=" + projectSummary + ", projectCaution=" + projectCaution
				+ ", projectIntroduceVideo=" + projectIntroduceVideo + ", projectStory=" + projectStory
				+ ", writeStatus=" + writeStatus + ", status=" + status + ", funding=" + funding + ", fundingMoney="
				+ fundingMoney + ", supporters=" + supporters + ", informationAgree=" + informationAgree
				+ ", memberActivity=" + memberActivity + "]";
	}

	
	
	
	
}