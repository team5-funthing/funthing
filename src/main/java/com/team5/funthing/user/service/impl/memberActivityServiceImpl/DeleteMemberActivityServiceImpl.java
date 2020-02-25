package com.team5.funthing.user.service.impl.memberActivityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.DeleteMemberActivityService;
@Service
public class DeleteMemberActivityServiceImpl implements DeleteMemberActivityService {
	@Autowired
	MemberActivityDAO DAO;
	
	@Override
	public void deleteMemberActivity(MemberActivityVO vo) {
	
		
		DAO.deleteMemberActivity(vo);
	}

}
