package com.team5.funthing.user.service.impl.projectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Service
public class GetProjectServiceImpl implements GetProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public ProjectVO getProject(ProjectVO vo) {
		
		return projectDAO.getProejct(vo);
	}

}
