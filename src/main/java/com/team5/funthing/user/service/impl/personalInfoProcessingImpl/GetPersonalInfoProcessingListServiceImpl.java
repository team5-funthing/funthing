package com.team5.funthing.user.service.impl.personalInfoProcessingImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;
import com.team5.funthing.user.model.dao.PersonalInfoProcessingDAO;
import com.team5.funthing.user.service.personalInfoProcessingService.GetPersonalInfoProcessingListService;

@Service
public class GetPersonalInfoProcessingListServiceImpl implements GetPersonalInfoProcessingListService {

	@Autowired
	private PersonalInfoProcessingDAO personalInfoProcessingDAO;
	
	@Override
	public List<AdminPersonalInfoProcessingVO> getPersonalInfoProcessingList(AdminPersonalInfoProcessingVO vo) {
		return personalInfoProcessingDAO.getPersonalInfoProcessingList(vo);
	}

}
