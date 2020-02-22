package com.team5.funthing.user.model.vo;

import java.sql.Date;

public class ProjectBoardVO {
	
	
	private int projectboardno;
	private String email;
	private Integer projectno;
	private String position;
	private String projectboardcontents;
	private Date projectboarddate;
	private int step;
	private int depth;
	private int ref;
	
	private MemberVO Member;
	
	
	public MemberVO getMember() {
		return Member;
	}
	public void setMember(MemberVO member) {
		Member = member;
	}
	public int getProjectboardno() {
		return projectboardno;
	}
	public void setProjectboardno(int projectboardno) {
		this.projectboardno = projectboardno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProjectno() {
		return projectno;
	}
	public void setProjectno(int projectno) {
		this.projectno = projectno;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getProjectboardcontents() {
		return projectboardcontents;
	}
	public void setProjectboardcontents(String projectboardcontents) {
		this.projectboardcontents = projectboardcontents;
	}
	public Date getProjectboarddate() {
		return projectboarddate;
	}
	public void setProjectboarddate(Date projectboarddate) {
		this.projectboarddate = projectboarddate;
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
	@Override
	public String toString() {
		return "ProjectBoardVO [projectboardno=" + projectboardno + ", email=" + email + ", projectno=" + projectno
				+ ", position=" + position + ", projectboardcontents=" + projectboardcontents + ", projectboarddate="
				+ projectboarddate + ", step=" + step + ", depth=" + depth + ", ref=" + ref + ", Member=" + Member
				+ "]";
	}
	
	
	
	

}
