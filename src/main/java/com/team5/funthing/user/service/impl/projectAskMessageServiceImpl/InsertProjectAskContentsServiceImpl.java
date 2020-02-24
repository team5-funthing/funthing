package com.team5.funthing.user.service.impl.projectAskMessageServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAskMessageDAO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.service.projectAskMessageService.InsertProjectAskContentsService;


@Service
public class InsertProjectAskContentsServiceImpl implements InsertProjectAskContentsService {
	
	@Autowired
	private ProjectAskMessageDAO projectAskMessageDAO;
	
	@Override
	public void insertProjectAskContents(ProjectAskMessageVO vo) {
		projectAskMessageDAO.insertProjectAskContents(vo);

	}

}
