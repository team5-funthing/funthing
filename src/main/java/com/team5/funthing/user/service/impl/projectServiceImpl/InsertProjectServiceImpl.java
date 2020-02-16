package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.InsertProjectService;

@Service
public class InsertProjectServiceImpl implements InsertProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
		
	@Override
	public ProjectVO insertProject(ProjectVO vo) {
		return projectDAO.insertProject(vo); 
	}

}
