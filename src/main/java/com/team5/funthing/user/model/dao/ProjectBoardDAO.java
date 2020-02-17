package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectBoardVO;

@Repository
public class ProjectBoardDAO {
	
	@Autowired
	private SqlSessionTemplate projectBoardSqlSessionTemplate;

	
	public void insertProjectBoard(ProjectBoardVO vo) {
		projectBoardSqlSessionTemplate.insert("ProjectBoardDAO.insertProjectBoard", vo);
		System.out.println("������Ʈ �Խ��� �� �Է�");
	}
	public void updateProjectBoard(ProjectBoardVO vo) { 
		projectBoardSqlSessionTemplate.update("ProjectBoardDAO.updateProjectBoard", vo);
		System.out.println("������Ʈ �Խ��� �� ���� ");
	}
	public void deleateProjectBoard(ProjectBoardVO vo) {
		projectBoardSqlSessionTemplate.delete("ProjectBoardDAO.deleateProjectBoard", vo);
		System.out.println("������Ʈ �Խ��� ���� ����  ");
	}
	public void entireDeleateProjectBoard(ProjectBoardVO vo) { 
		projectBoardSqlSessionTemplate.delete("ProjectBoardDAO.entireDeleateProjectBoard", vo);
		System.out.println("������Ʈ �Խ��� ��ü ����  ");
	}
	public List<ProjectBoardVO> selectEntireProjectBoardList(ProjectBoardVO vo){
		System.out.println("������Ʈ �Խ��� ��ü�� ��� ������");
		return projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.selectEntireProjectBoardList", vo);

}
}