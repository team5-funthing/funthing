package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;

@Repository
public class ProjectIntroduceImageDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertProjectIntroduceImage(ProjectIntroduceImageVO vo) {
		
		sqlSessionTemplate.insert("insertProjectIntroduceImage", vo);
	}
	
	public List<ProjectIntroduceImageVO> getProjectIntroduceImageList(ProjectIntroduceImageVO vo){
		return sqlSessionTemplate.selectList("getProjectIntroduceImageList", vo);
	}
	
	public void deleteProjectIntroduceImage(ProjectIntroduceImageVO vo) {
		sqlSessionTemplate.delete("deleteProjectIntroduceImage", vo);
	}
	
}
