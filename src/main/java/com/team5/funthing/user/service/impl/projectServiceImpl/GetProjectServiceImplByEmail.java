package com.team5.funthing.user.service.impl.projectServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.GetProjectServiceByEmail;

@Service
public class GetProjectServiceImplByEmail implements GetProjectServiceByEmail {

	@Autowired
	ProjectDAO projectDAO;
	


	@Override
	public List<ProjectVO> getProjectListByEmail(ProjectVO vo) {
		return projectDAO.getProjectListByEmail(vo);
	}

}
