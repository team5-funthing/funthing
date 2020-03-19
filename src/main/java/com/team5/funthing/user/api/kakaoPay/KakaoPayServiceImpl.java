package com.team5.funthing.user.api.kakaoPay;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.team5.funthing.user.model.dao.DeliveryAddressDAO;
import com.team5.funthing.user.model.dao.PaymentReserveDAO;
import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.dao.RewardDAO;
import com.team5.funthing.user.model.dao.RewardSelectionDAO;
import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.NoRewardAmountException;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.model.vo.RewardOptionValueListVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;
import com.team5.funthing.user.model.vo.RewardVO;

import lombok.extern.java.Log;


@Service
@Log
public class KakaoPayServiceImpl implements KakaoPayService {

	private static final String HOST = "https://kapi.kakao.com";

	private KakaoPayReadyVO kakaoPayReadyVO;
	private KakaoPayApprovalVO kakaoPayApprovalVO;
	private KakaoPayCancelVO kakaoPayCancelVO;

	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	@Autowired
	private RewardSelectionDAO rewardSelectionDAO;
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private RewardDAO rewardDAO;
	@Autowired
	private RewardVO rewardVO;

	@Autowired
	private RewardOptionValueListVO rewardOptionValueListVO;
	@Autowired
	private ProjectVO projectVO;
	@Autowired
	private PaymentReserveVO paymentReserveVO;



