package com.team5.funthing.user.service.impl.rewardOptionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardOptionDAO;
import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.service.rewardOptionService.DeleteRewardOptionService;

@Service
public class DeleteRewardOptionServiceImpl implements DeleteRewardOptionService {

	@Autowired
	private RewardOptionDAO rewardOptionDAO;
	
	@Override
	public int deleteRewardOption(RewardOptionVO vo) {
		return rewardOptionDAO.deleteRewardOption(vo);
	}

}
