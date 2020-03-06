package com.team5.funthing.user.service.impl.tosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.TosDAO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.GetTosService;

@Service
public class GetTosServiceImpl implements GetTosService{

	@Autowired
	private TosDAO tosDAO;
	
	@Override
	public TosVO getTos(TosVO vo) {
		return tosDAO.getTos(vo);
	}

}
