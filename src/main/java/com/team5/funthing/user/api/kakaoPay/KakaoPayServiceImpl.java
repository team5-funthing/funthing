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
	@Transactional
	public String kakaoPayReady(PaymentReserveVO prvo, 
			DeliveryAddressVO davo, 
			List<RewardSelectionVO> selectedRewardList, 
			int projectNo) {

		String orderNoStr = null;
		String orderEmail = null;
		String orderItems = null;
		String quantityStr = null; // 총갯수
		String totalAmountStr = null; // 리워드 + 배송비
		String taxFreeAmount = "0";

		//배송지 추가
		davo = deliveryAddressDAO.insertDeleveryAddress(davo);
		prvo.setDeliveryAddressNo(davo.getDeliveryAddressNo());
		prvo.setProjectNo(projectNo);

		System.out.println("프로젝트넘버 체크 : " + prvo.toString());

		//결제예약 테이블 추가
		prvo = paymentReserveDAO.insertPaymentReserve(prvo);
		int orderNo = prvo.getOrderNo();


		//리워드선택(하나의 결제예약번호로 묶여진) 목록 추가
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
				throw new NoRewardAmountException(); // 남아있는 수량이 없거나 주문량 보다 적을 때 예외 발생
			}
			rewardSelectionDAO.updateRewardAmount(rs);

			//선택한 리워드의 수량에 따른 옵션 목록 추가
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

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "18d8019e9d49a2411a907a3027792bfd");
		headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		params.add("cid", "TC0ONETIME");

		params.add("partner_order_id", orderNoStr); // orderNo 
		params.add("partner_user_id", orderEmail); // 회원 이메일 (id)
		params.add("item_name", orderItems); // 프로젝트명
		params.add("quantity", quantityStr); // 리워드 총 수량
		params.add("total_amount", totalAmountStr); // 총 금액
		params.add("tax_free_amount", taxFreeAmount);
		params.add("approval_url", "http://localhost:8080/funthing/kakaoPaySuccess.udo?orderNoStr=" + orderNoStr);
		params.add("cancel_url",  "http://localhost:8080/funthing/kakaoPayCancel.udo");
		params.add("fail_url", "http://localhost:8080/funthing/kakaoPaySuccessFail.udo");

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		try {
			kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
			log.info("" + kakaoPayReadyVO);
			return kakaoPayReadyVO.getNext_redirect_pc_url();

		}catch(RestClientException e){
			System.out.println("RestClientException 발생");
			e.printStackTrace();
		}catch(URISyntaxException e) {
			System.out.println("URISyntaxException 발생");
			e.printStackTrace();
		}

		return "failedUrl로 가야함"; // redirect Url 실패 시

	}


	@Override	
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token, int orderNo) {

		log.info("KakaoPayInfoVO............................................");
		log.info("-----------------------------");

		paymentReserveVO.setOrderNo(orderNo);
		paymentReserveVO = paymentReserveDAO.getPaymentReserve(paymentReserveVO);	

		System.out.println("확인테스트 : " + paymentReserveVO.toString());


		RestTemplate restTemplate = new RestTemplate();

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "18d8019e9d49a2411a907a3027792bfd");
		headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		System.out.println(kakaoPayReadyVO.getTid());

		// 서버로 요청할 Body
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


			System.out.println("이게 실행돼야 함 " + paymentReserveVO.toString());

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
	@Transactional
	public void kakaoPayCancel(PaymentReserveVO prvo) {

		RestTemplate restTemplate = new RestTemplate();
		
		prvo = paymentReserveDAO.getPaymentReserve(prvo);
		
		System.out.println(prvo.toString());
		
		projectVO.setProjectNo(prvo.getProjectNo());
		projectVO.setFundingMoney(prvo.getFundingMoney());
		
		

		// 서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "18d8019e9d49a2411a907a3027792bfd");
		headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

		// 서버로 요청할 Body
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", prvo.getTid());
		params.add("cancel_amount", String.valueOf(prvo.getFundingMoney() + prvo.getShippingFee()));
		params.add("cancel_tax_free_amount", "0");

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		try {

			kakaoPayCancelVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/cancel"), body, KakaoPayCancelVO.class);
			log.info("" + kakaoPayCancelVO);
			
			System.out.println("취소승인 날짜 : " + kakaoPayCancelVO.getCanceled_at());


			prvo.setAid(kakaoPayCancelVO.getAid());
			prvo.setTid(kakaoPayCancelVO.getTid());
			prvo.setCanceledDate(kakaoPayCancelVO.getCanceled_at());
			
			System.out.println("취소승인 날짜 옮겨담기: " + prvo.getCanceledDate());
			
			paymentReserveDAO.updateKaKaoPayCancelResult(prvo);

//			프로젝트 펀딩머니 수정, 
			projectDAO.updateProjectAfterPaymentCancel(projectVO);
//			리워드 수량 복구

			
			
			for(RewardSelectionVO rewardSelection : prvo.getRewardSelectionList()) {
				rewardVO.setRewardNo(rewardSelection.getRewardNo());
				rewardVO.setRewardAmount(rewardSelection.getOrderAmount());
				rewardDAO.updateRewardReturnQuantityAfterCancel(rewardVO);
			}
			

		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}


}



















