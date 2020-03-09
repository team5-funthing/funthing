package com.team5.funthing.user.model.vo;

public class SearchKeywordVO {
	
	private String searchKeyword;
	private int count;
	
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

	@Override
	public String toString() {
		return "SearchKeywordVO [searchKeyword=" + searchKeyword + ", count=" + count + "]";
	}
	
	
	
	
	

	

}
