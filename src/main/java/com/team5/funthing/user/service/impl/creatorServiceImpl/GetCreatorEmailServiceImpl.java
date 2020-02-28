package com.team5.funthing.user.service.impl.creatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorDAO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.creatorService.GetCreatorEmailService;

@Service
public class GetCreatorEmailServiceImpl implements GetCreatorEmailService {
	
	@Autowired
	private CreatorDAO CreatorDAO;
	
	@Override
	public CreatorVO getCreatorEmail(CreatorVO vo) {

		return CreatorDAO.getCreatorEmail(vo);
	}

}
