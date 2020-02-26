package com.team5.funthing.user.service.impl.rewardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardDAO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardService.GetRewardService;

@Service
public class GetRewardServiceImpl implements GetRewardService {

	@Autowired
	private RewardDAO rewardDAO;
	
	@Override
	public RewardVO getReward(RewardVO vo) {
		return rewardDAO.getReward(vo);
	}

	

}
