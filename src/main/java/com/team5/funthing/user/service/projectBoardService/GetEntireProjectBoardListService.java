package com.team5.funthing.user.service.projectBoardService;

import java.util.List;

import com.team5.funthing.user.model.vo.ProjectBoardVO;

public interface GetEntireProjectBoardListService {
	
	public List<ProjectBoardVO> getEntireProjectBoardList(ProjectBoardVO vo);
}
