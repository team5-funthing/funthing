package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.KeywordVO;

@Repository
public class KeywordDAO {
	
	@Autowired
	private SqlSessionTemplate sqlsessionTemplate;
	
	
	public void insertKeyword(KeywordVO vo) {
		sqlsessionTemplate.selectOne("insertKeyword", vo);
	}
	
	public void deleteKeyword(KeywordVO vo) {
		
	}
	
	public void updateKeyword(KeywordVO vo) {
		
	}
	
	public KeywordVO getKeyword(KeywordVO vo) {
		return null;
	}
	
	public List<KeywordVO> getKeywordList() {
		return sqlsessionTemplate.selectList("getKeywordList");
	}

}
