package com.team5.funthing.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team5.funthing.user.model.vo.RewardOptionValueListVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;

@Repository
public class RewardSelectionDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public RewardSelectionVO insertRewardSelection(RewardSelectionVO vo) {
		sqlSessionTemplate.insert("insertRewardSelection", vo);
		return vo;
	}
	
	public List<RewardSelectionVO> getRewardSelectionList(RewardSelectionVO vo){
		return sqlSessionTemplate.selectList("getRewardSelectionList", vo);
	}
	
	public List<RewardSelectionVO> getRewardSelectionJoinList(RewardSelectionVO vo){
		return sqlSessionTemplate.selectList("getRewardSelectionJoinList", vo);
	}
	
	public void insertRewardSelectionList(List<RewardOptionValueListVO> vo) {
		
		for(RewardOptionValueListVO value : vo) {
			System.out.println(value.toString());
			sqlSessionTemplate.insert("insertRewardSelectionList", value);
		}
	}
	
	public void updateRewardAmount(RewardSelectionVO vo) {
		sqlSessionTemplate.update("updateRewardAmount",vo);
	}


}
