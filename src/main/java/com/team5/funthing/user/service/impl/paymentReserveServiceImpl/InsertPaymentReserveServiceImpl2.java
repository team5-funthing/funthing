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
public class InsertPaymentReserveServiceImpl2 implements InsertPaymentReserveService {
	
	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	@Autowired
	private PaymentReserveDAO paymentReserveDAO;
	@Autowired
	private RewardSelectionDAO rewardSelectionDAO;
	@Autowired
	private RewardDAO rewardDAO;
	@Autowired
	private RewardVO rewardVO;
	
	
	@Autowired
	private RewardOptionValueListVO rewardOptionValueListVO;
	
	@Override
	@Transactional
	public PaymentReserveVO insertPaymentReserve(	PaymentReserveVO prvo, 
													DeliveryAddressVO davo, 
													List<RewardSelectionVO> selectedRewardList, 
													int projectNo) throws NoRewardAmountException {
		
		

//		projectVO.setProjectNo(projectNo);
//		System.out.println("prvo.getFundingMoney() : " + prvo.getFundingMoney());
//		
//		projectVO.setFundingMoney(prvo.getFundingMoney());
//		projectDAO.updateProjectFundingMoney(ProjectVO);
		
		
		
		return prvo;
	}

}
