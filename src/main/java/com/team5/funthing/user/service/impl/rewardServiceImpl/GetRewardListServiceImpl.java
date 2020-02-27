package com.team5.funthing.user.service.impl.rewardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardDAO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardService.GetRewardListService;

@Service
public class GetRewardListServiceImpl implements GetRewardListService {

	@Autowired
	private RewardDAO rewardDAO;
	
	@Override
	public List<RewardVO> getRewardList(RewardVO vo) {
		return rewardDAO.getRewardList(vo);
	}

}
