package com.team5.funthing.user.model.vo;

public class MemberActivityVO {

	
	private String email;
	private int projectNo;
	
	private char likeCount;					//�ش� ������Ʈ�� �ش� ���̵� ���� ���ƿ� 
	private char reservationCount;
	private char reportCount;
	
	//������Ʈ��
	private int projectLikeCount;			//������Ʈ �� ���ƿ�
	private int projectReportCount;			//������Ʈ �� �Ű��
	private int projectReservationCount;		//������Ʈ �� ���������
	
	//������������
	private int memberLikeCount;				//�ش� ȸ���� ���� ��� ���ƿ� ����
	private int memberReportCount;			//�ش� ȸ���� ���� ��� �Ű� ����
	private int memberReservationCount;		//�ش� ȸ���� ���� ��� ���� ����
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
