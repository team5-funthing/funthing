package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.SearchKeywordVO;

@Repository
public class SearchKeywordDAO {
	
	 @Autowired
	   private SqlSessionTemplate sqlSessionTemplate;

	public List<ProjectVO> getSearchKeyword(String searchKeyword) {
		return sqlSessionTemplate.selectList("SearchKeywordDAO.getSearchKeyword", searchKeyword);
	}


	 
	 

}
