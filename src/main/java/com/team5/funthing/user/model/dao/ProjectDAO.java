package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class ProjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public void createProject(ProjectVO vo) { // 프로젝트 생성 폼 전체 작성 완료시 실행 될 메서드
		
	}
	
	public ProjectVO insertProject(ProjectVO vo) { // 입력|임시 저장 시에 사용 될 메서드
		sqlSessionTemplate.insert("insertProject", vo);
		return vo;
	}
	
	public void updateProject(ProjectVO vo) {
		sqlSessionTemplate.update("updateProject", vo);
	}
	
	public void deleteProject(ProjectVO vo) {
		sqlSessionTemplate.delete("deleteProject", vo);
		
	}
	
	public ProjectVO getProject(ProjectVO vo) {
		return sqlSessionTemplate.selectOne("getProject", vo);
	}
	
	
	public List<ProjectVO> getProjectListByEmail(ProjectVO vo){
		return sqlSessionTemplate.selectList("getProjectListByEmail",vo);
	}
	
	public List<ProjectVO> getAllFundingProjectList(){
		return sqlSessionTemplate.selectList("getAllFundingProjectList");
	}

//===================================카테고리 검색==========================================

	public List<ProjectVO> getShowCategorySubList(ProjectVO vo) {
		return sqlSessionTemplate.selectList("getShowCategorySubList",vo);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
