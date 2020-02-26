package com.team5.funthing.user.service.impl.RewardOptionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardOptionDAO;
import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.service.rewardOptionService.InsertRewardOptionService;

@Service
public class InsertRewardOptionServiceImpl implements InsertRewardOptionService {

	@Autowired
	private RewardOptionDAO rewardOptionDAO;
	
	@Override
	public int insertRewardOption(RewardOptionVO vo) {
		return rewardOptionDAO.insertRewardOption(vo);
	}

}
