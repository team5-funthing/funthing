package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.RewardService.DeleteRewardService;
import com.team5.funthing.user.service.RewardService.GetRewardListService;
import com.team5.funthing.user.service.RewardService.GetRewardService;
import com.team5.funthing.user.service.RewardService.InsertRewardService;
import com.team5.funthing.user.service.RewardService.UpdateRewardService;

@Controller
public class RewardController {
	
	@Autowired
	GetRewardListService getRewardListService;
	@Autowired
	GetRewardService getRewardService;
	@Autowired
	InsertRewardService insertRewardService;
	@Autowired
	UpdateRewardService upeateRewardService;
	@Autowired
	DeleteRewardService deleteRewardService;
	
	@RequestMapping("showReward.udo")
	public String showRewardList(RewardVO vo,Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		System.out.println(projectNo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		System.out.println(rewardList.toString());
		model.addAttribute("rewardList", rewardList);
		model.addAttribute("projectNo", projectNo);
		return "f-create-project";
	}
	
	@RequestMapping(value= "insertReward.udo", method=RequestMethod.POST)
	public String insertReward(RewardVO vo, Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		vo.setProjectNo(projectNo);
		System.out.println(vo.toString());
		
		insertRewardService.insertReward(vo);
		System.out.println("입력완료");
		System.out.println(vo.getRewardNo());
		
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		System.out.println(rewardList.toString());
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("rewardList", rewardList);
		return "f-create-project";
	}
	
	@RequestMapping(value="deleteReward.udo" , method=RequestMethod.POST)
	public String deleteReward(RewardVO vo,Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		System.out.println("선택해서 넘어온 값 : " + vo.toString());
		
		deleteRewardService.deleteReward(vo);
		System.out.println(vo.getRewardNo());
		System.out.println("삭제 완료");
		model.addAttribute("projectNo", projectNo);
		
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		System.out.println(rewardList.toString());
		model.addAttribute("rewardList", rewardList);
		
		return "f-create-project";
	}
	
	@RequestMapping(value="updateReward.udo")
	public String updateReward() {
		System.out.println("아하하하하");
		return "i-popup-addReward";
	}
	
	@RequestMapping(value="getReward.udo")
	public void getReward() {
		System.out.println("버튼 누름");
	}
	
}
