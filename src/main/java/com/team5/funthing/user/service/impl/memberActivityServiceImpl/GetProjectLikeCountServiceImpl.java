package com.team5.funthing.user.service.impl.memberActivityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetProjectLikeCountService;

@Service
public class GetProjectLikeCountServiceImpl implements GetProjectLikeCountService {

	@Autowired
	private MemberActivityDAO memberActivityDAO;
	
	@Override
	public int getProjectLikeCount(MemberActivityVO vo) {
		return memberActivityDAO.getProjectLikeCount(vo);
	}

}
