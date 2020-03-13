package com.team5.funthing.admin.service.impl.adminUserMainProjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainProjectDAO;
import com.team5.funthing.admin.service.adminUserMainProjectService.InsertFocusProjectService;
import com.team5.funthing.user.model.vo.ProjectVO;

@Service
public class InsertFocusProjectServiceImpl implements InsertFocusProjectService {
	
	@Autowired
	AdminUserMainProjectDAO adminUserMainProjectDAO;
	
	@Override
	public void insertFocusProject(ProjectVO vo) {
		
		adminUserMainProjectDAO.insertFocusProject(vo);
		
	}

}
