package com.team5.funthing.admin.service.impl.adminRegisterTosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminRegisterTosDAO;
import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.service.adminRegisterTosService.UpdateRegisterTosService;

@Service
public class UpdateRegisterTosServiceImpl implements UpdateRegisterTosService {

	@Autowired
	private AdminRegisterTosDAO adminRegisterTosDAO;
	
	@Override
	public int updateRegisterTos(AdminRegisterTosVO vo) {
		return adminRegisterTosDAO.updateRegisterTos(vo);
	}

}
