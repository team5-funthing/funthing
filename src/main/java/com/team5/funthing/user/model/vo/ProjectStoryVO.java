package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ProjectStoryVO {
	
	
	private int projectStoryImageNo = -1;
	private int projectNo = -1;
	private String projectStory;
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
	public String getProjectStory() {
		return projectStory;
	}
	public void setProjectStory(String projectStory) {
		this.projectStory = projectStory;
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
		return "ProjectStoryVO [projectStoryImageNo=" + projectStoryImageNo + ", projectNo=" + projectNo
				+ ", projectStory=" + projectStory + ", projectStoryImagePath=" + projectStoryImagePath
				+ ", projectStoryVideoPath=" + projectStoryVideoPath + "]";
	}
	
	
	
}