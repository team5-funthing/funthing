package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class SearchKeywordDAO {
	
	 @Autowired
	   private SqlSessionTemplate sqlSessionTemplate;

	public List<ProjectVO> getSearchKeyword(String searchKeyword) {
		return sqlSessionTemplate.selectList("SearchKeywordDAO.getSearchKeyword",searchKeyword);
	}

	public void updateKeywordCount(String searchKeyword) {
		sqlSessionTemplate.update("SearchKeywordDAO.updateKeywordCount",searchKeyword);
		
	}

	public List<KeywordVO> getKeywordFiveList(KeywordVO vo) {
		return sqlSessionTemplate.selectList("SearchKeywordDAO.getKeywordFiveList", vo);

	}

	public List<ProjectVO> getSearchKeywordByKeyword(String searchKeyword) {
		System.out.println("searchKeyword:"+searchKeyword);
		return sqlSessionTemplate.selectList("getSearchKeywordByKeyword",searchKeyword);
	}

	public List<ProjectVO> getClickKeywordList(String keyword) {
		return sqlSessionTemplate.selectList("getClickKeywordList",keyword);
	}

	public List<ProjectVO> getSearchKeywordByKeywordShap(String searchKeyword) {
		return sqlSessionTemplate.selectList("getSearchKeywordByKeywordShap",searchKeyword);
	}

	public void updateKeywordCountShap(String searchKeyword) {
		sqlSessionTemplate.update("SearchKeywordDAO.updateKeywordCountShap",searchKeyword);
		
	}


	 
	 

}
