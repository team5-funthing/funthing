package com.team5.funthing.user.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.user.model.dao.UserMainImageChangeDAO;
import com.team5.funthing.user.service.userMainImageChangeService.GetUserMainImageChangeListService;
@Service
public class GetUserMainImageChangeListServiceImpl implements GetUserMainImageChangeListService {

	@Autowired
	UserMainImageChangeDAO getUserMainImageDAO;
	
	@Override
	public List<AdminUserMainImageChangeVO> getUserMainImageChangeList(AdminUserMainImageChangeVO vo) {
		return getUserMainImageDAO.getUserMainImageChangeList(vo);
	}

	
	
}
