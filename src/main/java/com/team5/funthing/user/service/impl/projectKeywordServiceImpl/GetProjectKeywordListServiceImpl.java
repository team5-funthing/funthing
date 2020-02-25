package com.team5.funthing.user.service.impl.projectKeywordServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectKeywordDAO;
import com.team5.funthing.user.model.vo.ProjectKeywordVO;
import com.team5.funthing.user.service.projectKeywordService.GetProjectKeywordListService;


@Service
public class GetProjectKeywordListServiceImpl implements GetProjectKeywordListService {
	
	@Autowired
	private ProjectKeywordDAO projectKeywordDAO;
	
	@Override
	public List<ProjectKeywordVO> getProjectKeywordList(ProjectKeywordVO vo) {
		
		return projectKeywordDAO.getProjectKeywordList(vo);
	}

}
