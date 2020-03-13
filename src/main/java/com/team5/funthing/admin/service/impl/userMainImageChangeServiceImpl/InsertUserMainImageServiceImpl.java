package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.InsertUserMainImageService;

@Service
public class InsertUserMainImageServiceImpl implements InsertUserMainImageService{
	
	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public void insertUserMainImage(AdminUserMainImageChangeVO vo,List<String> toInsertImageList) {

		if(toInsertImageList != null) {
			
			for(String toInsertImage : toInsertImageList) {
				vo.setImagePath(toInsertImage);
				adminUserMainImageChangeDAO.insertUserMainImage(vo);
				
			}
		}
	}
	
}
