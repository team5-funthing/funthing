package com.team5.funthing.user.model.vo;

import java.sql.Date;

public class ReportVO {
	
	private int reportNo;
	private String email;
	private int projectNo;
	private String reason;
	private String reasonSelect;
	private Date reportDate;
	
	private ProjectVO project;

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReasonSelect() {
		return reasonSelect;
	}

	public void setReasonSelect(String reasonSelect) {
		this.reasonSelect = reasonSelect;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public ProjectVO getProject() {
		return project;
	}

	public void setProject(ProjectVO project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ReportVO [reportNo=" + reportNo + ", email=" + email + ", projectNo=" + projectNo + ", reason=" + reason
				+ ", reasonSelect=" + reasonSelect + ", reportDate=" + reportDate + ", project=" + project + "]";
	}
	
}
