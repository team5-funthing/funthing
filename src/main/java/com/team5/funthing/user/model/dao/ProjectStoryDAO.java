package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectStoryVO;

@Repository
public class ProjectStoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertProjectStory(ProjectStoryVO vo) {
		sqlSessionTemplate.insert("insertProjectStory", vo);
	}
	
	public void deleteProjectStory(ProjectStoryVO vo) {
		sqlSessionTemplate.delete("deleteProjectStory", vo);
	}
	
	public void updateProjectStory(ProjectStoryVO vo) {
		sqlSessionTemplate.update("updateProjectStory", vo);
	}
	
	public ProjectStoryVO getProjectStory(ProjectStoryVO vo) {
		return sqlSessionTemplate.selectOne("getProjectStory", vo);
	}
	
	

}
