package com.team5.funthing.admin.service.impl.adminCreatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCreatorDAO;
import com.team5.funthing.admin.model.vo.AdminCreatorVO;
import com.team5.funthing.admin.service.adminCreatorService.DeleteCreatorService;

@Service
public class DeleteCreatorServiceImpl implements DeleteCreatorService {

	@Autowired
	private AdminCreatorDAO adminCreatorDAO;

	@Override
	public void deleteCreator(AdminCreatorVO vo) {
		adminCreatorDAO.deleteCreator(vo);
	}
	
	
}
