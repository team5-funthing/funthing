package com.team5.funthing.user.service.impl.keywordServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.KeywordDAO;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.service.keywordService.GetKeywordService;

@Service
public class GetKeywordServiceImpl implements GetKeywordService {

	@Autowired
	private KeywordDAO keywordDAO;

	@Override
	public KeywordVO getKeyword(KeywordVO vo) {
		return null;
	}
}
