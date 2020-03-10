package com.team5.funthing.admin.service.impl.userMainImageChangeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.funthing.admin.model.dao.AdminUserMainImageChangeDAO;
import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.DeleteUserMainImageService;
@Service
public class DeleteUserMainImageServiceImpl implements DeleteUserMainImageService{

	@Autowired
	AdminUserMainImageChangeDAO adminUserMainImageChangeDAO;
	
	@Override
	public void deleteUserMainImage(AdminUserMainImageChangeVO vo,List<Integer> toRemoveImageNoList) {
		
		if(toRemoveImageNoList != null) {
			for(int toRemoveImageNo : toRemoveImageNoList) {
				vo.setImageNo(toRemoveImageNo);
				adminUserMainImageChangeDAO.deleteUserMainImageChange(vo);
			}
			
		}
	}

}
