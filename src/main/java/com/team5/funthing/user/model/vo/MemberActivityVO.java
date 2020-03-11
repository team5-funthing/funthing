package com.team5.funthing.user.model.vo;

public class MemberActivityVO {

	
	private String email;
	private int projectNo;
	
	private char likeCount;					//해당 프로젝트에 해당 아이디가 누른 좋아요 
	private char reservationCount;
	private char reportCount;
	
	//프로젝트용
	private int projectLikeCount;			//프로젝트 당 좋아요
	private int projectReportCount;			//프로젝트 당 신고수
	private int projectReservationCount;		//프로젝트 당 결제예약수
	
	//마이페이지용
	private int memberLikeCount;				//해당 회원이 누른 모든 좋아요 갯수
	private int memberReportCount;			//해당 회원이 누른 모든 신고 갯수
	private int memberReservationCount;		//해당 회원이 누른 모든 예약 갯수
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
	public char getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(char likeCount) {
		this.likeCount = likeCount;
	}
	public char getReservationCount() {
		return reservationCount;
	}
	public void setReservationCount(char reservationCount) {
		this.reservationCount = reservationCount;
	}
	public char getReportCount() {
		return reportCount;
	}
	public void setReportCount(char reportCount) {
		this.reportCount = reportCount;
	}
	public int getProjectLikeCount() {
		return projectLikeCount;
	}
	public void setProjectLikeCount(int projectLikeCount) {
		this.projectLikeCount = projectLikeCount;
	}
	public int getProjectReportCount() {
		return projectReportCount;
	}
	public void setProjectReportCount(int projectReportCount) {
		this.projectReportCount = projectReportCount;
	}
	public int getProjectReservationCount() {
		return projectReservationCount;
	}
	public void setProjectReservationCount(int projectReservationCount) {
		this.projectReservationCount = projectReservationCount;
	}
	public int getMemberLikeCount() {
		return memberLikeCount;
	}
	public void setMemberLikeCount(int memberLikeCount) {
		this.memberLikeCount = memberLikeCount;
	}
	public int getMemberReportCount() {
		return memberReportCount;
	}
	public void setMemberReportCount(int memberReportCount) {
		this.memberReportCount = memberReportCount;
	}
	public int getMemberReservationCount() {
		return memberReservationCount;
	}
	public void setMemberReservationCount(int memberReservationCount) {
		this.memberReservationCount = memberReservationCount;
	}
	
	@Override
	public String toString() {
		return "MemberActivityVO [email=" + email + ", projectNo=" + projectNo + ", likeCount=" + likeCount
				+ ", reservationCount=" + reservationCount + ", reportCount=" + reportCount + ", projectLikeCount="
				+ projectLikeCount + ", projectReportCount=" + projectReportCount + ", projectReservationCount="
				+ projectReservationCount + ", memberLikeCount=" + memberLikeCount + ", memberReportCount="
				+ memberReportCount + ", memberReservationCount=" + memberReservationCount + "]";
	}
	
}
