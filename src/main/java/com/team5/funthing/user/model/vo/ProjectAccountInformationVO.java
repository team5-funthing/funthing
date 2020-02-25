package com.team5.funthing.user.model.vo;

public class ProjectAccountInformationVO {
	
	private int projectno;
	private String projectBank;
	private String projectAccountName;
	private String projectAccount;
	private String bankBookImg;
	
	@Override
	public String toString() {
		return "ProjectAccountInformationVO [projectNo=" + projectno + ", projectBank=" + projectBank
				+ ", projectAccountName=" + projectAccountName + ", projectAccount=" + projectAccount + ", bankBookImg="
				+ bankBookImg + "]";
	}

	public int getProjectno() {
		return projectno;
	}

	public void setProjectno(int projectNo) {
		this.projectno = projectNo;
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
