package com.team5.funthing.user.service.searchKeywordService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetClickKeywordListService {
	
	public List<ProjectVO> getClickKeywordList(String keyword);

}
