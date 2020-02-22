package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ProjectStoryVO {
	
	
	private int projectStoryImageNo = -1;
	private int projectNo = -1;
	private String projectStoryImagePath;
	private String projectStoryVideoPath;
	public int getProjectStoryImageNo() {
		return projectStoryImageNo;
	}
	public void setProjectStoryImageNo(int projectStoryImageNo) {
		this.projectStoryImageNo = projectStoryImageNo;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectStoryImagePath() {
		return projectStoryImagePath;
	}
	public void setProjectStoryImagePath(String projectStoryImagePath) {
		this.projectStoryImagePath = projectStoryImagePath;
	}
	public String getProjectStoryVideoPath() {
		return projectStoryVideoPath;
	}
	public void setProjectStoryVideoPath(String projectStoryVideoPath) {
		this.projectStoryVideoPath = projectStoryVideoPath;
	}
	@Override
	public String toString() {
		return "ProjectIntroduceVO [projectStoryImageNo=" + projectStoryImageNo + ", projectNo=" + projectNo
				+ ", projectStoryImagePath=" + projectStoryImagePath + ", projectStoryVideoPath="
				+ projectStoryVideoPath + "]";
	}

	
	
	
	
}
