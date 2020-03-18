package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectAskMessageVO;


@Repository
public class ProjectAskMessageDAO2 {
	
	@Autowired
	private SqlSessionTemplate projectAskMessageSqlSessionTemplate;
	
	
	public List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList(ProjectAskMessageVO vo) {
		
		System.out.println(vo.getEmail());
		
		return projectAskMessageSqlSessionTemplate.selectList("projectAskMessageDAO2.getEntireProjectMakerAskMessageList",vo);
	}



	
	
	

}
