package com.team5.funthing.user.service.impl.projectStoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectStoryDAO;
import com.team5.funthing.user.model.vo.ProjectStoryVO;
import com.team5.funthing.user.service.projectStoryService.GetProjectStoryService;

@Service
public class GetProjectStoryServiceImpl implements GetProjectStoryService {

	@Autowired
	private ProjectStoryDAO projectStoryDAO;
	
	@Override
	public ProjectStoryVO getProjectStory(ProjectStoryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
