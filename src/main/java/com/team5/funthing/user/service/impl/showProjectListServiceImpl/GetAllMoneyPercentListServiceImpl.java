package com.team5.funthing.user.service.impl.showProjectListServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.HomeDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.showProjectListService.GetAllMoneyPercentListService;

@Service
public class GetAllMoneyPercentListServiceImpl implements GetAllMoneyPercentListService {
	@Autowired
	private HomeDAO HomeDAO; 
	
	@Override
	public List<ProjectVO> getAllMoneyPercentList(ProjectVO vo) {

		return HomeDAO.getAllMoneyPercentList(vo);
	}

}
