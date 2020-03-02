package com.team5.funthing.user.service.impl.tosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.user.model.dao.TosDAO;
import com.team5.funthing.user.model.vo.TosVO;
import com.team5.funthing.user.service.TosService.DeleteTosService;

@Service
public class DeleteTosServiceImpl implements DeleteTosService {

	@Autowired
	private TosDAO tosDAO;
	
	@Override
	public int DeleteTos(TosVO vo) {
		return tosDAO.deleteTos(vo);
	}

}
