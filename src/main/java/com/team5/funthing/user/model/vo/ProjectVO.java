package com.team5.funthing.user.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;

/**
 * 
 * @author bummit
 * 
 * 	Funthing Project 
 * 
 */

@Component
public class ProjectVO {
	
//	占쏙옙占쏙옙占쏙옙트 占썩본占쏙옙占쏙옙 占쏙옙占
	private Integer projectNo = -1; 
	private String creator = ""; 
	private String email = "";
	
//	占쏙옙占쏙옙占쏙옙트 占쏙옙占쏙옙 占쏙옙占
	private int goalMoney; 
	private String projectMainImage = "";
	private String projectTitle = "";
	private String projectSubTitle = "";
	private String category=""; 
	private Date startDate;
	private Date endDate; 
	
//	占쏙옙占쏙옙占쏙옙트 占쌀곤옙 占쏙옙占
	private String projectSummary="";
	private String projectCaution="";
//	private List<String> projectIntroduceImage;
	private String projectIntroduceVideo="";
	private String projectStory="";



//  기타 멤버
	private char writeStatus = 'n'; // 작성 완료된 
	private char status = 'n'; // 상태 여부 - n: 심사 미제출, w : wating[대기중], p : pass[심사 통과], f : fail[실패], m : modify[수정 요구]
	private String statusReplyMessage = "";
	private char funding = 'n'; // 펀딩진행중 여부

//  sql문에 적용 안된 멤버

	private int fundingMoney; 
	private String supporters; 
	private char informationAgree = 'n'; 
	
//	sql�� ��ν� �ʿ��� VO
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
	public String getStatusReplyMessage() {
		return statusReplyMessage;
	}
	public void setStatusReplyMessage(String statusReplyMessage) {
		this.statusReplyMessage = statusReplyMessage;
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