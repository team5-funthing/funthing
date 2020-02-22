package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectKeywordVO;

@Repository
public class ProjectKeywordDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public void insertProjectKeyword(ProjectKeywordVO vo) {
		
		System.out.println("insertProjectKeyword ½ÇÇà Àü : " + vo.toString());
		
		sqlSessionTemplate.insert("insertProjectKeyword", vo);
	}
	
	public int deleteProjectKeyword(ProjectKeywordVO vo) {
		return sqlSessionTemplate.delete("deleteProjectKeyword", vo);
		
	}
	
	public void updateProjectKeyword(ProjectKeywordVO vo) {
		
	}
	
	public ProjectKeywordVO getProjectKeyword(ProjectKeywordVO vo) {
		return null;
	}
	
	public List<ProjectKeywordVO> getProjectKeywordList(ProjectKeywordVO vo) {
		return sqlSessionTemplate.selectList("getProjectKeywordList", vo);
	}
}
