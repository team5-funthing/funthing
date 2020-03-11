package com.team5.funthing.user.service.impl.memberActivityServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.MemberActivityDAO;
import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.service.memberActivityService.GetReportProjectNoListService;

@Service
public class GetReportProjectNoListServiceImpl implements GetReportProjectNoListService {

	@Autowired
	private MemberActivityDAO memberActivityDAO;
	
	@Override
	public List<MemberActivityVO> getReportProjectNoList(MemberActivityVO vo) {
		return memberActivityDAO.getReportProjectNoList(vo);
	}

}
