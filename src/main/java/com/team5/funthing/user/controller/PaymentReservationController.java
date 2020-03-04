package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.deliveryService.InsertDeliveryAddressService;
import com.team5.funthing.user.service.paymentReserveService.InsertPaymentReserveService;
import com.team5.funthing.user.service.rewardSelectionService.InsertRewardSelectionService;
import com.team5.funthing.user.service.rewardService.GetRewardService;

@Controller
@SessionAttributes("rewardSelection")
public class PaymentReservationController {
	
	@Autowired
	private InsertRewardSelectionService insertRewardSelectionService;
	
	@Autowired
	private RewardSelectionVO rewardSelectionVO;
	
	@Autowired
	private InsertDeliveryAddressService insertDeliveryAddressService;
	@Autowired
	private InsertPaymentReserveService insertPaymentReserveService;
	
	
	@Autowired
	private GetRewardService getRewardService;
	
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
		

		return "redirect:paymentReservation.udo";
	}
	
	public void insertRewardSelection(List<RewardSelectionVO> selectedRewardList, int orderNo) {
		// 선택한 리워드들 rewardSelection 에 insert
		for(RewardSelectionVO rs : selectedRewardList) {
			rs.setOrderNo(orderNo);
			insertRewardSelectionService.insertRewardSelection(rs);
		}
	}
	
	@RequestMapping(value = "/paymentReservation.udo", method= RequestMethod.GET)
	public String paymentReservation(	HttpSession session,
										Model model,
										RewardVO rvo,
										DeliveryAddressVO davo) {
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");

		for(RewardSelectionVO rs : selectedRewardList) {
			System.out.println("1 : " + rs.toString());
			
			getRewardService.getReward(rvo);
			rvo.setRewardNo(rs.getRewardNo());
			rvo = getRewardService.getReward(rvo);
			rs.setReward(rvo);
			
		}
		
		for(RewardSelectionVO rs : selectedRewardList) {
			System.out.println("2 : " + rs.toString());
		}
		
		model.addAttribute("rewardSelectionJoinList", selectedRewardList);
		
		return "f-payment-reservation";
	}	
	
	@RequestMapping(value = "/paymentReserve.udo", method = RequestMethod.POST)
	public String paymentReserve(	HttpSession session,
									RedirectAttributes redirectAttributes,
									PaymentReserveVO prvo,
									DeliveryAddressVO davo) {
		
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		
		int projectNo = selectedRewardList.get(0).getReward().getProjectNo();
		
		davo = insertDeliveryAddressService.insertDeliveryAddress(davo);
		prvo.setDeliveryAddressNo(davo.getDeliveryAddressNo());
		prvo = insertPaymentReserveService.insertPaymentReserve(prvo);
		
		int orderNo = prvo.getOrderNo();

		insertRewardSelection(selectedRewardList, orderNo);
		
		
		redirectAttributes.addAttribute("orderNo", orderNo);
		redirectAttributes.addAttribute("projectNo", projectNo);
		
		return "redirect:paymentResult.udo";
	}
	
	
	
	@RequestMapping(value = "/paymentResult.udo", method = RequestMethod.GET)
	public String paymentReserve(	@RequestParam int orderNo,
									@RequestParam int projectNo,
									Model model) {
		
		
		
		
		System.out.println("결제 완료 페이지 들어갑니다.");
		model.addAttribute("projectNo", projectNo);
		
		return "p-payment-result";
	}
	
}
