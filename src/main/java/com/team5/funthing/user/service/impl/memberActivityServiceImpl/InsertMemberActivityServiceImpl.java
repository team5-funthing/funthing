package com.team5.funthing.user.service.impl.memberActivityServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.InsertMemberActivityService;
@Service
public class InsertMemberActivityServiceImpl implements InsertMemberActivityService {

	@Autowired
	MemberActivityDAO DAO;
	@Override
	public void insertMemberActivity(MemberActivityVO vo) {
		
		DAO.insertMemberActivity(vo);
	}

}
