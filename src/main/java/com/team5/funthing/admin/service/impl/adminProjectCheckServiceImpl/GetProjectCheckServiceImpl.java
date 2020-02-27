package com.team5.funthing.admin.service.impl.adminProjectCheckServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminProjectCheckDAO;
import com.team5.funthing.admin.service.adminProjectCheckService.GetProjectCheckService;
import com.team5.funthing.user.model.vo.ProjectVO;
@Service
public class GetProjectCheckServiceImpl implements GetProjectCheckService{

	@Autowired
	private AdminProjectCheckDAO adminProjectCheckDAO;
	
	@Override
	public ProjectVO getProjectCheck(ProjectVO vo) {
		
		return adminProjectCheckDAO.getProjectCheck(vo);
	}
}
