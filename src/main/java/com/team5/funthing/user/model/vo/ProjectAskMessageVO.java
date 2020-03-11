package com.team5.funthing.user.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ProjectAskMessageVO {
	
	private int projectAskNo;
	private String email;
	private String creator;
	private String projectAskContentsTitle;
	private String projectAskContents;
	private String projectAskReplyContentsTitle;
	private String projectAskReplyContents;
	private String projectAskReplyStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date projectAskDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date projectAskReplyDate;
	private int projectAskRef;
	private int projectAskStep;
	private int projectNo;
	
//	조인시 필요한 VO
	private ProjectVO project;
	
	
	
	
	public ProjectVO getProject() {
		return project;
	}
	public void setProject(ProjectVO project) {
		this.project = project;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectAskReplyContentsTitle() {
		return projectAskReplyContentsTitle;
	}
	public void setProjectAskReplyContentsTitle(String projectAskReplyContentsTitle) {
		this.projectAskReplyContentsTitle = projectAskReplyContentsTitle;
	}
	public Date getProjectAskDate() {
		return projectAskDate;
	}
	public void setProjectAskDate(Date projectAskDate) {
		this.projectAskDate = projectAskDate;
	}
	public Date getProjectAskReplyDate() {
		return projectAskReplyDate;
	}
	public void setProjectAskReplyDate(Date projectAskReplyDate) {
		this.projectAskReplyDate = projectAskReplyDate;
	}
	public String getProjectAskContentsTitle() {
		return projectAskContentsTitle;
	}
	public void setProjectAskContentsTitle(String projectAskContentsTitle) {
		this.projectAskContentsTitle = projectAskContentsTitle;
	}
	public int getProjectAskNo() {
		return projectAskNo;
	}
	public void setProjectAskNo(int projectAskNo) {
		this.projectAskNo = projectAskNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getProjectAskContents() {
		return projectAskContents;
	}
	public void setProjectAskContents(String projectAskContents) {
		this.projectAskContents = projectAskContents;
	}
	public String getProjectAskReplyContents() {
		return projectAskReplyContents;
	}
	public void setProjectAskReplyContents(String projectAskReplyContents) {
		this.projectAskReplyContents = projectAskReplyContents;
	}
	public String getProjectAskReplyStatus() {
		return projectAskReplyStatus;
	}
	public void setProjectAskReplyStatus(String projectAskReplyStatus) {
		this.projectAskReplyStatus = projectAskReplyStatus;
	}
	public int getProjectAskRef() {
		return projectAskRef;
	}
	public void setProjectAskRef(int projectAskRef) {
		this.projectAskRef = projectAskRef;
	}
	public int getProjectAskStep() {
		return projectAskStep;
	}
	public void setProjectAskStep(int projectAskStep) {
		this.projectAskStep = projectAskStep;
	}
	@Override
	public String toString() {
		return "ProjectAskMessageVO [projectAskNo=" + projectAskNo + ", email=" + email + ", creator=" + creator
				+ ", projectAskContentsTitle=" + projectAskContentsTitle + ", projectAskContents=" + projectAskContents
				+ ", projectAskReplyContentsTitle=" + projectAskReplyContentsTitle + ", projectAskReplyContents="
				+ projectAskReplyContents + ", projectAskReplyStatus=" + projectAskReplyStatus + ", projectAskDate="
				+ projectAskDate + ", projectAskReplyDate=" + projectAskReplyDate + ", projectAskRef=" + projectAskRef
				+ ", projectAskStep=" + projectAskStep + ", projectNo=" + projectNo + ", project=" + project + "]";
	}

	

	
	
	

}
