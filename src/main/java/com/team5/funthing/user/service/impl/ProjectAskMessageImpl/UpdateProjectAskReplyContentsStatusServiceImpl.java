package com.team5.funthing.user.service.impl.ProjectAskMessageImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAskMessageDAO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.service.projectAskMessageService.UpdateProjectAskReplyContentsStatusService;


@Service
public class UpdateProjectAskReplyContentsStatusServiceImpl implements UpdateProjectAskReplyContentsStatusService {
	
	@Autowired
	private ProjectAskMessageDAO projectAskMessageDAO;
	
	@Override
	public void updateProjectAskReplyContentsStatus(ProjectAskMessageVO vo) {
		projectAskMessageDAO.updateProjectAskReplyContentsStatus(vo);

	}

}
