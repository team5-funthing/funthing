package com.team5.funthing.user.model.vo;

import java.sql.Date;
import java.util.List;

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
	
	private Integer projectNo = -1; 
	private String creator = ""; 
	private String email = "";
	
	private int goalMoney; 
	private String projectMainImage = "";
	private String projectTitle = "";
	private String projectSubTitle = "";
	private String category=""; 
	private Date startDate;
	private Date endDate; 
	private String projectSummary="";
	private String projectCaution="";
	private String projectIntroduceVideo="";
	private String projectStory="";

	private List<ProjectIntroduceImageVO> projectIntroduceImage;

	private char writeStatus = 'n'; 
	private char status = 'n';
	private String statusReplyMessage = "";
	private char funding = 'n'; 

	private int fundingMoney; 
	private String supporters; 
	private char informationAgree = 'n'; 

	private int percent;
	
	private MemberActivityVO memberActivity;
	private SearchKeywordVO searchKeyword;
	private List<RewardVO> reward;
	
	
	
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



	public List<ProjectIntroduceImageVO> getProjectIntroduceImage() {
		return projectIntroduceImage;
	}



	public void setProjectIntroduceImage(List<ProjectIntroduceImageVO> projectIntroduceImage) {
		this.projectIntroduceImage = projectIntroduceImage;
	}



	public char getWriteStatus() {
		return writeStatus;
	}



	public void setWriteStatus(char writeStatus) {
		this.writeStatus = writeStatus;
	}



	public char getStatus() {
		return status;
	}



	public void setStatus(char status) {
		this.status = status;
	}



	public String getStatusReplyMessage() {
		return statusReplyMessage;
	}



	public void setStatusReplyMessage(String statusReplyMessage) {
		this.statusReplyMessage = statusReplyMessage;
	}



	public char getFunding() {
		return funding;
	}



	public void setFunding(char funding) {
		this.funding = funding;
	}



	public int getFundingMoney() {
		return fundingMoney;
	}



	public void setFundingMoney(int fundingMoney) {
		this.fundingMoney = fundingMoney;
	}



	public String getSupporters() {
		return supporters;
	}



	public void setSupporters(String supporters) {
		this.supporters = supporters;
	}



	public char getInformationAgree() {
		return informationAgree;
	}



	public void setInformationAgree(char informationAgree) {
		this.informationAgree = informationAgree;
	}



	public int getPercent() {
		return percent;
	}



	public void setPercent(int percent) {
		this.percent = percent;
	}



	public MemberActivityVO getMemberActivity() {
		return memberActivity;
	}



	public void setMemberActivity(MemberActivityVO memberActivity) {
		this.memberActivity = memberActivity;
	}



	public SearchKeywordVO getSearchKeyword() {
		return searchKeyword;
	}



	public void setSearchKeyword(SearchKeywordVO searchKeyword) {
		this.searchKeyword = searchKeyword;
	}



	public List<RewardVO> getReward() {
		return reward;
	}



	public void setReward(List<RewardVO> reward) {
		this.reward = reward;
	}



	@Override
	public String toString() {
		return "ProjectVO [projectNo=" + projectNo + ", creator=" + creator + ", email=" + email + ", goalMoney="
				+ goalMoney + ", projectMainImage=" + projectMainImage + ", projectTitle=" + projectTitle
				+ ", projectSubTitle=" + projectSubTitle + ", category=" + category + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", projectSummary=" + projectSummary + ", projectCaution=" + projectCaution
				+ ", projectIntroduceVideo=" + projectIntroduceVideo + ", projectStory=" + projectStory
				+ ", projectIntroduceImage=" + projectIntroduceImage + ", writeStatus=" + writeStatus + ", status="
				+ status + ", statusReplyMessage=" + statusReplyMessage + ", funding=" + funding + ", fundingMoney="
				+ fundingMoney + ", supporters=" + supporters + ", informationAgree=" + informationAgree + ", percent="
				+ percent + ", memberActivity=" + memberActivity + ", searchKeyword=" + searchKeyword + ", reward="
				+ reward + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

	
	

}