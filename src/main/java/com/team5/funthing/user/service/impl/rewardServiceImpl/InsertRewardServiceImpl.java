package com.team5.funthing.user.service.impl.rewardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardDAO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardService.InsertRewardService;

@Service
public class InsertRewardServiceImpl implements InsertRewardService {

	@Autowired
	private RewardDAO rewardDAO;
	
	public int insertReward(RewardVO vo) {
		return rewardDAO.insertReward(vo);
	}
	
}
