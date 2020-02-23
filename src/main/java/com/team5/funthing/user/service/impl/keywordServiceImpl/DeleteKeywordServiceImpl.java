package com.team5.funthing.user.service.impl.keywordServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.KeywordDAO;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.service.keywordService.DeleteKeywordService;

@Service
public class DeleteKeywordServiceImpl implements DeleteKeywordService {

	@Autowired
	private KeywordDAO keywordDAO;

	@Override
	public void deleteKeyword(KeywordVO vo) {
	}
		
}
