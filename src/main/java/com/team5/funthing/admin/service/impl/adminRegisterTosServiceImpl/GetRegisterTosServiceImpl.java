package com.team5.funthing.admin.service.impl.adminRegisterTosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminRegisterTosDAO;
import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosService;

@Service
public class GetRegisterTosServiceImpl implements GetRegisterTosService {

	@Autowired
	private AdminRegisterTosDAO adminRegisterTosDAO;
	
	@Override
	public AdminRegisterTosVO getRegisterTos(AdminRegisterTosVO vo) {
		return adminRegisterTosDAO.getRegisterTos(vo);
	}

}
