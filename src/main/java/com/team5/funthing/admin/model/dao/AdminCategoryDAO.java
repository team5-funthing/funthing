package com.team5.funthing.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminCategoryVO;

@Repository
public class AdminCategoryDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<AdminCategoryVO> getCategoryList(AdminCategoryVO vo){
		return sqlSessionTemplate.selectList("CategoryDAO.getCategoryList", vo);
	}
	
	public AdminCategoryVO getCategory(AdminCategoryVO vo) {
		return sqlSessionTemplate.selectOne("CategoryDAO.getCategory", vo);
	}
	
	public int deleteCategory(AdminCategoryVO vo) {
		return sqlSessionTemplate.delete("CategoryDAO.deleteCategory", vo);
	}
	
	public int insertCategory(AdminCategoryVO vo) {
		return sqlSessionTemplate.insert("CategoryDAO.insertCategory", vo);
	}
	
}
