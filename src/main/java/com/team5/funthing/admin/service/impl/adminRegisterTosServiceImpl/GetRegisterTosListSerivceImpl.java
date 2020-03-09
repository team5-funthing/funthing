package com.team5.funthing.admin.service.impl.adminRegisterTosServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminRegisterTosDAO;
import com.team5.funthing.admin.model.vo.AdminRegisterTosVO;
import com.team5.funthing.admin.service.adminRegisterTosService.GetRegisterTosListService;

@Service
public class GetRegisterTosListSerivceImpl implements GetRegisterTosListService {

	@Autowired
	private AdminRegisterTosDAO adminRegisterTosDAO;
	
	@Override
	public List<AdminRegisterTosVO> getRegisterTosList(AdminRegisterTosVO vo) {
		return adminRegisterTosDAO.getRegisterTosList(vo);
	}

}
