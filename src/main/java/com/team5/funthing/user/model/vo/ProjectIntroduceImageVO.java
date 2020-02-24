package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ProjectIntroduceImageVO {
	
	public int projectIntroduceImageNo;
	public int projectNo;
	public String projectIntroduceImage;
	
	public int getProjectIntroduceImageNo() {
		return projectIntroduceImageNo;
	}
	public void setProjectIntroduceImageNo(int projectIntroduceImageNo) {
		this.projectIntroduceImageNo = projectIntroduceImageNo;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectIntroduceImage() {
		return projectIntroduceImage;
	}
	public void setProjectIntroduceImage(String projectIntroduceImage) {
		this.projectIntroduceImage = projectIntroduceImage;
	}
	@Override
	public String toString() {
		return "projectIntroduceImageVO [projectIntroduceImageNo=" + projectIntroduceImageNo + ", projectNo="
				+ projectNo + ", projectIntroduceImage=" + projectIntroduceImage + "]";
	}
	
	
	
	
	
	

}
