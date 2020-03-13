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
	}
	public void updateProjectBoard(ProjectBoardVO vo) { 

		projectBoardSqlSessionTemplate.update("ProjectBoardDAO.updateProjectBoard", vo);
	}
	public void deleateProjectBoard(ProjectBoardVO vo) {
		projectBoardSqlSessionTemplate.delete("ProjectBoardDAO.deleateProjectBoard", vo);
	}
	
	public List<ProjectBoardVO> getEntireProjectBoardList(ProjectBoardVO vo){
		List<ProjectBoardVO> getProjectBoardList = projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.getEntireProjectBoardList", vo);
		
		return getProjectBoardList;

	}
	public ProjectBoardVO getChoiceProjectBoard(ProjectBoardVO vo) {
		return projectBoardSqlSessionTemplate.selectOne("ProjectBoardDAO.getChoiceProjectBoard", vo);
	
	}
	public void insertProjectBoardReply(ProjectBoardVO vo) {
		
		projectBoardSqlSessionTemplate.insert("ProjectBoardDAO.insertProjectBoardReply", vo);

		
	}

	public ProjectBoardVO getChoiceProjectBoardReply(ProjectBoardVO vo) {
		return projectBoardSqlSessionTemplate.selectOne("ProjectBoardDAO.getChoiceProjectBoardReply",vo);
	}
	
	public void updateProjectBoardReply(ProjectBoardVO vo) {
		projectBoardSqlSessionTemplate.update("ProjectBoardDAO.updateProjectBoardReply", vo);

		
	}
	public void deleateProjectBoardReply(ProjectBoardVO vo) {
		projectBoardSqlSessionTemplate.delete("ProjectBoardDAO.deleateProjectBoardReply", vo);
		
	}
}