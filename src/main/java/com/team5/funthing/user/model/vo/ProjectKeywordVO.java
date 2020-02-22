package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ProjectKeywordVO {
	
	private Integer projectNo;
	private String keyword;
	
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "ProjectKeywordVO [projectNo=" + projectNo + ", keyword=" + keyword + "]";
	}

	
	
	
}
