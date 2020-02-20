package com.team5.funthing.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminMemberVO;

@Repository
public class AdminLoginDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public AdminMemberVO getAdminPassword(AdminMemberVO vo) {
		return sqlSessionTemplate.selectOne("AdminLoginDAO.getAdminLoginPassword", vo);
	}
	
}
