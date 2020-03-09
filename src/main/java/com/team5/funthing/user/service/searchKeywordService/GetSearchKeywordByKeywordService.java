package com.team5.funthing.user.service.searchKeywordService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetSearchKeywordByKeywordService {
	
	public List<ProjectVO> getSearchKeywordByKeyword(String searchKeyword);
	public List<ProjectVO> getSearchKeywordByKeywordShap(String searchKeyword);

}
