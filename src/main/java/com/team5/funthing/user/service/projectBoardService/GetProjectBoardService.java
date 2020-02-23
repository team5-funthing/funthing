package com.team5.funthing.user.service.projectBoardService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectBoardVO;

public interface GetProjectBoardService {
	
	public List<ProjectBoardVO> getProjectBoard(ProjectBoardVO vo);
}
