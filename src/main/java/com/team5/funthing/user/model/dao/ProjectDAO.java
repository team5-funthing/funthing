package com.team5.funthing.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectVO;

@Repository
public class ProjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public void createProject(ProjectVO vo) { // ������Ʈ ���� �� ��ü �ۼ� �Ϸ�� ���� �� �޼���
		
	}
	
	public void insertProject(ProjectVO vo) { // �Է�/�ӽ� ���� �ÿ� ��� �� �޼���
		
	}
	
	public void updateProject(ProjectVO vo) {
		
	}
	
	public void deleteProject(ProjectVO vo) {
		
	}
	
	
}
