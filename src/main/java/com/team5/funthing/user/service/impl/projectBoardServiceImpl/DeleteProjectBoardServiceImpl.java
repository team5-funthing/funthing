package com.team5.funthing.user.service.impl.projectBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectBoardDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.DeleteProjectBoardService;

@Service
public class DeleteProjectBoardServiceImpl implements DeleteProjectBoardService {
	
	@Autowired
	private ProjectBoardDAO projectBoardDAO;
	
	@Override
	public void deleteProjectBoard(ProjectBoardVO vo) {
		projectBoardDAO.deleateProjectBoard(vo);
		
	}

	

}
