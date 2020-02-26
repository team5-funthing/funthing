package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.DeleteProjectService;

@Service
public class DeleteProjectServiceImpl implements DeleteProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public void deleteProject(ProjectVO vo) {
		projectDAO.deleteProject(vo);
	}
	
	

}
