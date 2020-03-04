package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.RewardSelectionVO;

@Repository
public class RewardSelectionDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertRewardSelection(RewardSelectionVO vo) {
		sqlSessionTemplate.insert("insertRewardSelection", vo);
	}
	
	public List<RewardSelectionVO> getRewardSelectionList(RewardSelectionVO vo){
		return sqlSessionTemplate.selectList("getRewardSelectionList", vo);
	}
	
	public List<RewardSelectionVO> getRewardSelectionJoinList(RewardSelectionVO vo){
		return sqlSessionTemplate.selectList("getRewardSelectionJoinList", vo);
	}
	

}
