package com.team5.funthing.user.service.projectService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectVO;

public interface GetProjectServiceByEmail {

	
	public List<ProjectVO> getProjectListByEmail(ProjectVO vo);
}
