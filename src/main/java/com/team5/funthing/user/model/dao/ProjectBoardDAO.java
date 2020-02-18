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
	public void entireDeleateProjectBoard(ProjectBoardVO vo) { 
		projectBoardSqlSessionTemplate.delete("ProjectBoardDAO.entireDeleateProjectBoard", vo);
		System.out.println("프로젝트 게시판 전체 삭제  ");
	}
	public List<ProjectBoardVO> selectEntireProjectBoardList(ProjectBoardVO vo){
		System.out.println("프로젝트 게시판 전체글 목록 얻어오기");
		return projectBoardSqlSessionTemplate.selectList("ProjectBoardDAO.selectEntireProjectBoardList", vo);

}
}