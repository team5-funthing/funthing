package com.team5.funthing.user.service.impl.ProjectAskMessageImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAskMessageDAO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.service.projectAskMessageService.GetChoiceProjectAskMessageService;

@Service
public class GetChoiceProjectAskMessageServiceImpl implements GetChoiceProjectAskMessageService {
	
	@Autowired
	private ProjectAskMessageDAO projectAskMessageDAO;
	
	@Override
	public ProjectAskMessageVO getChoiceProjectAskMessage(ProjectAskMessageVO vo) {
		
		return projectAskMessageDAO.getChoiceProjectAskMessage(vo);
	}

}
