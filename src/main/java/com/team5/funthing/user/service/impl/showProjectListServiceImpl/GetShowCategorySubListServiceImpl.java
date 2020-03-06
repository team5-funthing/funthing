package com.team5.funthing.user.service.impl.showProjectListServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.ProjectDAO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.showProjectListService.GetShowCategorySubListService;

@Service
public class GetShowCategorySubListServiceImpl implements GetShowCategorySubListService {
	
	@Autowired
	private ProjectDAO ProjectDAO; 

	@Override
	public List<ProjectVO> getShowCategorySubList(ProjectVO vo) {
		return ProjectDAO.getShowCategorySubList(vo);
	}

}
