package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;

@Repository
public class PersonalInfoProcessingDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<AdminPersonalInfoProcessingVO> getPersonalInfoProcessingList(AdminPersonalInfoProcessingVO vo){
		return sqlSessionTemplate.selectList("PersonalInfoProcessingDAO.getPersonalInfoProcessingList",vo);
	}
	
	public AdminPersonalInfoProcessingVO getPersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return sqlSessionTemplate.selectOne("PersonalInfoProcessingDAO.getPersonalInfoProcessing",vo);
	}
	
	public int insertPersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return sqlSessionTemplate.insert("PersonalInfoProcessingDAO.insertPersonalInfoProcessing",vo);
	}
	
	public int updatePersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return sqlSessionTemplate.update("PersonalInfoProcessingDAO.updatePersonalInfoProcessing",vo);
	}
	
	public int deletePersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return sqlSessionTemplate.delete("PersonalInfoProcessingDAO.deletePersonalInfoProcessing",vo);
	}
	
}
