package com.team5.funthing.user.service.impl.homeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.HomeDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetLikeCountListService;

@Service
public class GetLikeCountListServiceImpl implements GetLikeCountListService {
	
	@Autowired
	private  HomeDAO homeDAO;

	@Override
	public List<ProjectVO> getLikeCountList(ProjectVO vo) {
		// TODO Auto-generated method stub
		return homeDAO.getLikeCountList(vo);
	}

	@Override
	public List<ProjectVO> getLikeCountList2(ProjectVO vo) {
		// TODO Auto-generated method stub
		return homeDAO.getLikeCountList2(vo);
	}

	@Override
	public List<ProjectVO> getLikeCountList3(ProjectVO vo) {
		// TODO Auto-generated method stub
		return homeDAO.getLikeCountList3(vo);
	}

}
