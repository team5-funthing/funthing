package com.team5.funthing.user.model.dao;

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
	
	public void insertProject(ProjectVO vo) { // 입력/임시 저장 시에 사용 될 메서드
		
	}
	
	public void updateProject(ProjectVO vo) {
		
	}
	
	public void deleteProject(ProjectVO vo) {
		
	}
	
	
}
