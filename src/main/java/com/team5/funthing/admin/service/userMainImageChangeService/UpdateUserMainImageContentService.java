package com.team5.funthing.admin.service.userMainImageChangeService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;

public interface UpdateUserMainImageContentService {
	void updateUserMainImageContent(AdminUserMainImageChangeVO vo,List<String> toUpdateImageContent,List<Integer> userMainImageNoContentList);
}
