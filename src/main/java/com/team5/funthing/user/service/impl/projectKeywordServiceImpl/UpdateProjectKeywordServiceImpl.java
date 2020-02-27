package com.team5.funthing.user.service.impl.projectKeywordServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectKeywordDAO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.service.projectKeywordService.UpdateProjectKeywordService;

@Service
public class UpdateProjectKeywordServiceImpl implements UpdateProjectKeywordService {
	
	@Autowired
	private ProjectKeywordDAO projectKeywordDAO;
	
	@Override
	public void updateProjectKeywordService(ProjectKeywordVO vo) {
		projectKeywordDAO.updateProjectKeyword(vo);
	}

}
