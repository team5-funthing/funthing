package com.team5.funthing.user.service.impl.memberActivityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetMemberActivityProjectListService;

@Service
public class GetMemberActivityProjectListServiceImpl implements GetMemberActivityProjectListService {

	@Autowired
	private MemberActivityDAO memberActivityDAO;
	
	@Override
	public MemberActivityVO getMemberActivityProjectList(MemberActivityVO vo) {
		return memberActivityDAO.getMemberActivityProjectList(vo);
	}

}
