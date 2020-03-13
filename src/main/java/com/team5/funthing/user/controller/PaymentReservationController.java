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

import com.team5.funthing.user.api.kakaoPay.KakaoPayCancelVO;
import com.team5.funthing.user.api.kakaoPay.KakaoPayService;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.deliveryService.GetDeliveryAddressService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByEmailService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveService;
import com.team5.funthing.user.service.rewardService.GetRewardService;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@SessionAttributes("rewardSelection")
@Log
public class PaymentReservationController {

	@Setter(onMethod_ = { @Autowired })
	private KakaoPayService kakaoPayService;
	
	
	
	@Autowired
	private GetRewardService getRewardService;
	@Autowired
	private GetPaymentReserveService getPaymentReserveService;
	@Autowired
	private GetDeliveryAddressService getDeliveryAddressService;

	@Autowired
	private GetPaymentReserveListByEmailService getPaymentReserveListByEmailService;
	
	@Autowired
	private DeliveryAddressVO deliveryAddressVO;
	@Autowired
	private MemberVO memberVO;
	
	
	@RequestMapping(value = "/insertselectedReward.udo", method= RequestMethod.POST)
	public String insertselectedReward(	@RequestParam int projectNo,
										RedirectAttributes redirectAttributes,
										PaymentReserveVO prvo,
										Model model,
										HttpSession session) {
		
		@SuppressWarnings("unchecked")
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		
		if(selectedRewardList == null || selectedRewardList.isEmpty()) {
			redirectAttributes.addAttribute("msg", "리워드를 선택해주세요.");
			redirectAttributes.addAttribute("projectNo", projectNo);
			
			return "redirect:supportProject.udo";
		}
		
		
		session.setAttribute("paymentReserve", prvo);
		
		return "redirect:paymentReservation.udo";
	}
	
	@RequestMapping(value = "/paymentReservation.udo", method= RequestMethod.GET)
	public String paymentReservation(	HttpSession session,
										Model model,
										RewardVO rvo,
										DeliveryAddressVO davo) {
		
		@SuppressWarnings("unchecked")
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
	public String attemptPaymentReserveByKaKaoPay(	HttpSession session,
													PaymentReserveVO prvo,
													DeliveryAddressVO davo) {
		
		
		@SuppressWarnings("unchecked")
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		int projectNo = selectedRewardList.get(0).getReward().getProjectNo();
		
		session.removeAttribute("selectedRewardList");
		session.removeAttribute("paymentReserve");
		
		log.info("kakaoPay post............................................");
        return "redirect:" + kakaoPayService.kakaoPayReady(prvo, davo, selectedRewardList, projectNo);
	}
	
	@RequestMapping(value = "/kakaoPaySuccess.udo", method = RequestMethod.GET) 
	public String paymentSuccessResult(	@RequestParam("orderNoStr") String orderNoStr, 
										@RequestParam("pg_token") String pg_token, 
										Model model,
										PaymentReserveVO prvo,
										DeliveryAddressVO davo) { 
		log.info("kakaoPaySuccess get............................................");
		
		int orderNo = Integer.parseInt(orderNoStr);
		
		prvo.setOrderNo(orderNo);
		System.out.println(orderNo);
		prvo = getPaymentReserveService.getPaymentReserve(prvo);
		kakaoPayService.kakaoPayInfo(pg_token, orderNo);
		
		davo.setDeliveryAddressNo(prvo.getDeliveryAddressNo());
		davo = getDeliveryAddressService.getDeliveryAddress(davo);
		
		model.addAttribute("deliveryAddress", davo);
		model.addAttribute("paymentReserve", prvo);
		model.addAttribute("projectNo", prvo.getProjectNo());

		return "p-payment-result";
	}// 결제 내역 결과 보여주기
	
	
	@RequestMapping(value = "paymentReservationCheckList.udo", method = RequestMethod.POST )
	public String myPaymentReservationCheckList(HttpSession session,
												Model model, PaymentReserveVO prvo) {
		
		System.out.println("결제내역 보기 이동");
		
		memberVO = (MemberVO)session.getAttribute("memberSession");
		
		prvo.setEmail(memberVO.getEmail());
		
		
		List<PaymentReserveVO> paymentReserveList = getPaymentReserveListByEmailService.getPaymentReserveListByEmail(prvo);
		model.addAttribute("paymentReserveList", paymentReserveList);
		
		return "p-payment-reservation-check";
	}
	
	@RequestMapping(value = "paymentReservationDetail.udo", method = RequestMethod.POST )
	public String paymentReservationDetail(Model model, PaymentReserveVO prvo) {
		
		
		prvo = getPaymentReserveService.getPaymentReserve(prvo);
		
		System.out.println("결제내역 상세보기 이동");
		model.addAttribute("paymentReserve", prvo);
		
		deliveryAddressVO.setDeliveryAddressNo(prvo.getDeliveryAddressNo());
		deliveryAddressVO = getDeliveryAddressService.getDeliveryAddress(deliveryAddressVO);
		
		model.addAttribute("deliveryAddress", deliveryAddressVO);
		
		return "p-payment-reservation-detail";
	}
	
	
	@RequestMapping(value = "paymentCancel.udo", method = RequestMethod.POST)
	public String attemptPaymentReserveByKaKaoPay(	PaymentReserveVO prvo, DeliveryAddressVO davo) {
		kakaoPayService.kakaoPayCancel(prvo);
		
		return "redirect: paymentReservationCheckList.udo";
        
	}
	
	
	
	
}
