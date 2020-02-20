package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminCreatorVO;
import com.team5.funthing.user.model.vo.UserCreatorVO;

@Repository
public class AdminCreatorDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteCreator(AdminCreatorVO vo) {
		return sqlSessionTemplate.insert("AdminCreatorDAO.deleteCreator", vo);
	}
	
	public AdminCreatorVO getCreator(AdminCreatorVO vo) {
		return sqlSessionTemplate.selectOne("AdminCreatorDAO.getCreator",vo);
	}
	
	public List<AdminCreatorVO> getCreatorList(AdminCreatorVO vo){
		return sqlSessionTemplate.selectList("AdminCreatorDAO.getCreatorList", vo);
	}
	
}
