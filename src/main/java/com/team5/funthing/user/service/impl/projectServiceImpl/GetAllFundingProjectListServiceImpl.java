package com.team5.funthing.user.service.impl.projectServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.GetAllFundingProjectListService;

@Service
public class GetAllFundingProjectListServiceImpl implements GetAllFundingProjectListService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public List<ProjectVO> getAllFundingProjectList() {
		
		return projectDAO.getAllFundingProjectList();
	}

}
