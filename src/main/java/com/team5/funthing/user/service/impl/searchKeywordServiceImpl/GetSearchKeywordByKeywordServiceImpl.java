package com.team5.funthing.user.service.impl.searchKeywordServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.SearchKeywordDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.searchKeywordService.GetSearchKeywordByKeywordService;

@Service
public class GetSearchKeywordByKeywordServiceImpl implements GetSearchKeywordByKeywordService {
	
	@Autowired
	private SearchKeywordDAO searchKeywordDAO;

	
	@Override
	public List<ProjectVO> getSearchKeywordByKeyword(String searchKeyword) {
		// TODO Auto-generated method stub
		return searchKeywordDAO.getSearchKeywordByKeyword(searchKeyword);
	}


	@Override
	public List<ProjectVO> getSearchKeywordByKeywordShap(String searchKeyword) {
		// TODO Auto-generated method stub
		return searchKeywordDAO.getSearchKeywordByKeywordShap(searchKeyword);
	}

}
