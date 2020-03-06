package com.team5.funthing.user.service.impl.paymentReserveServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.team5.funthing.user.service.paymentReserveService.InsertPaymentReserveService;

@Service
public class InsertPaymentReserveServiceImpl implements InsertPaymentReserveService {

		
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
	
	@Override
	@Transactional
	public PaymentReserveVO insertPaymentReserve(	PaymentReserveVO prvo, 
													DeliveryAddressVO davo , 
													List<RewardSelectionVO> selectedRewardList, 
													int projectNo) throws NoRewardAmountException {
		
		//배송지 추가
		davo = deliveryAddressDAO.insertDeleveryAddress(davo);
		prvo.setDeliveryAddressNo(davo.getDeliveryAddressNo());
		
		//결제예약 테이블 추가
		prvo = paymentReserveDAO.insertPaymentReserve(prvo);
		int orderNo = prvo.getOrderNo();
		
		System.out.println("==========================================");
		//리워드선택(하나의 결제예약번호로 묶여진) 목록 추가
		for(RewardSelectionVO rs : selectedRewardList) {
			
			System.out.println(rs);
			
			
			rs.setOrderNo(orderNo);
			rs = rewardSelectionDAO.insertRewardSelection(rs);
			
			rs.setRewardOptionValue(new ArrayList<RewardOptionValueListVO>());
			rewardOptionValueListVO.setSelectRewardNo(rs.getSelectRewardNo());
			
			rewardVO.setRewardNo(rs.getRewardNo());
			rewardVO = rewardDAO.getReward(rewardVO);
			
			int amount = rewardVO.getRewardAmount();
			
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
		System.out.println("==========================================");
		
		//프로젝트에 펀딩 금액 반영.
		projectVO.setProjectNo(projectNo);
		
		System.out.println("prvo.getFundingMoney() : " + prvo.getFundingMoney());
		
		projectVO.setFundingMoney(prvo.getFundingMoney());
		projectDAO.updateProjectFundingMoney(projectVO);
		
		
		
		return prvo;
	}

}
