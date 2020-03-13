package com.team5.funthing.user.service.impl.personalInfoProcessingImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.user.model.dao.PersonalInfoProcessingDAO;
import com.team5.funthing.user.service.personalInfoProcessingService.UpdatePersonalInfoProcessingService;

@Service
public class UpdatePersonalInfoProcessingServiceImpl implements UpdatePersonalInfoProcessingService{

	@Autowired
	private PersonalInfoProcessingDAO personalInfoProcessingDAO;
	
	@Override
	public int updatePersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return personalInfoProcessingDAO.updatePersonalInfoProcessing(vo);
	}

}
