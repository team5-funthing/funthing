package com.team5.funthing.admin.service.impl.adminMainViewServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminMainViewDAO;
import com.team5.funthing.admin.model.vo.AdminMainViewVO;
import com.team5.funthing.admin.service.adminMainViewService.GetMainViewProjectFundingListService;
import com.team5.funthing.user.model.vo.ProjectVO;
@Service
public class GetMainViewProjectFundingListServiceImpl implements GetMainViewProjectFundingListService {

	@Autowired
	AdminMainViewDAO adminMainViewDAO;
	
	@Override
	public List<ProjectVO> getMainViewProjectFundingList(AdminMainViewVO vo) {
		return adminMainViewDAO.getMainViewProjectFundingList(vo);
	}
	
	

}
