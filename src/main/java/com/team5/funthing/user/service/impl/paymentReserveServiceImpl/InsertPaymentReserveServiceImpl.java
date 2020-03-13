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
		
		davo = deliveryAddressDAO.insertDeleveryAddress(davo);
		prvo.setDeliveryAddressNo(davo.getDeliveryAddressNo());
		prvo.setProjectNo(projectNo);
		
		
						
		prvo = paymentReserveDAO.insertPaymentReserve(prvo);
		int orderNo = prvo.getOrderNo();
		
		
		for(RewardSelectionVO rs : selectedRewardList) {
			
			rs.setOrderNo(orderNo);
			rs = rewardSelectionDAO.insertRewardSelection(rs);
			
			rs.setRewardOptionValue(new ArrayList<RewardOptionValueListVO>());
			rewardOptionValueListVO.setSelectRewardNo(rs.getSelectRewardNo());
			
			rewardVO.setRewardNo(rs.getRewardNo());
			rewardVO = rewardDAO.getReward(rewardVO);
			
			int amount = rewardVO.getRewardAmount();
			
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

		
		
		
//=====================================================================================	

		projectVO.setProjectNo(projectNo);

		
		projectVO.setFundingMoney(prvo.getFundingMoney());
		projectDAO.updateProjectFundingMoney(projectVO);
		
		
		return prvo;
	}

}
