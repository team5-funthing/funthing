package com.team5.funthing.admin.service.impl.adminMainViewServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminMainViewDAO;
import com.team5.funthing.admin.model.vo.AdminMainViewVO;
import com.team5.funthing.admin.service.adminMainViewService.GetMainViewProjectStatusListService;
import com.team5.funthing.user.model.vo.ProjectVO;
@Service
public class GetMainViewProjectStatusListServiceImpl implements GetMainViewProjectStatusListService {

	@Autowired
	AdminMainViewDAO adminMainViewDAO;
	
	@Override
	public List<ProjectVO> getMainViewProjectStatusList(AdminMainViewVO vo) {
		
		return adminMainViewDAO.getMainViewProjectStatusList(vo);
	}

	

	
}
