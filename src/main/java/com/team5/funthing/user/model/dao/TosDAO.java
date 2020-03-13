package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.TosVO;

@Repository
public class TosDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<TosVO> getTosList(TosVO vo){
		return sqlSessionTemplate.selectList("TosDAO.getTosList", vo);
	}
	
	public TosVO getTos(TosVO vo) {
		return sqlSessionTemplate.selectOne("TosDAO.getTos", vo);
	}
	
	public int insertTos(TosVO vo) {
		return sqlSessionTemplate.insert("TosDAO.insertTos", vo);
	}
	
	public int updateTos(TosVO vo) {
		return sqlSessionTemplate.update("TosDAO.updateTos",vo);
	}
	
	public int deleteTos(TosVO vo) {
		return sqlSessionTemplate.delete("TosDAO.deleteTos",vo);
	}
	
}
