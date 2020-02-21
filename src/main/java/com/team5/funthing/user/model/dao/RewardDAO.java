package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.RewardVO;

@Repository
public class RewardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public RewardVO getReward(RewardVO vo) {
		return sqlSessionTemplate.selectOne("RewardDAO.getReward",vo);
	}
	
	public List<RewardVO> getRewardList(RewardVO vo){
		return sqlSessionTemplate.selectList("RewardDAO.getRewardList", vo);
	}
	
	public int insertReward(RewardVO vo) {
		return sqlSessionTemplate.insert("RewardDAO.insertReward", vo);
	}
	
	public int updateReward(RewardVO vo) {
		return sqlSessionTemplate.update("RewardDAO.updateReward",vo);
	}
	
	public int deleteReward(RewardVO vo) {
		return sqlSessionTemplate.delete("RewardDAO.deleteReward",vo);
	}
	
}