	@Override
	@Transactional(rollbackFor={RestClientException.class, URISyntaxException.class, HttpClientErrorException.class})
	public String kakaoPayReady(PaymentReserveVO prvo, 
								DeliveryAddressVO davo, 
								List<RewardSelectionVO> selectedRewardList, 
								int projectNo) throws NoRewardAmountException, URISyntaxException{

		String orderNoStr = null;
		String orderEmail = null;
		String orderItems = null;
		String quantityStr = null; 
		String totalAmountStr = null;
		String taxFreeAmount = "0";

		System.out.println("============결제전 배송 정보 확인==================");
		System.out.println(davo.toString());
		System.out.println("============================================");
		try {
			
			if(davo.getDeliveryAddressNo() == -1 ) {
				davo = deliveryAddressDAO.insertDeleveryAddress(davo);

			}else {
				deliveryAddressDAO.updateDeliveryAddress(davo);
			}

			prvo.setDeliveryAddressNo(davo.getDeliveryAddressNo());
			prvo.setProjectNo(projectNo);

			prvo = paymentReserveDAO.insertPaymentReserve(prvo);
			int orderNo = prvo.getOrderNo();


			int cnt = -1;
			int totalAmount = 0;
			for(RewardSelectionVO rs : selectedRewardList) {

				totalAmount += rs.getOrderAmount();


				rs.setOrderNo(orderNo);
				rs = rewardSelectionDAO.insertRewardSelection(rs);

				rs.setRewardOptionValue(new ArrayList<RewardOptionValueListVO>());
				rewardOptionValueListVO.setSelectRewardNo(rs.getSelectRewardNo());

				rewardVO.setRewardNo(rs.getRewardNo());
				rewardVO = rewardDAO.getReward(rewardVO);
				int amount = rewardVO.getRewardAmount();

				if( orderItems == null ) {
					orderItems = rewardVO.getRewardName();
				}
				cnt++;


				if(amount <= 0 || amount < rs.getOrderAmount()) {
					throw new NoRewardAmountException();
				}
				rewardSelectionDAO.updateRewardAmount(rs);

				for(String value: rs.getRewardOptionValueList()) {
					rewardOptionValueListVO.setRewardOptionValue(value);
					rs.getRewardOptionValue().add(rewardOptionValueListVO);
				}
				rewardSelectionDAO.insertRewardSelectionList(rs.getRewardOptionValue());
			}

			projectVO.setProjectNo(projectNo);
			projectVO.setFundingMoney(prvo.getFundingMoney());
			projectDAO.updateProjectFundingMoney(projectVO);


			if(cnt > 0) {
				orderItems = orderItems + " 외 " + cnt + "개";
			}

			orderNoStr = String.valueOf(orderNo);
			orderEmail = prvo.getEmail();
			quantityStr = String.valueOf(totalAmount);
			totalAmountStr = String.valueOf(prvo.getFundingMoney() + prvo.getShippingFee());

			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "KakaoAK " + "18d8019e9d49a2411a907a3027792bfd");
			headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
			headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

			params.add("cid", "TC0ONETIME");

			params.add("partner_order_id", orderNoStr); 
			params.add("partner_user_id", orderEmail);
			params.add("item_name", orderItems);
			params.add("quantity", quantityStr); 
			params.add("total_amount", totalAmountStr);
			params.add("tax_free_amount", taxFreeAmount);
//			params.add("approval_url", "http://localhost:8080/funthing/kakaoPaySuccess.udo?orderNoStr=" + orderNoStr);
//			params.add("cancel_url",  "http://localhost:8080/funthing/kakaoPayCancel.udo");
//			params.add("fail_url", "http://localhost:8080/funthing/kakaoPaySuccessFail.udo");
			params.add("approval_url", "http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/funthing/kakaoPaySuccess.udo?orderNoStr=" + orderNoStr);
			params.add("cancel_url",  "http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/funthing/kakaoPayCancel.udo");
			params.add("fail_url", "http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/funthing/kakaoPaySuccessFail.udo");


			HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);			
			
			
			kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
			log.info("" + kakaoPayReadyVO);
			
			
			return kakaoPayReadyVO.getNext_redirect_pc_url();
			
		} catch (RestClientException e) {
			throw new RestClientException(e.getMessage());
		} catch (URISyntaxException e) {
			throw new URISyntaxException(e.getInput(), e.getReason());
		}

	}


	@Override	
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token, int orderNo) {

		log.info("KakaoPayInfoVO............................................");
		log.info("-----------------------------");

		paymentReserveVO.setOrderNo(orderNo);
		paymentReserveVO = paymentReserveDAO.getPaymentReserve(paymentReserveVO);	


		RestTemplate restTemplate = new RestTemplate();


		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "18d8019e9d49a2411a907a3027792bfd");
		headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");


		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", kakaoPayReadyVO.getTid());
		params.add("partner_order_id", String.valueOf(paymentReserveVO.getOrderNo()));
		params.add("partner_user_id", paymentReserveVO.getEmail());
		params.add("pg_token", pg_token);
		params.add("total_amount", String.valueOf(paymentReserveVO.getFundingMoney() + paymentReserveVO.getShippingFee()));

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		try {

			kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
			log.info("" + kakaoPayApprovalVO);

			paymentReserveVO.setAid(kakaoPayApprovalVO.getAid());
			paymentReserveVO.setTid(kakaoPayApprovalVO.getTid());
			paymentReserveVO.setPaymentReserveDate(kakaoPayApprovalVO.getApproved_at());
			paymentReserveVO.setPaymentOption(kakaoPayApprovalVO.getPayment_method_type());


			paymentReserveDAO.updateKakaoPayResultSet(paymentReserveVO);

			return kakaoPayApprovalVO;


		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}



	@Override
	@Transactional(rollbackFor={RestClientException.class, URISyntaxException.class})
	public void kakaoPayCancel(PaymentReserveVO prvo) throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		
		prvo = paymentReserveDAO.getPaymentReserve(prvo);
		
	
		
		projectVO.setProjectNo(prvo.getProjectNo());
		projectVO.setFundingMoney(prvo.getFundingMoney());
		
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "18d8019e9d49a2411a907a3027792bfd");
		headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", prvo.getTid());
		params.add("cancel_amount", String.valueOf(prvo.getFundingMoney() + prvo.getShippingFee()));
		params.add("cancel_tax_free_amount", "0");

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		try {

			kakaoPayCancelVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/cancel"), body, KakaoPayCancelVO.class);
			log.info("" + kakaoPayCancelVO);
			

			prvo.setAid(kakaoPayCancelVO.getAid());
			prvo.setTid(kakaoPayCancelVO.getTid());
			prvo.setCanceledDate(kakaoPayCancelVO.getCanceled_at());
			

			paymentReserveDAO.updateKaKaoPayCancelResult(prvo);

			projectDAO.updateProjectAfterPaymentCancel(projectVO);


			
			
			for(RewardSelectionVO rewardSelection : prvo.getRewardSelectionList()) {
				rewardVO.setRewardNo(rewardSelection.getRewardNo());
				rewardVO.setRewardAmount(rewardSelection.getOrderAmount());
				rewardDAO.updateRewardReturnQuantityAfterCancel(rewardVO);
			}
			

		} catch (RestClientException e) {
			throw new RestClientException(e.getMessage());
		} catch (URISyntaxException e) {
			throw new URISyntaxException(e.getInput(), e.getReason());
		}

	}


}



















