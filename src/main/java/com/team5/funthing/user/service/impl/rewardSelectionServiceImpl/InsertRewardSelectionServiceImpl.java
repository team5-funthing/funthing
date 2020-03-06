package com.team5.funthing.user.service.impl.rewardSelectionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.RewardSelectionDAO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.service.rewardSelectionService.InsertRewardSelectionService;

@Service
public class InsertRewardSelectionServiceImpl implements InsertRewardSelectionService {

	@Autowired
	private RewardSelectionDAO rewardSelectionDAO;
	
	@Override
	public void insertRewardSelection(RewardSelectionVO vo) {
		rewardSelectionDAO.insertRewardSelection(vo);
	}

}
