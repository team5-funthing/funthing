package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.RewardOptionVO;

@Repository
public class RewardOptionDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<RewardOptionVO> getRewardOptionList(RewardOptionVO vo){
		return sqlSessionTemplate.selectList("RewardOptionDAO.getRewardOptionList", vo);
	}
	
	public int insertRewardOption(RewardOptionVO vo) {
		return sqlSessionTemplate.insert("RewardOptionDAO.insertRewardOption", vo);
	}
	
	public int updateRewardOption(RewardOptionVO vo) {
		return sqlSessionTemplate.update("RewardOptionDAO.updateRewardOption", vo);
	}
	
	public int deleteRewardOption(RewardOptionVO vo) {
		return sqlSessionTemplate.delete("RewardOptionDAO.deleteRewardOption", vo);
	}
	
}
