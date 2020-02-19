package com.team5.funthing.user.model.vo;

public class ProjectAccountInformationVO {
	
	private int projectNo;
	private String projectBank;
	private String projectAccountName;
	private String projectAccount;
	private String bankBookImg;
	
	@Override
	public String toString() {
		return "ProjectAccountInformationVO [projectNo=" + projectNo + ", projectBank=" + projectBank
				+ ", projectAccountName=" + projectAccountName + ", projectAccount=" + projectAccount + ", bankBookImg="
				+ bankBookImg + "]";
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectBank() {
		return projectBank;
	}

	public void setProjectBank(String projectBank) {
		this.projectBank = projectBank;
	}

	public String getProjectAccountName() {
		return projectAccountName;
	}

	public void setProjectAccountName(String projectAccountName) {
		this.projectAccountName = projectAccountName;
	}

	public String getProjectAccount() {
		return projectAccount;
	}

	public void setProjectAccount(String projectAccount) {
		this.projectAccount = projectAccount;
	}

	public String getBankBookImg() {
		return bankBookImg;
	}

	public void setBankBookImg(String bankBookImg) {
		this.bankBookImg = bankBookImg;
	}
	
	
}
