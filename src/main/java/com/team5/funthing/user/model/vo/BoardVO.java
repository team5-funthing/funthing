package com.team5.funthing.user.model.vo;

public class BoardVO {

	private int noticeCountTotal;		//��ü �� �� 
	private int currentPage;			//���� ������ ��ȣ
	private int noticeCountTotalPage;	//��ü �������� �� = ��ü �� �� / ���������� ������ ���� �� + (1 �Ǵ� 0)
	private int noticeStartRow;			//�ش� �������� ������ ù��° ��
	private int noticeEndRow;			//�ش� �������� ������ ������ ��
	private int startPage;
	private int lastPage;
		
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
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
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNoticeCountTotalPage() {
		return noticeCountTotalPage;
	}
	public void setNoticeCountTotalPage(int noticeCountTotalPage) {
		this.noticeCountTotalPage = noticeCountTotalPage;
	}
	@Override
	public String toString() {
		return "BoardVO [noticeCountTotal=" + noticeCountTotal + ", currentPage=" + currentPage
				+ ", noticeCountTotalPage=" + noticeCountTotalPage + ", noticeStartRow=" + noticeStartRow
				+ ", noticeEndRow=" + noticeEndRow + ", startPage=" + startPage + ", lastPage=" + lastPage + "]";
	}
	
	
	
}
