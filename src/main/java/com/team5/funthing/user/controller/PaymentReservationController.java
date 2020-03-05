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
import com.team5.funthing.user.model.vo.FundingAdditionsVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.deliveryService.GetDeliveryAddressService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveService;
import com.team5.funthing.user.service.paymentReserveService.InsertPaymentReserveService;
import com.team5.funthing.user.service.rewardService.GetRewardService;

@Controller
@SessionAttributes("rewardSelection")
public class PaymentReservationController {
	
	@Autowired
	private InsertPaymentReserveService insertPaymentReserveService;
	@Autowired
	private GetRewardService getRewardService;
	@Autowired
	private GetPaymentReserveService getPaymentReserveService;
	@Autowired
	private GetDeliveryAddressService getDeliveryAddressService;
	
	
	
	
	@RequestMapping(value = "/insertselectedReward.udo", method= RequestMethod.POST)
	public String insertselectedReward(	@RequestParam int projectNo,
										RedirectAttributes redirectAttributes,
										FundingAdditionsVO favo,
										HttpSession session) {
		
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		
		if(selectedRewardList == null || selectedRewardList.isEmpty()) {
			redirectAttributes.addAttribute("msg", "리워드를 선택해주세요.");
			redirectAttributes.addAttribute("projectNo", projectNo);
			
			return "redirect:supportProject.udo";
		}
		
		session.setAttribute("fundingAdditions", favo);

		return "redirect:paymentReservation.udo";
	}
	
	@RequestMapping(value = "/paymentReservation.udo", method= RequestMethod.GET)
	public String paymentReservation(	HttpSession session,
										Model model,
										RewardVO rvo,
										DeliveryAddressVO davo) {
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");

		for(RewardSelectionVO rs : selectedRewardList) {
			
			getRewardService.getReward(rvo);
			rvo.setRewardNo(rs.getRewardNo());
			rvo = getRewardService.getReward(rvo);
			rs.setReward(rvo);
			
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
		
		prvo = insertPaymentReserveService.insertPaymentReserve(prvo, davo, selectedRewardList);
		int orderNo = prvo.getOrderNo();
		
		session.removeAttribute("selectedRewardList");
		
		redirectAttributes.addAttribute("orderNo", orderNo);
		redirectAttributes.addAttribute("projectNo", projectNo);
		
		return "redirect:paymentResult.udo";
	}
	
	
	@RequestMapping(value = "/paymentResult.udo", method = RequestMethod.GET)
	public String paymentReserve(	@RequestParam int orderNo,
									@RequestParam int projectNo,
									PaymentReserveVO prvo,
									DeliveryAddressVO davo,
									Model model) {
		
		prvo.setOrderNo(orderNo);
		prvo = getPaymentReserveService.getPaymentReserve(prvo);
		davo.setDeliveryAddressNo(prvo.getDeliveryAddressNo());
		davo = getDeliveryAddressService.getDeliveryAddress(davo);

		model.addAttribute("deliveryAddress", davo);
		model.addAttribute("paymentReserve", prvo);
		model.addAttribute("projectNo", projectNo);
		
		return "p-payment-result";
	}
	
}
