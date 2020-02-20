package com.team5.funthing.user.service.impl.projectBoardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectBoardDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.GetEntireProjectBoardListService;

@Service
public class GetEntireProjectBoardListServiceImpl implements GetEntireProjectBoardListService {
	
	@Autowired
	private ProjectBoardDAO projectBoardDAO;
	
	@Override
	public List<ProjectBoardVO> getEntireProjectBoardList(ProjectBoardVO vo) {
		
		return projectBoardDAO.getEntireProjectBoardList(vo);
	}

}
