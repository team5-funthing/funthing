package com.team5.funthing.user.model.vo;

public class BoardVO {

	private int noticeCountTotal;		//��ü �� �� 
	private int noticeCountPerPage;		//���������� ������ ���� ��
	private int noticeCountTotalPage;	//��ü �������� �� = ��ü �� �� / ���������� ������ ���� �� + (1 �Ǵ� 0)
	private int noticeStartRow;			//�ش� �������� ������ ù��° ��
	private int noticeEndRow;			//�ش� �������� ������ ������ ��
	
	
	
	public int getNoticeStartRow() {
		return noticeStartRow;
	}
	public void setNoticeStartRow(int noticeStartRow) {
		this.noticeStartRow = noticeStartRow;
	}
	public int getNoticeEndRow() {
		return noticeEndRow;
	}
	public void setNoticeEndRow(int noticeEndRow) {
		this.noticeEndRow = noticeEndRow;
	}
	public int getNoticeCountTotal() {
		return noticeCountTotal;
	}
	public void setNoticeCountTotal(int noticeCountTotal) {
		this.noticeCountTotal = noticeCountTotal;
	}
	public int getNoticeCountPerPage() {
		return noticeCountPerPage;
	}
	public void setNoticeCountPerPage(int noticeCountPerPage) {
		this.noticeCountPerPage = noticeCountPerPage;
	}
	public int getNoticeCountTotalPage() {
		return noticeCountTotalPage;
	}
	public void setNoticeCountTotalPage(int noticeCountTotalPage) {
		this.noticeCountTotalPage = noticeCountTotalPage;
	}
	@Override
	public String toString() {
		return "BoardVO [noticeCountTotal=" + noticeCountTotal + ", noticeCountPerPage=" + noticeCountPerPage
				+ ", noticeCountTotalPage=" + noticeCountTotalPage + ", noticeStartRow=" + noticeStartRow
				+ ", noticeEndRow=" + noticeEndRow + "]";
	}
	
	
}
