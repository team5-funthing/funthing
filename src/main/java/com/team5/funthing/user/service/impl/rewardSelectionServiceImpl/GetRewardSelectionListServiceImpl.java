package com.team5.funthing.user.service.impl.rewardSelectionServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardSelectionDAO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.service.rewardSelectionService.GetRewardSelectionListService;

@Service
public class GetRewardSelectionListServiceImpl implements GetRewardSelectionListService {
	
	@Autowired
	private RewardSelectionDAO rewardSelectionDAO;
	
	@Override
	public List<RewardSelectionVO> getRewardSelectionList(RewardSelectionVO vo) {
		return rewardSelectionDAO.getRewardSelectionList(vo);
	}

}
