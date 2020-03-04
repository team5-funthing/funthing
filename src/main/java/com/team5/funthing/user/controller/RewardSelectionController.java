package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardOptionService.GetRewardOptionListService;
import com.team5.funthing.user.service.rewardService.GetRewardListService;

@Controller
@SessionAttributes("reward")
public class RewardSelectionController {

	@Autowired
	private GetRewardListService getRewardListService;
	@Autowired
	private GetRewardOptionListService getRewardOptionListService;
	
	@Autowired
	private RewardOptionVO rewardOptionVO;
	
	
	@RequestMapping(value="/supportProject.udo", method= RequestMethod.GET)
	public String supportProject(	@RequestParam(required = false)int projectNo,
									@RequestParam(required = false)String msg,
									RewardVO rvo, 
									Model model, 
									HttpSession session) {
		
		
		if(rvo.getProjectNo() == -1 || rvo.getProjectNo() == 0) {
			rvo.setProjectNo(projectNo);
		}
		
		session.removeAttribute("selectedRewardList");

		List<RewardVO> getRewardList = getRewardListService.getRewardList(rvo);
		setRewardOption(getRewardList);
		
		model.addAttribute("msg", msg);
		model.addAttribute("getRewardList", getRewardList);
		model.addAttribute("projectNoOfRewardList", rvo.getProjectNo());
		return "f-select-reward";
	}
	
	@RequestMapping(value = "/addSelectReward.udo", method = RequestMethod.POST)
	@ResponseBody
	public String addSelectReword(	@RequestBody RewardSelectionVO rsvo,
												RewardVO rvo,
												HttpSession session,
												Model model) throws JsonProcessingException {
		
		rsvo.setPaymentAmount(rsvo.getPaymentAmount() * rsvo.getOrderAmount());
		
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");

		if(selectedRewardList == null){
			System.out.println("selectedRewardList 세션 초기 생성");
			selectedRewardList = new ArrayList<RewardSelectionVO>();
			session.setAttribute("selectedRewardList", selectedRewardList);
		}
		
		
		for(int i = 0; i < selectedRewardList.size(); i++) {
			
			System.out.println("1 : " + selectedRewardList.get(i).getRewardNo() + ", 2 : " + rsvo.getRewardNo());
			
			if(selectedRewardList.get(i).getRewardNo() == rsvo.getRewardNo()) {
				selectedRewardList.remove(i);
			}
		}
		
		selectedRewardList.add(rsvo);
		
		System.out.println("----------------체크 했거나 수량을 늘렸을 때----------------------");
		for(RewardSelectionVO selectedReward: selectedRewardList) {
			System.out.println(selectedReward.toString());
		}
		System.out.println("--------------------------------------------------------------");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String selectionRewardToJSON = mapper.writeValueAsString(selectedRewardList);
		
		return selectionRewardToJSON;		
	}
	@RequestMapping(value = "/removeSelectReward.udo", method = RequestMethod.POST)
	@ResponseBody
	public String removeSelectReword(@RequestBody RewardSelectionVO rsvo,
									HttpSession session,
									Model model) throws JsonProcessingException {
		
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		
		if(selectedRewardList == null) {
			return null;
		}
		
		for(int i = 0; i < selectedRewardList.size(); i++) {
			
			System.out.println("1 : " + selectedRewardList.get(i).getRewardNo() + ", 2 : " + rsvo.getRewardNo());
			
			if(selectedRewardList.get(i).getRewardNo() == rsvo.getRewardNo()) {
				System.out.println("삭제 : " + selectedRewardList.get(i));
				selectedRewardList.remove(i);
			}
		}
		
		System.out.println("----------------체크 해제 했거나 수량을 줄였을 때----------------------");
		for(RewardSelectionVO selectedReward : selectedRewardList) {
			System.out.println(selectedReward.toString());
		}
		System.out.println("--------------------------------------------------------------");
		
		ObjectMapper mapper = new ObjectMapper();
		String selectionRewardToJSON = mapper.writeValueAsString(selectedRewardList);
		
		
		
		return selectionRewardToJSON;		
	}
	
	
	public void setRewardOption(List<RewardVO> getRewardList){
		
		for(RewardVO reward: getRewardList) {
			rewardOptionVO.setRewardNo(reward.getRewardNo());
			reward.setRewardOptionList(getRewardOptionListService.getRewardOptionList(rewardOptionVO));
		}
	}
	
	
	
	
	
}
