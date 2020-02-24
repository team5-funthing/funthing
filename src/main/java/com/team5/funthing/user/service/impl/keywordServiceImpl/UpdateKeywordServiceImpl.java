package com.team5.funthing.user.service.impl.keywordServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.KeywordDAO;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.service.keywordService.UpdateKeywordService;

@Service
public class UpdateKeywordServiceImpl implements UpdateKeywordService {

	@Autowired
	private KeywordDAO keywordDAO;

	@Override
	public void updateKeyword(KeywordVO vo) {
		
	}
	
}
