package com.team5.funthing.user.service.impl.projectBoardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectBoardDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.SelectEntireProjectBoardListService;

@Service
public class SelectEntireProjectBoardListServiceImpl implements SelectEntireProjectBoardListService {
	
	@Autowired
	private ProjectBoardDAO projectBoardDAO;
	
	@Override
	public List<ProjectBoardVO> selectEntireProjectBoardList(ProjectBoardVO vo) {
		
		return projectBoardDAO.selectEntireProjectBoardList(vo);
	}

}
