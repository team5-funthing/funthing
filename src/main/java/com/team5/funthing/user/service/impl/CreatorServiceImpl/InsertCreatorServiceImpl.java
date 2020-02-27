package com.team5.funthing.user.service.impl.creatorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.CreatorDAO;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.creatorService.InsertCreatorService;

@Service
public class InsertCreatorServiceImpl implements InsertCreatorService {

	@Autowired
	private CreatorDAO userCreatorDAO;
	
	@Override
	public int insertCreator(CreatorVO vo) {
		return userCreatorDAO.insertCreator(vo);
	}

}
