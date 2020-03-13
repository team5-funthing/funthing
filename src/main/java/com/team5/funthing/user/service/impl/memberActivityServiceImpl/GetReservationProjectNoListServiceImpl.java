package com.team5.funthing.user.service.impl.memberActivityServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetReservationProjectNoListService;

@Service
public class GetReservationProjectNoListServiceImpl implements GetReservationProjectNoListService{

	@Autowired
	private MemberActivityDAO memberActivityDAO;
	
	@Override
	public List<MemberActivityVO> getReservationProjectNoList(MemberActivityVO vo) {
		return memberActivityDAO.getReservationProjectNoList(vo);
	}	
	
}
