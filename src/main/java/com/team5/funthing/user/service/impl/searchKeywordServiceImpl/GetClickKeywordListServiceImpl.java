package com.team5.funthing.user.service.impl.searchKeywordServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.SearchKeywordDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.searchKeywordService.GetClickKeywordListService;

@Service
public class GetClickKeywordListServiceImpl implements GetClickKeywordListService {
	
	@Autowired
	private SearchKeywordDAO searchKeywordDAO;
	
	@Override
	public List<ProjectVO> getClickKeywordList(String keyword) {
		return searchKeywordDAO.getClickKeywordList(keyword);
	}

}
