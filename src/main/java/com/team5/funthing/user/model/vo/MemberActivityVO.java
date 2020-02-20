package com.team5.funthing.user.model.vo;

public class MemberActivityVO {

	
	private String email;
	private int projectboardno;
	private String likeCount;
	private String reservationCount;
	private String reportCount;
	
	private String projectLikeCount;
	private String projectReportCount;
	private String projectReservationCount;
	
	private String memberLikeCount;
	private String memberReportCount;
	private String memberReservationCount;
	
	



	@Override
	public String toString() {
		return "MemberActivityVO [email=" + email + ", projectboardno=" + projectboardno + ", likeCount=" + likeCount
				+ ", reservationCount=" + reservationCount + ", reportCount=" + reportCount + ", projectLikeCount="
				+ projectLikeCount + ", projectReportCount=" + projectReportCount + ", projectReservationCount="
				+ projectReservationCount + ", memberLikeCount=" + memberLikeCount + ", memberReportCount="
				+ memberReportCount + ", memberReservationCount=" + memberReservationCount + "]";
	}

	


	public String getMemberLikeCount() {
		return memberLikeCount;
	}




	public void setMemberLikeCount(String memberLikeCount) {
		this.memberLikeCount = memberLikeCount;
	}




	public String getMemberReportCount() {
		return memberReportCount;
	}




	public void setMemberReportCount(String memberReportCount) {
		this.memberReportCount = memberReportCount;
	}




	public String getMemberReservationCount() {
		return memberReservationCount;
	}




	public void setMemberReservationCount(String memberReservationCount) {
		this.memberReservationCount = memberReservationCount;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getProjectboardno() {
		return projectboardno;
	}




	public void setProjectboardno(int projectboardno) {
		this.projectboardno = projectboardno;
	}




	public String getLikeCount() {
		return likeCount;
	}




	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}




	public String getReservationCount() {
		return reservationCount;
	}




	public void setReservationCount(String reservationCount) {
		this.reservationCount = reservationCount;
	}




	public String getReportCount() {
		return reportCount;
	}




	public void setReportCount(String reportCount) {
		this.reportCount = reportCount;
	}




	public String getProjectLikeCount() {
		return projectLikeCount;
	}




	public void setProjectLikeCount(String projectLikeCount) {
		this.projectLikeCount = projectLikeCount;
	}




	public String getProjectReportCount() {
		return projectReportCount;
	}




	public void setProjectReportCount(String projectReportCount) {
		this.projectReportCount = projectReportCount;
	}




	public String getProjectReservationCount() {
		return projectReservationCount;
	}




	public void setProjectReservationCount(String projectReservationCount) {
		this.projectReservationCount = projectReservationCount;
	}
	
	
	

	

	
}
