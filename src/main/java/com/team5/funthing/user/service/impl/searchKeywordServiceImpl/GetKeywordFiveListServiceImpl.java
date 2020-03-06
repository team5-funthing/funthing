package com.team5.funthing.user.service.impl.searchKeywordServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.SearchKeywordDAO;
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.service.searchKeywordService.GetKeywordFiveListService;

@Service
public class GetKeywordFiveListServiceImpl implements GetKeywordFiveListService {
	
	@Autowired
	private SearchKeywordDAO searchKeywordDAO;
	
	@Override
	public List<KeywordVO> getKeywordFiveList(KeywordVO vo) {

		return searchKeywordDAO.getKeywordFiveList(vo);
	}

}
