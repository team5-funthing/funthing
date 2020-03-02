package com.team5.funthing.user.service.impl.homeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.HomeDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetDeadLineListService;

@Service
public class GetDeadLineListServiceImpl implements GetDeadLineListService {
	
	@Autowired
	private  HomeDAO homeDAO;
	
	@Override
	public List<ProjectVO> getDeadLineList(ProjectVO vo) {
		return homeDAO.getDeadLineList(vo);
	}

	@Override
	public List<ProjectVO> getDeadLineList2(ProjectVO vo) {
		return homeDAO.getDeadLineList2(vo);
	}

	@Override
	public List<ProjectVO> getDeadLineList3(ProjectVO vo) {
		return homeDAO.getDeadLineList3(vo);
	}

}
