package com.team5.funthing.user.service.impl.projectBoardServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectBoardDAO;
import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.service.projectBoardService.GetChoiceProjectBoardReplyService;

@Service
public class GetChoiceProjectBoardReplyServiceImpl implements GetChoiceProjectBoardReplyService {
	
	@Autowired
	private ProjectBoardDAO projectBoardDAO;
	

	@Override
	public ProjectBoardVO getChoiceProjectBoardReply(ProjectBoardVO vo) {
		// TODO Auto-generated method stub
		return projectBoardDAO.getChoiceProjectBoardReply(vo);
	}

}
