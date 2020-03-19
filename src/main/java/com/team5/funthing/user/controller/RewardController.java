package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
//	@RequestMapping("showReward.udo")
//	public String showRewardList(RewardVO vo, Model model,HttpServletRequest request) {
//		//=============================������Ʈ ��ȣ ���úκ�=======================
//		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
//		
//		ProjectVO pvo = new ProjectVO();	
//		pvo.setProjectNo(projectNo);
//		pvo.setWriteStatus('n');
//		//=============================��ü ���� �κ�=============================
//		model.addAttribute("projectNo", projectNo);
//		model.addAttribute("writingProject",pvo);
//		List<RewardVO> rewardList = getRewardListService.getRewardList(vo);
//
//		model.addAttribute("rewardList", rewardList);
//		return "f-create-project";
//	}
	
	@RequestMapping(value= "insertReward.udo", method=RequestMethod.POST)
	public String insertReward(	RedirectAttributes redirecAttributes,
								RewardVO vo, 
								RewardOptionVO rovo, 
								@RequestParam(required=false) String creator,
								@RequestParam(value="rewardoptionkey", required=false, defaultValue="") List<String> rewardOptionKeys, 
								@RequestParam(value="rewardoptionvalue", required=false) List<String> rewardOptionValues) {
		
		System.out.println("insertReward�� �Ѿ�� �� : " + creator);
		
		int currentProjectNo = vo.getProjectNo();
		System.out.println("insertReward - currentProjectNo : " + currentProjectNo);
		
		insertRewardService.insertReward(vo);
		System.out.println(vo.getRewardNo());
		
		if(vo.getRewardOption().equals("���� �ɼ�")) {
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
		}else if(vo.getRewardOption().equals("���� �Է� �ɼ�")){
			rovo.setRewardNo(vo.getRewardNo());
			rovo.setRewardOptionKey("");
			rovo.setRewardOptionValue(rewardOptionValues.get(0));
			insertRewardOptionService.insertRewardOption(rovo);
		}
		
		redirecAttributes.addAttribute("currentProjectNo", currentProjectNo);
		redirecAttributes.addAttribute("creator", creator);
		return "redirect:getWritingProject.udo";
	}
	
	@RequestMapping(value="deleteReward.udo")
	public String deleteReward(	RedirectAttributes redirecAttributes,
								@RequestParam String creator,
								RewardVO vo,
								RewardOptionVO rovo) {

		int currentProjectNo = vo.getProjectNo();
		System.out.println("deleteReward - currentProjectNo : " + currentProjectNo);

		deleteRewardOptionSerivice.deleteRewardOption(rovo);
		deleteRewardService.deleteReward(vo);
		
		redirecAttributes.addAttribute("creator", creator);
		redirecAttributes.addAttribute("currentProjectNo", currentProjectNo);		
		
		return "redirect:getWritingProject.udo";
	}
	
	@RequestMapping(value="updateReward.udo")
	public String updateReward(	RedirectAttributes redirecAttributes,
								RewardVO vo,
								RewardOptionVO rovo,
								@RequestParam(required=false) String creator,
								@RequestParam(name="rewardoptionkey", required=false) List<String> rewardOptionKeys, 
								@RequestParam(name="rewardoptionvalue", required=false) List<String> rewardOptionValues,
								@RequestParam(name="rewardOptionNo", required=false) List<Integer> rewardOptionNos) {
		
		int currentProjectNo = vo.getProjectNo();
		System.out.println("updateReward - currentProjectNo : " + currentProjectNo);

		
		System.out.println(rewardOptionNos);
		System.out.println(rewardOptionValues);
		System.out.println(rewardOptionKeys);
		System.out.println("������ �Էµ� �� : " +  rovo.toString());
		
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
		
		redirecAttributes.addAttribute("creator", creator);
		redirecAttributes.addAttribute("currentProjectNo", currentProjectNo);
		
		return "redirect:getWritingProject.udo";
		
	}
	
	@RequestMapping(value="/getReward.udo" , method=RequestMethod.POST)
	public String getReward(String indexData,RewardOptionVO rovo, RewardVO vo, Model model) throws JsonProcessingException {

		int index = Integer.parseInt(indexData);
		vo.setRewardNo(index);
		rovo.setRewardNo(index);
		
		RewardVO modify = getRewardService.getReward(vo);
		List<RewardOptionVO> rewardOptionList = getRewardOptionListSerivce.getRewardOptionList(rovo);
		System.out.println(rovo.toString());
		modify.setRewardOptionList(rewardOptionList);
		
		ObjectMapper mapper = new ObjectMapper();
		String modifyToJson = mapper.writeValueAsString(modify);

		model.addAttribute("modifyRewardToJSON", modifyToJson);
		return "/ajax/getReward";
	}
	
	
	
	
}






























	