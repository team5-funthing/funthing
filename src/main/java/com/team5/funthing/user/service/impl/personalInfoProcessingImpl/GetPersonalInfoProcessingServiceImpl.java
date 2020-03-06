package com.team5.funthing.user.service.impl.personalInfoProcessingImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.user.model.dao.PersonalInfoProcessingDAO;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingService;

@Service
public class GetPersonalInfoProcessingServiceImpl implements GetPersonalInfoProcessingService {

	@Autowired
	private PersonalInfoProcessingDAO personalInfoProcessingDAO;
	
	@Override
	public AdminPersonalInfoProcessingVO getPersonalInfoProcessing(AdminPersonalInfoProcessingVO vo) {
		return personalInfoProcessingDAO.getPersonalInfoProcessing(vo);
	}

}
