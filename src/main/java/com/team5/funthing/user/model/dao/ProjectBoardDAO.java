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
		System.out.println("프로젝트 게시판 글 입력");
	}
	public void updateProjectBoard(ProjectBoardVO vo) { 

		projectBoardSqlSessionTemplate.update("ProjectBoardDAO.updateProjectBoard", vo);
		System.out.println("프로젝트 게시판 글 수정 ");
	}
	public void deleateProjectBoard(ProjectBoardVO vo) {
		projectBoardSqlSessionTemplate.delete("ProjectBoardDAO.deleateProjectBoard", vo);
		System.out.println("프로젝트 게시판 개별 삭제  ");
	}
	
	public List<ProjectBoardVO> getEntireProjectBoardList(ProjectBoardVO vo){
		System.out.println("프로젝트 게시판 전체글 목록 얻어오기");
		List<ProjectBoardVO> getProjectBoardList = projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.getEntireProjectBoardList", vo);
		
		return getProjectBoardList;

	}
	public ProjectBoardVO getChoiceProjectBoard(ProjectBoardVO vo) {
		
		System.out.println("프로젝트 게시판 선택한 글 수정하기");
		return projectBoardSqlSessionTemplate.selectOne("ProjectBoardDAO.getChoiceProjectBoard", vo);
	
	}
	public void insertProjectBoardReply(ProjectBoardVO vo) {
		
		projectBoardSqlSessionTemplate.insert("ProjectBoardDAO.insertProjectBoardReply", vo);
		System.out.println("프로젝트 답글 입력");
		
	}
	public List<ProjectBoardVO> getProjectBoard(ProjectBoardVO vo) {
		System.out.println("프로젝트보드에 있는거 다 가져오기");
		
		return projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.getProjectBoard",vo);
	}
}