package com.team5.funthing.user.service.impl.searchKeywordServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.SearchKeywordDAO;
import com.team5.funthing.user.service.searchKeywordService.UpdateKeywordCountService;

@Service
public class UpdateKeywordCountServiceImpl implements UpdateKeywordCountService {
	
	@Autowired
	private SearchKeywordDAO searchKeywordDAO;
	
	@Override
	public void updateKeywordCount(String searchKeyword) {
		searchKeywordDAO.updateKeywordCount(searchKeyword);

	}

	@Override
	public void updateKeywordCountShap(String searchKeyword) {
		searchKeywordDAO.updateKeywordCountShap(searchKeyword);
		
	}

}
