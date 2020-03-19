package com.team5.funthing.admin.statistics.vo;

import org.springframework.stereotype.Component;

@Component
public class ProjectRegCategryStatisticsVO {
	
	private int rnum;
	private String category;
	private int projectRegCount;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProjectRegCount() {
		return projectRegCount;
	}
	public void setProjectRegCount(int projectRegCount) {
		this.projectRegCount = projectRegCount;
	}
	@Override
	public String toString() {
		return "ProjectRegCategryStatisticsVO [rnum=" + rnum + ", category=" + category + ", projectRegCount="
				+ projectRegCount + "]";
	}

	
	
	

}
