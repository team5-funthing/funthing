package com.team5.funthing.user.service.impl.projectAskMessageServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectAskMessageDAO;
import com.team5.funthing.user.model.vo.ProjectAskMessageVO;
import com.team5.funthing.user.service.projectAskMessageService.GetEntireProjectAskMessageListService;

@Service
public class GetEntireProjectAskMessageListServiceImpl implements GetEntireProjectAskMessageListService {
	
	@Autowired
	private ProjectAskMessageDAO projectAskMessageDAO;

	@Override
	public List<ProjectAskMessageVO> getEntireProjectAskMessageList(ProjectAskMessageVO vo) {
		
		return projectAskMessageDAO.getEntireProjectAskMessageList(vo);
	}
	
	

}
