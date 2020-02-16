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
	
	public ProjectVO insertProject(ProjectVO vo) { // �Է�|�ӽ� ���� �ÿ� ��� �� �޼���
		
		System.out.println(" DAO(before) : " + vo.getProjectNo());
		sqlSessionTemplate.insert("ProjectDAO.insertProject", vo);
		System.out.println(" DAO(after) : " + vo.getProjectNo());
		return vo;
	}
	
	public void updateProject(ProjectVO vo) {
		
		System.out.println(" DAO(update before) : " + vo.toString());
		sqlSessionTemplate.update("ProjectDAO.updateProject", vo);
		System.out.println(" DAO(update after) : " + vo.toString());
		
	}
	
	public void deleteProject(ProjectVO vo) {
		
	}
	
	public ProjectVO getProejct(ProjectVO vo) {
		return sqlSessionTemplate.selectOne("ProjectDAO.getProject", vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
