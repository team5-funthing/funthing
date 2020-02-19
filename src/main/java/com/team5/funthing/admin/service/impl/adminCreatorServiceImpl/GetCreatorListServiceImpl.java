package com.team5.funthing.admin.service.impl.adminCreatorServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminCreatorDAO;
import com.team5.funthing.admin.model.vo.AdminCreatorVO;
import com.team5.funthing.admin.service.adminCreatorService.GetCreatorListService;

@Service
public class GetCreatorListServiceImpl implements GetCreatorListService {

	@Autowired
	private AdminCreatorDAO adminCreatorDAO;
	
	@Override
	public List<AdminCreatorVO> getCreatorList(AdminCreatorVO vo) {
		return adminCreatorDAO.getCreatorList(vo);
	}

}
