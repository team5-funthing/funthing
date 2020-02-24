package com.team5.funthing.user.service.impl.projectKeywordServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectKeywordDAO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.service.projectKeywordService.GetProjectKeywordService;

@Service
public class GetProjectKeywordServiceImpl implements GetProjectKeywordService {
	
	@Autowired
	private ProjectKeywordDAO projectKeywordDAO;
	
	@Override
	public ProjectKeywordVO getProjectKeyword(ProjectKeywordVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
