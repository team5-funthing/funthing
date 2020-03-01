package com.team5.funthing.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardOptionService.GetRewardOptionListService;
import com.team5.funthing.user.service.rewardSelectionService.InsertRewardSelectionService;
import com.team5.funthing.user.service.rewardService.GetRewardListService;

@Controller
public class SupportProjectController {

	@Autowired
	private GetRewardListService getRewardListService;
	@Autowired
	private GetRewardOptionListService getRewardOptionListService;
	@Autowired
	private InsertRewardSelectionService insertRewardSelectionService;
	
	@Autowired
	private RewardOptionVO rewardOptionVO;
	
	@RequestMapping(value="supportProject.udo", method= RequestMethod.POST)
	public String supportProject(RewardVO rvo, Model model) {
		
		List<RewardVO> getRewardList = getRewardListService.getRewardList(rvo);
		setRewardOption(getRewardList);
		model.addAttribute("getRewardList", getRewardList);
		
		return "f-select-reward";
	}
	
	@RequestMapping(value = "addSelectReword.udo", method = RequestMethod.POST)
	public String addSelectReword(RewardSelectionVO rsvo, Model model) {
		
		insertRewardSelectionService.insertRewardSelection(rsvo);
		
		return "f-select-reward";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setRewardOption(List<RewardVO> getRewardList){
		
		for(RewardVO reward: getRewardList) {
			rewardOptionVO.setRewardNo(reward.getRewardNo());
			reward.setRewardOptionList(getRewardOptionListService.getRewardOptionList(rewardOptionVO));
		}
	}
	
	
	
	
	
	
	
	
	
}
