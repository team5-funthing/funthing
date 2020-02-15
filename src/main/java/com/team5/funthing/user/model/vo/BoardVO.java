package com.team5.funthing.user.model.vo;

public class BoardVO {

	private int noticeCountTotal;		//전체 글 수 
	private int noticeCountPerPage;		//한페이지에 보여질 글의 수
	private int noticeCountTotalPage;	//전체 페이지의 수 = 전체 글 수 / 한페이지에 보여질 글의 수 + (1 또는 0)
	private int noticeStartRow;			//해당 페이지에 보여질 첫번째 글
	private int noticeEndRow;			//해당 페이지에 보여질 마지막 글
	
	
	
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
