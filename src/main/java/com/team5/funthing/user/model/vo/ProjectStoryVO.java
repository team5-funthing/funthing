package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ProjectStoryVO {
	
	
	private int projectStoryImageNo = -1;
	private int projectNo = -1;
	private String projectStory;
	private String projectStoryImage;
	private String projectStoryVideo;
	
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
	public String getProjectStoryImage() {
		return projectStoryImage;
	}
	public void setProjectStoryImage(String projectStoryImage) {
		this.projectStoryImage = projectStoryImage;
	}
	public String getProjectStoryVideo() {
		return projectStoryVideo;
	}
	public void setProjectStoryVideo(String projectStoryVideo) {
		this.projectStoryVideo = projectStoryVideo;
	}
	@Override
	public String toString() {
		return "ProjectStoryVO [projectStoryImageNo=" + projectStoryImageNo + ", projectNo=" + projectNo
				+ ", projectStory=" + projectStory + ", projectStoryImage=" + projectStoryImage + ", projectStoryVideo="
				+ projectStoryVideo + "]";
	}
	
	
	
	
	
}