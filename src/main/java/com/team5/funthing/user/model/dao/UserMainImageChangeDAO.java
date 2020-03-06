package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;

@Repository
public class UserMainImageChangeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<AdminUserMainImageChangeVO> getUserMainImageChangeList(AdminUserMainImageChangeVO vo){
		return sqlSessionTemplate.selectList("UserMainImageChangeDAO.getUserMainImageChangeList", vo);
	}
	
}
