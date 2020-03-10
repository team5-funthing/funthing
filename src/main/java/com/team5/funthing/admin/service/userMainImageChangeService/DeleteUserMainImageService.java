package com.team5.funthing.admin.service.userMainImageChangeService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;

public interface DeleteUserMainImageService {
	void deleteUserMainImage(AdminUserMainImageChangeVO vo,List<Integer> toRemoveImageNoList);
}
