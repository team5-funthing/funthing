package com.team5.funthing.user.service.impl.CreatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorDAO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.CreatorService.GetCreatorService;

@Service
public class GetCreatorServiceImpl implements GetCreatorService {

	@Autowired
	private CreatorDAO CreatorDAO;
	
	@Override
	public CreatorVO getCreator(CreatorVO vo) {
		return CreatorDAO.getCreator(vo);
	}

}
