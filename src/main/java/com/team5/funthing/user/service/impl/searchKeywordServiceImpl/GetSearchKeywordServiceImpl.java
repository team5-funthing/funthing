package com.team5.funthing.user.service.impl.searchKeywordServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.SearchKeywordDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.searchKeywordService.GetSearchKeywordService;

@Service
public class GetSearchKeywordServiceImpl implements GetSearchKeywordService {
	
	@Autowired
	private SearchKeywordDAO searchKeywordDAO;

	@Override
	public List<ProjectVO> getSearchKeyword(String searchKeyword) {
		return searchKeywordDAO.getSearchKeyword(searchKeyword);
	}

	
	
	

}
