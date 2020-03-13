package com.team5.funthing.admin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.DeleteUserMainImageService;
import com.team5.funthing.admin.service.userMainImageChangeService.GetUserMainImageListService;
import com.team5.funthing.admin.service.userMainImageChangeService.InsertUserMainImagePathService;
import com.team5.funthing.admin.service.userMainImageChangeService.InsertUserMainImageService;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageContentService;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageNullService;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageService;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;

@Controller
public class AdminUserMainImageChangeController {

	@Autowired
	UpdateUserMainImageService updateUserMainImageService;
	@Autowired
	UpdateUserMainImageNullService updateUserMainImageNullService;
	@Autowired
	GetUserMainImageListService getUserMainImageListService;
	@Autowired
	DeleteUserMainImageService deleteUserMainImageService;
	@Autowired
	InsertUserMainImageService insertUserMainImageService;
	@Autowired
	AdminUserMainImageChangeVO adminUserMainImageChangeVO;
	@Autowired
	InsertUserMainImagePathService insertUserMainImagePathService;
	@Autowired
	UpdateUserMainImageContentService updateUserMainImageContentService;

	

	@Autowired
	private UploadUtil uploadUtil;

	@RequestMapping("userMainImageChange.ado")
	public String upload(@RequestParam(name = "userMainImageNo", required = false) List<Integer> userMainImageNoList,
			@RequestParam(name = "userMainUploadImage", required = false) List<MultipartFile> userMainUploadImage,
			@RequestParam(name = "userMainImageContent", required = false) List<String> userMainImageContentList,
			@RequestParam(name = "userMainImageContent2", required = false) List<String> userMainImageContentList2,
			@RequestParam(name = "userMainImageNo2", required = false) List<Integer> userMainImageNoContentList,

			AdminUserMainImageChangeVO vo) {

		try {
			userMainImageUploader(userMainUploadImage, vo, userMainImageNoList, userMainImageContentList,
					userMainImageNoContentList, userMainImageContentList2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect: userMainImageChangeForm.ado";
	}

	public void userMainImageUploader(List<MultipartFile> toDoUploadList, AdminUserMainImageChangeVO vo,
			List<Integer> toRemoveImageNoList, List<String> userMainImageContentList,
			List<Integer> userMainImageNoContentList, List<String> userMainImageContentList2) throws Exception {

		List<String> toRemoveFilePath = new ArrayList<String>();

		String voName = vo.getClass().getSimpleName();
		List<AdminUserMainImageChangeVO> userMainImageList = getUserMainImageListService.getUserMainImageList();

		if (userMainImageList != null && toRemoveImageNoList != null) {
			for (AdminUserMainImageChangeVO userMainImage : userMainImageList) {
				for (int toRemoveImageNo : toRemoveImageNoList) {
					if (userMainImage.getImageNo() == toRemoveImageNo) {
						toRemoveFilePath.add(userMainImage.getImagePath());
					}
				}
			}
		}

		deleteUserMainImageService.deleteUserMainImage(vo, toRemoveImageNoList);

		if (toRemoveFilePath.isEmpty()) {
			toRemoveFilePath.add(0, null);
		}

		if (!toDoUploadList.isEmpty()) {
			List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			Collections.reverse(tmpUploadList);

			insertUserMainImageService.insertUserMainImage(adminUserMainImageChangeVO, tmpUploadList,
					userMainImageContentList2);
			updateUserMainImageContentService.updateUserMainImageContent(vo, userMainImageContentList,
					userMainImageNoContentList);
		} else {
			uploadUtil.removeUtil(voName, toRemoveFilePath);
			updateUserMainImageContentService.updateUserMainImageContent(vo, userMainImageContentList,
					userMainImageNoContentList);
		}

	}

}
