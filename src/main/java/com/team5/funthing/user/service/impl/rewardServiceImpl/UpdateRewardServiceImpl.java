package com.team5.funthing.user.service.impl.rewardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardDAO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardService.UpdateRewardService;

@Service
public class UpdateRewardServiceImpl implements UpdateRewardService {

	@Autowired
	private RewardDAO rewardDAO;
	
	public int updateReward(RewardVO vo) {
		return rewardDAO.updateReward(vo);
	}
	
}
