package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminCreatorVO;
import com.team5.funthing.user.model.vo.UserCreatorVO;

@Repository
public class UserCreatorDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int updateCreator(UserCreatorVO vo) {
		return sqlSessionTemplate.update("UserCreatorDAO.updateCreator",vo);
	}
	
	public int insertCreator(UserCreatorVO vo) {
		return sqlSessionTemplate.insert("UserCreatorDAO.insertCreator", vo);
	}
	
}
