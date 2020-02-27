package com.team5.funthing.user.service.impl.homeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.HomeDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetMoneyPercentListService;

@Service
public class GetMoneyPercentListServiceImpl implements GetMoneyPercentListService {
	
	@Autowired
	private  HomeDAO homeDAO;

	
	@Override
	public List<ProjectVO> getMoneyPercentList(ProjectVO vo) {
		return homeDAO.getMoneyPercentList(vo);
	}


	@Override
	public List<ProjectVO> getMoneyPercentList2(ProjectVO vo) {
		return homeDAO.getMoneyPercentList2(vo);
	}


	@Override
	public List<ProjectVO> getMoneyPercentList3(ProjectVO vo) {
		return homeDAO.getMoneyPercentList3(vo);
	}

}
