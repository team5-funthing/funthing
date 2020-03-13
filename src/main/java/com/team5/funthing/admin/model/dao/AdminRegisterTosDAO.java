package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;

@Repository
public class AdminRegisterTosDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<AdminRegisterTosVO> getRegisterTosList(AdminRegisterTosVO vo){
		return sqlSessionTemplate.selectList("AdminRegisterTosDAO.getRegisterTosList", vo);
	}
	
	public AdminRegisterTosVO getRegisterTos(AdminRegisterTosVO vo) {
		return sqlSessionTemplate.selectOne("AdminRegisterTosDAO.getRegisterTos",vo);
	}
	
	public int insertRegisterTos(AdminRegisterTosVO vo) {
		return sqlSessionTemplate.insert("AdminRegisterTosDAO.insertRegisterTos", vo);
	}
	
	public int updateRegisterTos(AdminRegisterTosVO vo) {
		return sqlSessionTemplate.update("AdminRegisterTosDAO.updateRegisterTos",vo);
	}
	
	public int deleteRegisterTos(AdminRegisterTosVO vo) {
		return sqlSessionTemplate.delete("AdminRegisterTosDAO.deleteRegisterTos",vo);
	}
}
