package com.team5.funthing.user.service.impl.ProjectAskMessageImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAskMessageDAO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.service.ProjectAskMessageService.GetEntireProjectMakerAskMessageListService;

@Service
public class GetEntireProjectMakerAskMessageListServiceImpl implements GetEntireProjectMakerAskMessageListService {
	@Autowired
	private ProjectAskMessageDAO projectAskMessageDAO;
	
	@Override
	public List<ProjectAskMessageVO> getEntireProjectMakerAskMessageList(ProjectAskMessageVO vo2) {
		return projectAskMessageDAO.getEntireProjectMakerAskMessageList(vo2);
	}

}
