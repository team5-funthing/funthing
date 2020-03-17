package com.team5.funthing.admin.statistics.vo;


public class ProjectRegStatisticsVO {
	
	private String statisticsDate;
	private int projectRegCount;
	
	public String getStatisticsDate() {
		return statisticsDate;
	}
	public void setStatisticsDate(String statisticsDate) {
		this.statisticsDate = statisticsDate;
	}
	public int getProjectRegCount() {
		return projectRegCount;
	}
	public void setProjectRegCount(int projectRegCount) {
		this.projectRegCount = projectRegCount;
	}
	
	@Override
	public String toString() {
		return "ProjectRegStatisticsVO [statisticsDate=" + statisticsDate + ", projectRegCount=" + projectRegCount
				+ "]";
	}

	
	
	
}
