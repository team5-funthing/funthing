package com.team5.funthing.user.model.vo;

public class AlarmVO {

	private int alarmNo;
	private String alarmType;
	private String detailAlarmType;
	private String receiveId;
	private String alarmMessage;
	private char readConfirm;
	private int projectNo;
	

	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getDetailAlarmType() {
		return detailAlarmType;
	}
	public void setDetailAlarmType(String detailAlarmType) {
		this.detailAlarmType = detailAlarmType;
	}
	public String getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}
	public String getAlarmMessage() {
		return alarmMessage;
	}
	public void setAlarmMessage(String alarmMessage) {
		this.alarmMessage = alarmMessage;
	}
	public char getReadConfirm() {
		return readConfirm;
	}
	public void setReadConfirm(char readConfirm) {
		this.readConfirm = readConfirm;
	}
	
	@Override
	public String toString() {
		return "AlarmVO [alarmNo=" + alarmNo + ", alarmType=" + alarmType + ", detailAlarmType=" + detailAlarmType
				+ ", receiveId=" + receiveId + ", alarmMessage=" + alarmMessage + ", readConfirm=" + readConfirm
				+ ", projectNo=" + projectNo + "]";
	}
	
}
