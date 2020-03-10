package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;

@Repository
public class AdminUserMainImageChangeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void updateUserMainImage(AdminUserMainImageChangeVO vo) {
		sqlSessionTemplate.update("UserMainImageChangeDAO.updateUserMainImage",vo);
	}
	
	public void updateUserMainImageNull(AdminUserMainImageChangeVO vo) {
		sqlSessionTemplate.update("UserMainImageChangeDAO.updateUserMainImageNull",vo);
	}
	
	public List<AdminUserMainImageChangeVO> getUserMainImageChange(){
		return sqlSessionTemplate.selectList("UserMainImageChangeDAO.getUserMainImageChange");
	}
	
	public void deleteUserMainImageChange(AdminUserMainImageChangeVO vo) {
		sqlSessionTemplate.delete("UserMainImageChangeDAO.deleteUserMainImage",vo);
	}
	
	public void insertUserMainImage(AdminUserMainImageChangeVO vo) {
		sqlSessionTemplate.insert("UserMainImageChangeDAO.inserUserMainImage",vo);
	}
	
}
