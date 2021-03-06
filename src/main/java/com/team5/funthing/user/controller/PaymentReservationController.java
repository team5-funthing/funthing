package com.team5.funthing.user.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.team5.funthing.user.api.kakaoPay.KakaoPayService;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.NoRewardAmountException;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;
import com.team5.funthing.user.service.deliveryService.GetDeliveryAddressListByEmailService;
import com.team5.funthing.user.service.deliveryService.GetDeliveryAddressService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByEmailService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByProjectNoService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveService;
import com.team5.funthing.user.service.paymentReserveService.UpdateShipmentCompleteService;
import com.team5.funthing.user.service.rewardService.GetRewardService;
import com.team5.funthing.user.service.schedulingService.UpdateProjectDeadlineService;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@SessionAttributes("rewardSelection")
@Log
public class PaymentReservationController {

	@Setter(onMethod_ = { @Autowired })
	private KakaoPayService kakaoPayService;
	
	
	@Autowired
	private UpdateShipmentCompleteService updateShipmentCompleteService;
	@Autowired
	private GetRewardService getRewardService;
	@Autowired
	private GetPaymentReserveService getPaymentReserveService;
	@Autowired
	private GetDeliveryAddressService getDeliveryAddressService;
	@Autowired
	private GetDeliveryAddressListByEmailService getDeliveryAddressListByEmailService;

	@Autowired
	private GetPaymentReserveListByEmailService getPaymentReserveListByEmailService;
	
	@Autowired
	private DeliveryAddressVO deliveryAddressVO;
	@Autowired
	private MemberVO memberVO;
	
	@Autowired
	private GetPaymentReserveListByProjectNoService getPaymentReserveListByProjectNoService;
	
	@Autowired
	private UpdateProjectDeadlineService updateProjectDeadlineService;
	
	
	
