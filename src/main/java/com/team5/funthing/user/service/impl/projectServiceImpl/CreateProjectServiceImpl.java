package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.CreateProjectService;

@Service
public class CreateProjectServiceImpl implements CreateProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public int createProject(ProjectVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
