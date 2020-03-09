package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;


@Component
public class KeywordVO {

	private Integer keywordNo = -1; //pk
	private String keyword;
	private int keywordCount;
	public Integer getKeywordNo() {
		return keywordNo;
	}
	public void setKeywordNo(Integer keywordNo) {
		this.keywordNo = keywordNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getKeywordCount() {
		return keywordCount;
	}
	public void setKeywordCount(int keywordCount) {
		this.keywordCount = keywordCount;
	}
	@Override
	public String toString() {
		return "KeywordVO [keywordNo=" + keywordNo + ", keyword=" + keyword + ", keywordCount=" + keywordCount + "]";
	}

	

	
	
	
	
}
