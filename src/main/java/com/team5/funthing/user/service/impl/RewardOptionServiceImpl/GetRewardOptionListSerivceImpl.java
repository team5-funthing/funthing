package com.team5.funthing.user.service.impl.RewardOptionServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardOptionDAO;
import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.service.rewardOptionService.GetRewardOptionListService;

@Service
public class GetRewardOptionListSerivceImpl implements GetRewardOptionListService{

	@Autowired
	private RewardOptionDAO rewardOptionDAO;
	
	@Override
	public List<RewardOptionVO> getRewardOptionList(RewardOptionVO vo) {
		return rewardOptionDAO.getRewardOptionList(vo);
	}

	
	
}
