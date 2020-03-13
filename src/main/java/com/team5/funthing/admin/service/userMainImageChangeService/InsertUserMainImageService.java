package com.team5.funthing.admin.service.userMainImageChangeService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;

public interface InsertUserMainImageService {
	void insertUserMainImage(AdminUserMainImageChangeVO vo,List<String> toInsertIntroduceImage,List<String> toInsertImageContent);
}
