package com.team5.funthing.user.model.vo;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class KeywordVO {

	private Integer keywordNo = -1; //pk
	private String keyword;
	
	public int getKeywordNo() {
		return keywordNo;
	}
	public void setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "KeywordVO [keywordNo=" + keywordNo + ", keyword=" + keyword + "]";
	}
	

	
	
	
	
}
