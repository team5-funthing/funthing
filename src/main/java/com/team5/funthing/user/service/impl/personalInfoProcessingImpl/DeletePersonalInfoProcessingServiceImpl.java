package com.team5.funthing.user.service.impl.personalInfoProcessingImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.user.model.dao.PersonalInfoProcessingDAO;
import com.team5.funthing.user.service.personalInfoProcessingService.DeletePersonalInfoProcessingService;

@Service
public class DeletePersonalInfoProcessingServiceImpl implements DeletePersonalInfoProcessingService {

	@Autowired
	private PersonalInfoProcessingDAO personalInfoProcessingDAO;
	
	@Override
	public int deletePersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return personalInfoProcessingDAO.deletePersonalInfoProcessing(vo);
	}

}
