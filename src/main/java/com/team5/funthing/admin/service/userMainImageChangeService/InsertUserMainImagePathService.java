package com.team5.funthing.admin.service.userMainImageChangeService;

import java.util.List;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;

public interface InsertUserMainImagePathService {
	void insertUserMainImagePath(AdminUserMainImageChangeVO vo,List<String> toInsertPath);
}
