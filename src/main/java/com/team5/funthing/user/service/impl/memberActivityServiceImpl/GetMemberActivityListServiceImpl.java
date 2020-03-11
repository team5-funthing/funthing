package com.team5.funthing.user.service.impl.memberActivityServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetMemberActivityListService;
@Service
public class GetMemberActivityListServiceImpl implements GetMemberActivityListService {

	@Autowired
	MemberActivityDAO  memberActivityDAO;

	@Override
	public MemberActivityVO getMemberActivityMemberList(MemberActivityVO vo) {
		memberActivityDAO.getMemberActivityMemberList(vo);
		return vo;
	}

}
