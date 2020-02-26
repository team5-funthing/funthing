package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectBoardVO;


@Repository
public class HomeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<ProjectBoardVO> getAttentionProjectList(ProjectBoardVO vo) {
		System.out.println("�ָ��� ������Ʈ ��������(����:����̸�����)");
		return sqlSessionTemplate.selectList("HomeDAO.getAttentionProjectList", vo);
	}
	
	
}
