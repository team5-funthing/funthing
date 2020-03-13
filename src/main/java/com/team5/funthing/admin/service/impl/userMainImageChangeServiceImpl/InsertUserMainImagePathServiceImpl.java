package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.InsertUserMainImagePathService;
@Service
public class InsertUserMainImagePathServiceImpl implements InsertUserMainImagePathService{

	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public void insertUserMainImagePath(AdminUserMainImageChangeVO vo, List<String> toInsertPathList) {
		if(toInsertPathList != null) {
			
			for(String toInsertPath : toInsertPathList) {
				vo.setImagePath(toInsertPath);
				adminUserMainImageChangeDAO.insertUserMainImagePath(vo);
				
			} // 소개 이미지 경로 DB에 추가
		}
		
	}

}
