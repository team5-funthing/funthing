package com.team5.funthing.user.service.impl.ProjectAskMessageImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAskMessageDAO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.ProjectAskMessageService.GetMakerMemberCreatorService;

@Service
public class GetMakerMemberCreatorServiceImpl implements GetMakerMemberCreatorService {
	
	@Autowired
	private ProjectAskMessageDAO projectAskMessageDAO;
	
	@Override
	public MemberVO getMakerMemberCreator(MemberVO vo) {
		return projectAskMessageDAO.getMakerMemberCreator(vo);
	}

}
