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
	
	public List<ProjectBoardVO> getEntireProjectBoardList(ProjectBoardVO vo){
		System.out.println("������Ʈ �Խ��� ��ü�� ��� ������");
		List<ProjectBoardVO> getProjectBoardList = projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.getEntireProjectBoardList", vo);
		
		return getProjectBoardList;

	}
	public ProjectBoardVO getChoiceProjectBoard(ProjectBoardVO vo) {
		
		System.out.println("������Ʈ �Խ��� ������ �� �����ϱ�");
		return projectBoardSqlSessionTemplate.selectOne("ProjectBoardDAO.getChoiceProjectBoard", vo);
	
	}
	public void insertProjectBoardReply(ProjectBoardVO vo) {
		
		projectBoardSqlSessionTemplate.insert("ProjectBoardDAO.insertProjectBoardReply", vo);
		System.out.println("������Ʈ ��� �Է�");
		
	}
	public List<ProjectBoardVO> getProjectBoard(ProjectBoardVO vo) {
		System.out.println("������Ʈ���忡 �ִ°� �� ��������");
		
		return projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.getProjectBoard",vo);
	}
}