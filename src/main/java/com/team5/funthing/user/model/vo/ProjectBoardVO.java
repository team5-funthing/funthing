package com.team5.funthing.user.model.vo;

import java.sql.Date;

public class ProjectBoardVO {

	private int projectBoardNo = -1;
	private String email;
	private int projectNo;
	private String projectBoardContents;
	private Date projectBoardDate;
	private int step;
	private int depth;
	private int ref;
	
	private MemberVO Member;

	public int getProjectBoardNo() {
		return projectBoardNo;
	}

	public void setProjectBoardNo(int projectBoardNo) {
		this.projectBoardNo = projectBoardNo;
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

	public String getProjectBoardContents() {
		return projectBoardContents;
	}

	public void setProjectBoardContents(String projectBoardContents) {
		this.projectBoardContents = projectBoardContents;
	}

	public Date getProjectBoardDate() {
		return projectBoardDate;
	}

	public void setProjectBoardDate(Date projectBoardDate) {
		this.projectBoardDate = projectBoardDate;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public MemberVO getMember() {
		return Member;
	}

	public void setMember(MemberVO member) {
		Member = member;
	}

	@Override
	public String toString() {
		return "ProjectBoardVO [projectBoardNo=" + projectBoardNo + ", email=" + email + ", projectNo=" + projectNo
				+ ", projectBoardContents=" + projectBoardContents + ", projectBoardDate=" + projectBoardDate
				+ ", step=" + step + ", depth=" + depth + ", ref=" + ref + ", Member=" + Member + "]";
	}
	
	
	
}