	@RequestMapping(value = "/insertselectedReward.udo", method= RequestMethod.POST)
	public String insertselectedReward(	@RequestParam int projectNo,
										RedirectAttributes redirectAttributes,
										PaymentReserveVO prvo,
										Model model,
										HttpSession session) {
		
		@SuppressWarnings("unchecked")
		List<RewardSelectionVO> selectedRewardList = (List<RewardSelectionVO>)session.getAttribute("selectedRewardList");
		
		if(selectedRewardList == null || selectedRewardList.isEmpty()) {
			redirectAttributes.addAttribute("msg", "리워드를 입력해주시기 바랍니다.");
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
		MemberVO memberVO = (MemberVO)session.getAttribute("memberSession");
		
		List<DeliveryAddressVO> deliveryAddressList = getDeliveryAddressListByEmailService.getDeliveryAddressListByEmail(memberVO);
		
		if(!deliveryAddressList.isEmpty()) {
			model.addAttribute("deliveryAddressList", deliveryAddressList);
		}
		
		for(DeliveryAddressVO deliveryAddress : deliveryAddressList) {
			System.out.println("諛곗넚吏�紐� : " + deliveryAddress.getDeliveryAddressName() );
		}
		
		
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
													DeliveryAddressVO davo) throws NoRewardAmountException, URISyntaxException {
		
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
		prvo = getPaymentReserveService.getPaymentReserve(prvo);
		kakaoPayService.kakaoPayInfo(pg_token, orderNo);
		
		davo.setDeliveryAddressNo(prvo.getDeliveryAddressNo());
		davo = getDeliveryAddressService.getDeliveryAddress(davo);
		
		model.addAttribute("deliveryAddress", davo);
		model.addAttribute("paymentReserve", prvo);
		model.addAttribute("projectNo", prvo.getProjectNo());

		return "p-payment-result";
	}
	
	
	@RequestMapping(value = "paymentReservationCheckList.udo", method = RequestMethod.POST )
	public String myPaymentReservationCheckList(HttpSession session,
												Model model, PaymentReserveVO prvo) {

		memberVO = (MemberVO)session.getAttribute("memberSession");
		prvo.setEmail(memberVO.getEmail());
		
		
		List<PaymentReserveVO> paymentReserveList = getPaymentReserveListByEmailService.getPaymentReserveListByEmail(prvo);
		model.addAttribute("paymentReserveList", paymentReserveList);
		
		return "p-payment-reservation-check";
	}
	
	@RequestMapping(value = "paymentReservationDetail.udo", method = RequestMethod.POST )
	public String paymentReservationDetail(Model model, PaymentReserveVO prvo) {
		
		
		prvo = getPaymentReserveService.getPaymentReserve(prvo);
		
		
		model.addAttribute("paymentReserve", prvo);
		
		deliveryAddressVO.setDeliveryAddressNo(prvo.getDeliveryAddressNo());
		deliveryAddressVO = getDeliveryAddressService.getDeliveryAddress(deliveryAddressVO);
		
		model.addAttribute("deliveryAddress", deliveryAddressVO);
		
		return "p-payment-reservation-detail";
	}
	
	
	@RequestMapping(value = "paymentCancel.udo", method = RequestMethod.POST)
	public String attemptPaymentReserveByKaKaoPay(	PaymentReserveVO prvo, DeliveryAddressVO davo) throws URISyntaxException {
		kakaoPayService.kakaoPayCancel(prvo);
		
		return "redirect: paymentReservationCheckList.udo";
        
	}
	
	
	
	@RequestMapping(value="selectDeliveryAddressCheck.udo", method = RequestMethod.POST, produces ="application/text; charset=utf8")
	@ResponseBody
	public String selectCreatorCheck(@RequestBody DeliveryAddressVO davo) throws JsonProcessingException {

		davo = getDeliveryAddressService.getDeliveryAddress(davo);
		
		System.out.println(davo.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		String selectedCreatorToJSON = mapper.writeValueAsString(davo);
	
		return selectedCreatorToJSON;
	}
	
	
	@RequestMapping(value = "rewardSupportCheck.udo", method = RequestMethod.GET)
	public String rewardOrderCheck(	HttpSession session, PaymentReserveVO prvo, Model model) {
		
		PaymentReserveVO tempVO = (PaymentReserveVO)session.getAttribute("redirectPrvo");
		

		if(tempVO != null) {
			prvo = tempVO;
			session.removeAttribute("redirectPrvo");
		}
		
		List<PaymentReserveVO> paymentReserveList = getPaymentReserveListByProjectNoService.getPaymentReserveListByProjectNo(prvo);
		
		if(!paymentReserveList.isEmpty()) {
			model.addAttribute("project", paymentReserveList.get(0).getProject());
			model.addAttribute("paymentReserveList", paymentReserveList);
		}
		
		System.out.println(prvo.getProjectNo());
		
		return "p-reward-support-check";
	}
	
	
	@RequestMapping(value = "updateShipmentComplete.udo", method = RequestMethod.POST)
	public String updateShipmentComplete(HttpSession session, PaymentReserveVO prvo, Model model) {
		
		
		updateShipmentCompleteService.updateShipmentComplete(prvo);
		
		session.setAttribute("redirectPrvo", prvo);
		
		return "redirect: rewardSupportCheck.udo";
	}
	


	@Scheduled(cron= "1 0 0 * * ?")
	public void updateProjectDeadlineService() throws URISyntaxException {
		System.out.println("�봽濡쒖젥�듃 留덇컧 �뒪耳�以꾨윭 �떎�뻾");
		List<PaymentReserveVO> failedProjectList = updateProjectDeadlineService.updateProjectDeadline();
		
		for(PaymentReserveVO prvo :failedProjectList) {
			kakaoPayService.kakaoPayCancel(prvo);
		}
		
		System.out.println("�봽濡쒖젥�듃 留덇컧 �뒪耳�以꾨윭 醫낅즺");
	}
	
	
	
	
	
	
	
	
	
	
}
