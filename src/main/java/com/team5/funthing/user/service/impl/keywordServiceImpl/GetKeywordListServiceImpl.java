package com.team5.funthing.user.service.impl.keywordServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.KeywordDAO;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.service.keywordService.GetKeywordListService;

@Service
public class GetKeywordListServiceImpl implements GetKeywordListService {
	
	@Autowired
	private KeywordDAO keywordDAO;

	@Override
	public List<KeywordVO> getKeywordList(){
		return keywordDAO.getKeywordList();
	}

	
	
}
