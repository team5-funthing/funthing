package com.team5.funthing.user.service.impl.projectBoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectBoardDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.DeleteProjectBoardReplyService;

@Service
public class DeleteProjectBoardReplyServiceImpl implements DeleteProjectBoardReplyService {

	@Autowired
	private ProjectBoardDAO projectBoardDAO;
	
	@Override
	public void deleteProjectBoardReply(ProjectBoardVO vo) {
		projectBoardDAO.deleateProjectBoardReply(vo);
		
	}


}
