package com.team5.funthing.user.service.impl.memberActivityServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetMemberActivityListService;
@Service
public class GetMemberActivityListServiceImpl implements GetMemberActivityListService {

	@Autowired
	MemberActivityDAO  DAO;
	


	@Override
	public MemberActivityVO getMemberActivityMemberList(MemberActivityVO vo) {
		DAO.getMemberActivityMemberList(vo);
		return vo;
	}


	@Override
	public MemberActivityVO getMemberActivityProjectList(MemberActivityVO vo) {
		DAO.getMemberActivityProjectList(vo);
		return vo;
		
	}


	@Override
	public List<MemberActivityVO> getLikeProjectnoList(MemberActivityVO vo) {
		// TODO Auto-generated method stub
		return DAO.getLikeProjectnoList(vo);
	}


	@Override
	public List<MemberActivityVO> getReportProjectnoList(MemberActivityVO vo) {
		// TODO Auto-generated method stub
		return DAO.getReportProjectnoList(vo);
	}


	@Override
	public List<MemberActivityVO> getReservationProjectnoList(MemberActivityVO vo) {
		// TODO Auto-generated method stub
		return DAO.getReservationProjectnoList(vo);
	}	
}
