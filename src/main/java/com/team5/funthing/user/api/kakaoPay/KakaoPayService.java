package com.team5.funthing.user.api.kakaoPay;

import java.util.List;

import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.RewardSelectionVO;

public interface KakaoPayService {
	
	public String kakaoPayReady(PaymentReserveVO prvo, DeliveryAddressVO davo , List<RewardSelectionVO> selectedRewardList, int projectNo);
	public KakaoPayApprovalVO kakaoPayInfo(String pg_token, int orderNo);
	
}
