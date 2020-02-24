package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.ProjectVO;
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
	UpdateRewardService updateRewardService;
	@Autowired
	DeleteRewardService deleteRewardService;
	
	@RequestMapping("showReward.udo")
	public String showRewardList(RewardVO vo,Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		ProjectVO pvo = new ProjectVO();	
		pvo.setProjectNo(projectNo);
		pvo.setWriteStatus('n');

		model.addAttribute("projectNo", projectNo);
		model.addAttribute("writingProject",pvo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);

		model.addAttribute("rewardList", rewardList);
		return "f-create-project";
	}
	
	@RequestMapping(value= "insertReward.udo", method=RequestMethod.POST)
	public String insertReward(RewardVO vo, Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		ProjectVO projectvo = new ProjectVO();
		projectvo.setProjectNo(projectNo);
		vo.setProjectNo(projectNo);
		
		insertRewardService.insertReward(vo);
		
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		model.addAttribute("writingProject", projectvo);
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("rewardList", rewardList);
		return "f-create-project";
	}
	
	@RequestMapping(value="deleteReward.udo")
	public String deleteReward(RewardVO vo, Model model,HttpServletRequest request) {

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		ProjectVO pvo = new ProjectVO();
		
		pvo.setProjectNo(projectNo);
		pvo.setWriteStatus('n');
		
		vo.setProjectNo(projectNo);;
		deleteRewardService.deleteReward(vo);
		
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("writingProject",pvo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		System.out.println(rewardList.toString());
		model.addAttribute("rewardList", rewardList);
		
		return "f-create-project";
	}
	
	@RequestMapping(value="updateReward.udo")
	public String updateReward(RewardVO vo, Model model,HttpServletRequest request) {
		
		System.out.println("수정 처리전 값 형태 : " + vo.toString());
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		ProjectVO pvo = new ProjectVO();
		pvo.setProjectNo(projectNo);
		pvo.setWriteStatus('n');

		updateRewardService.updateReward(vo);
		System.out.println("수정 된 번호 열 : " + vo.getRewardNo());
		System.out.println("수정 완료");
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		System.out.println(rewardList.toString());
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("writingProject",pvo);
		model.addAttribute("rewardList", rewardList);
		
		return "f-create-project";
		
	}
	
	@RequestMapping(value="/getReward.udo" , method=RequestMethod.POST)
	public String getReward(String indexData, RewardVO vo, Model model) throws JsonProcessingException {
		System.out.println(indexData);
		
		//ajax로 받아온 값을 정수로 변환
		int index = Integer.parseInt(indexData);
		vo.setRewardNo(index);
		
		//리워딩 넘버만 받아온 객체를 사용하여 객체의 정보를 받아온다.
		RewardVO modify = getRewardService.getReward(vo);

		ObjectMapper mapper = new ObjectMapper();
		String modifyToJson = mapper.writeValueAsString(modify);

		model.addAttribute("modifyRewardToJSON", modifyToJson);
		return "/ajax/getReward";
	}
	
}
