package com.team5.funthing.user.service.impl.tosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.TosDAO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.InsertTosService;

@Service
public class InsertTosServiceImpl implements InsertTosService {

	@Autowired
	private TosDAO tosDAO;
	
	@Override
	public int InsertTos(TosVO vo) {
		return tosDAO.insertTos(vo);
	}

}
