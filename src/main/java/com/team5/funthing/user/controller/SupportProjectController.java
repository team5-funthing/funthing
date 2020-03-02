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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.RewardOptionVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.rewardOptionService.GetRewardOptionListService;
import com.team5.funthing.user.service.rewardSelectionService.GetRewardSelectionJoinListService;
import com.team5.funthing.user.service.rewardSelectionService.InsertRewardSelectionService;
import com.team5.funthing.user.service.rewardService.GetRewardListService;

@Controller
@SessionAttributes("reward")
public class SupportProjectController {

	@Autowired
	private GetRewardListService getRewardListService;
	@Autowired
	private GetRewardOptionListService getRewardOptionListService;
	@Autowired
	private InsertRewardSelectionService insertRewardSelectionService;
	@Autowired
	private GetRewardSelectionJoinListService getRewardSelectionJoinListService;
	
	@Autowired
	private RewardOptionVO rewardOptionVO;
	@Autowired
	private RewardSelectionVO rewardSelectionVO;
	
	
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
	
	@RequestMapping(value = "/paymentReservation.udo", method= RequestMethod.GET)
	public String paymentReservation(	@RequestParam int orderNo,
										Model model,
										RewardVO rvo,
										DeliveryAddressVO davo) {
		
		rewardSelectionVO.setOrderNo(orderNo);
		List<RewardSelectionVO> getRewardSelectionJoinList =  getRewardSelectionJoinListService.getRewardSelectionJoinList(rewardSelectionVO);

		for(RewardSelectionVO rs : getRewardSelectionJoinList) {
			System.out.println(rs.toString());
		}
		
		
		model.addAttribute("rewardSelectionJoinList", getRewardSelectionJoinList);
		
		return "f-payment-reservation";
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
	
	@RequestMapping(value = "/insertselectedReward.udo", method= RequestMethod.POST)
	public String insertselectedReward(	@RequestParam int projectNo,
										RedirectAttributes redirectAttributes,
										HttpSession session) {
		
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		
		if(selectedRewardList == null || selectedRewardList.isEmpty()) {
			redirectAttributes.addAttribute("msg", "리워드를 선택해주세요.");
			redirectAttributes.addAttribute("projectNo", projectNo);
			
			return "redirect:supportProject.udo";
		}
		int orderNo = insertRewardSelection(selectedRewardList);
		redirectAttributes.addAttribute("orderNo", orderNo);
		
		return "redirect:paymentReservation.udo";
	}
	
	
	
	
	public void setRewardOption(List<RewardVO> getRewardList){
		
		for(RewardVO reward: getRewardList) {
			rewardOptionVO.setRewardNo(reward.getRewardNo());
			reward.setRewardOptionList(getRewardOptionListService.getRewardOptionList(rewardOptionVO));
		}
	}
	public int insertRewardSelection(List<RewardSelectionVO> selectedRewardList) {
		int orderNo = 0;
		// 선택한 리워드들 rewardSelection 에 insert
		for(int i = 0; i < selectedRewardList.size(); i++) {
			
			if(i == 0 ) {
				rewardSelectionVO = insertRewardSelectionService.insertRewardSelection(selectedRewardList.get(0));
				orderNo = rewardSelectionVO.getOrderNo();
				System.out.println("처음으로 insert 했을때 생성했던 orderNo : " + orderNo);
				for(int n = 1; n < selectedRewardList.size(); n++) {
					selectedRewardList.get(n).setOrderNo(orderNo);
				}
			}else {
				rewardSelectionVO = insertRewardSelectionService.insertRewardSelection(selectedRewardList.get(i));
			}
			
		}
		
		return orderNo;
	}
	
	
	
	
	
	
	
	
}
