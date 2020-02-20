package com.team5.funthing.admin.service.impl.adminCreatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCreatorDAO;
import com.team5.funthing.admin.model.vo.AdminCreatorVO;
import com.team5.funthing.admin.service.adminCreatorService.GetCreatorService;

@Service
public class GetCreatorServiceImpl implements GetCreatorService {

	@Autowired
	private AdminCreatorDAO adminCreatorDAO;
	
	@Override
	public AdminCreatorVO getCreator(AdminCreatorVO vo) {
		return adminCreatorDAO.getCreator(vo);
	}

}
