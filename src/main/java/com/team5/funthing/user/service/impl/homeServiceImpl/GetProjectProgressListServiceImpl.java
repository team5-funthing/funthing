package com.team5.funthing.user.service.impl.homeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.HomeDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetProjectProgressListService;

@Service
public class GetProjectProgressListServiceImpl implements GetProjectProgressListService {
	
	@Autowired
	private  HomeDAO homeDAO;

	
	@Override
	public List<ProjectVO> getProjectProgressList(ProjectVO vo) {
		// TODO Auto-generated method stub
		return homeDAO.getProjectProgressList(vo);
	}


	@Override
	public List<ProjectVO> getProjectProgressList2(ProjectVO vo) {
		// TODO Auto-generated method stub
		return homeDAO.getProjectProgressList2(vo);
	}


	@Override
	public List<ProjectVO> getProjectProgressList3(ProjectVO vo) {
		// TODO Auto-generated method stub
		return homeDAO.getProjectProgressList3(vo);
	}


}
