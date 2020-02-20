package com.team5.funthing.user.service.impl.rewardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardDAO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.RewardService.DeleteRewardService;

@Service
public class DeleteRewardServiceImpl implements DeleteRewardService {

	@Autowired
	private RewardDAO rewardDAO;

	@Override
	public int deleteReward(RewardVO vo) {
		return rewardDAO.deleteReward(vo);
	}
	
	
	
}
