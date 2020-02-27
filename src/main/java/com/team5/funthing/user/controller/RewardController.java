package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.model.vo.RewardVO;
	
import com.team5.funthing.user.service.rewardOptionService.DeleteRewardOptionService;
import com.team5.funthing.user.service.rewardOptionService.GetRewardOptionListService;
import com.team5.funthing.user.service.rewardOptionService.InsertRewardOptionService;
import com.team5.funthing.user.service.rewardOptionService.UpdateRewardOptionService;
import com.team5.funthing.user.service.rewardService.DeleteRewardService;
import com.team5.funthing.user.service.rewardService.GetRewardListService;
import com.team5.funthing.user.service.rewardService.GetRewardService;
import com.team5.funthing.user.service.rewardService.InsertRewardService;
import com.team5.funthing.user.service.rewardService.UpdateRewardService;


@Controller
public class RewardController {
	
	@Autowired
	private GetRewardListService getRewardListService;
	@Autowired
	private GetRewardService getRewardService;
	@Autowired
	private InsertRewardService insertRewardService;
	@Autowired
	private UpdateRewardService updateRewardService;
	@Autowired
	private DeleteRewardService deleteRewardService;
	@Autowired
	private GetRewardOptionListService getRewardOptionListSerivce;
	@Autowired
	private InsertRewardOptionService insertRewardOptionService;
	@Autowired
	private UpdateRewardOptionService updateRewardOptionService;
	@Autowired
	private DeleteRewardOptionService deleteRewardOptionSerivice;
	
	@RequestMapping("showReward.udo")
	public String showRewardList(RewardVO vo,Model model,HttpServletRequest request) {
		//=============================프로젝트 번호 세팅부분=======================
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		ProjectVO pvo = new ProjectVO();	
		pvo.setProjectNo(projectNo);
		pvo.setWriteStatus('n');
		//=============================객체 전송 부분=============================
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("writingProject",pvo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);

		model.addAttribute("rewardList", rewardList);
		return "f-create-project";
	}
	
	@RequestMapping(value= "insertReward.udo", method=RequestMethod.POST)
	public String insertReward(	RewardVO vo, RewardOptionVO rovo, 
								@RequestParam(value="rewardoptionkey", required=false, defaultValue="") List<String> rewardOptionKeys, 
								@RequestParam(value="rewardoptionvalue", required=false) List<String> rewardOptionValues,
								Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		System.out.println(projectNo);
		ProjectVO projectvo = new ProjectVO();
		projectvo.setProjectNo(projectNo);
		vo.setProjectNo(projectNo);
		
		insertRewardService.insertReward(vo);
		System.out.println(vo.getRewardNo());
		
		if(vo.getRewardOption().equals("선택 옵션")) {
			if(!(rewardOptionValues==null)) {
				for(int i=0;i<rewardOptionValues.size();i++) {
					rovo.setRewardNo(vo.getRewardNo());
					System.out.println(rovo.getRewardOptionKey());
					rovo.setRewardOptionKey(rewardOptionKeys.get(i));
					System.out.println(rovo.getRewardOptionValue());
					rovo.setRewardOptionValue(rewardOptionValues.get(i));
					insertRewardOptionService.insertRewardOption(rovo);
				}
			}
		}else if(vo.getRewardOption().equals("직접 입력 옵션")){
			rovo.setRewardNo(vo.getRewardNo());
			rovo.setRewardOptionKey("");
			rovo.setRewardOptionValue(rewardOptionValues.get(0));
			insertRewardOptionService.insertRewardOption(rovo);
		}
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		model.addAttribute("writingProject", projectvo);
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("rewardList", rewardList);
		return "f-create-project";
	}
	
	@RequestMapping(value="deleteReward.udo")
	public String deleteReward(RewardVO vo,RewardOptionVO rovo, Model model,HttpServletRequest request) {

		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		ProjectVO pvo = new ProjectVO();
		pvo.setProjectNo(projectNo);
		pvo.setWriteStatus('n');
		
		vo.setProjectNo(projectNo);
		deleteRewardOptionSerivice.deleteRewardOption(rovo);
		deleteRewardService.deleteReward(vo);
		
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("writingProject",pvo);
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		System.out.println(rewardList.toString());
		model.addAttribute("rewardList", rewardList);
		
		return "f-create-project";
	}
	
	@RequestMapping(value="updateReward.udo")
	public String updateReward(	RewardVO vo,RewardOptionVO rovo,
								@RequestParam(name="rewardoptionkey", required=false) List<String> rewardOptionKeys, 
								@RequestParam(name="rewardoptionvalue", required=false) List<String> rewardOptionValues,
								@RequestParam(name="rewardOptionNo", required=false) List<Integer> rewardOptionNos,
								Model model,HttpServletRequest request) {
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		ProjectVO pvo = new ProjectVO();
		pvo.setProjectNo(projectNo);
		pvo.setWriteStatus('n');
		
		System.out.println(rewardOptionNos);
		System.out.println(rewardOptionValues);
		System.out.println(rewardOptionKeys);
		System.out.println("수정전 입력된 값 : " +  rovo.toString());
		
		if(rewardOptionNos!=null) {
			for(int i=0;i<rewardOptionNos.size();i++) {
				if(rewardOptionKeys==null) rovo.setRewardOptionKey("");
				else rovo.setRewardOptionKey(rewardOptionKeys.get(i));
				rovo.setRewardOptionNo(rewardOptionNos.get(i));
				rovo.setRewardOptionValue(rewardOptionValues.get(i));
				System.out.println(rovo.toString());
				updateRewardOptionService.updateRewardOption(rovo);
			}
		}
		System.out.println(vo.toString());
		updateRewardService.updateReward(vo);
		
		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
		model.addAttribute("projectNo", projectNo);
		model.addAttribute("writingProject",pvo);
		model.addAttribute("rewardList", rewardList);
		
		return "f-create-project";
		
	}
	
	@RequestMapping(value="/getReward.udo" , method=RequestMethod.POST)
	public String getReward(String indexData,RewardOptionVO rovo, RewardVO vo, Model model) throws JsonProcessingException {
		
		//ajax로 받아온 값을 정수로 변환
		int index = Integer.parseInt(indexData);
		vo.setRewardNo(index);
		rovo.setRewardNo(index);
		
		//리워딩 넘버만 받아온 객체를 사용하여 객체의 정보를 받아온다.
		RewardVO modify = getRewardService.getReward(vo);
		List<RewardOptionVO> rewardOptionList = getRewardOptionListSerivce.getRewardOptionList(rovo);
		System.out.println(rovo.toString());
		modify.setRewardOptionList(rewardOptionList);
		
		ObjectMapper mapper = new ObjectMapper();
		String modifyToJson = mapper.writeValueAsString(modify);
		System.out.println("리워드 불러오기 결과 : " + modifyToJson);

		model.addAttribute("modifyRewardToJSON", modifyToJson);
		return "/ajax/getReward";
	}
	
}
	