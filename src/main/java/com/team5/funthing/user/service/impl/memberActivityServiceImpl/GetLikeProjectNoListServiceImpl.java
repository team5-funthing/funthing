package com.team5.funthing.user.service.impl.memberActivityServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetLikeProjectNoListService;

@Service
public class GetLikeProjectNoListServiceImpl implements GetLikeProjectNoListService {

	@Autowired
	private MemberActivityDAO memberActivityDAO;
	
	@Override
	public List<MemberActivityVO> getLikeProjectNoList(MemberActivityVO vo) {
		return memberActivityDAO.getLikeProjectNoList(vo);
	}

}
