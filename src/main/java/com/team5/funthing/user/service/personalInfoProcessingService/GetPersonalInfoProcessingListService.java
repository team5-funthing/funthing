package com.team5.funthing.user.service.personalInfoProcessingService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminPersonalInfoProcessingVO;

public interface GetPersonalInfoProcessingListService {

	public List<AdminPersonalInfoProcessingVO> getPersonalInfoProcessingList(AdminPersonalInfoProcessingVO vo);
	
}
