package com.team5.funthing.user.service.impl.projectStoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectStoryDAO;
import com.team5.funthing.user.model.vo.ProjectStoryVO;
import com.team5.funthing.user.service.projectStoryService.UpdateProjectStoryService;

@Service
public class updateProjectStoryServiceImpl implements UpdateProjectStoryService {

	@Autowired
	private ProjectStoryDAO projectStoryDAO;
	
	@Override
	public void updateProjectStory(ProjectStoryVO vo) {
		// TODO Auto-generated method stub

	}

}
