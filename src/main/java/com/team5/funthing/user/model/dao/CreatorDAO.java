package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.CreatorVO;

@Repository
public class CreatorDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int updateCreator(CreatorVO vo) {
		return sqlSessionTemplate.update("CreatorDAO.updateCreator",vo);
	}
	
	public int insertCreator(CreatorVO vo) {
		return sqlSessionTemplate.insert("CreatorDAO.insertCreator", vo);
	}
	
	public int deleteCreator(CreatorVO vo) {
		return sqlSessionTemplate.insert("CreatorDAO.deleteCreator", vo);
	}
	
	public CreatorVO getCreator(CreatorVO vo) {
		return sqlSessionTemplate.selectOne("CreatorDAO.getCreator",vo);
	}
	
	public List<CreatorVO> getCreatorList(CreatorVO vo){
		return sqlSessionTemplate.selectList("CreatorDAO.getCreatorList", vo);
	}

	public CreatorVO getCreatorEmail(CreatorVO vo) {
		return sqlSessionTemplate.selectOne("CreatorDAO.getCreatorEmail",vo);
	}
	
	public List<CreatorVO> getCreatorListByEmail(CreatorVO vo){
		return sqlSessionTemplate.selectList("getCreatorListByEmail", vo);
	}
	
}
