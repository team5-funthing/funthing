package com.team5.funthing.admin.service.impl.adminProjectCheckServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminProjectCheckDAO;
import com.team5.funthing.admin.service.adminProjectCheckService.GetProjectCheckListService;
import com.team5.funthing.user.model.vo.ProjectVO;

@Service
public class GetProjectCheckListServiceImpl implements GetProjectCheckListService{

	@Autowired
	private AdminProjectCheckDAO adminProjectCheckDAO;
	
	@Override
	public List<ProjectVO> getProjectCheckList(ProjectVO vo) {
		
		return adminProjectCheckDAO.getProjectCheckList(vo);
	}
		
}
