package com.team5.funthing.user.service.impl.projectBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectBoardDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.InsertProjectBoardService;

@Service
public class InsertProjectBoardServiceImpl implements InsertProjectBoardService {
	
	@Autowired
	private ProjectBoardDAO projectBoardDAO;
	
	@Override
	public void insertProjectBoard(ProjectBoardVO vo) {
		projectBoardDAO.insertProjectBoard(vo);

	}



}
