package com.team5.funthing.admin.service.impl.adminUserMainProjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainProjectDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.admin.service.adminUserMainProjectService.GetFocusProjectService;
import com.team5.funthing.user.model.vo.ProjectVO;

@Service
public class GetFocusProjectServiceImpl implements GetFocusProjectService {

	@Autowired
	AdminUserMainProjectDAO adminUserMainProjectDAO;
	
	@Override
	public AdminUserMainProjectVO getFocusProject(ProjectVO vo) {
		
		return adminUserMainProjectDAO.getFocusProject(vo);
	}

}
