package com.team5.funthing.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.DeleteUserMainImageService;
import com.team5.funthing.admin.service.userMainImageChangeService.GetUserMainImageListService;
import com.team5.funthing.admin.service.userMainImageChangeService.InsertUserMainImageService;
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

	// ===================== 유틸 주입 =====================

	@Autowired
	private UploadUtil uploadUtil;

	@RequestMapping("userMainImageChange.ado")
	public String upload(
			@RequestParam(name = "projectIntroduceImageNo", required = false)List<Integer> userMainImageNoList,
			@RequestParam(name = "userMainUploadImage",required = false) List<MultipartFile> userMainUploadImage,
			AdminUserMainImageChangeVO vo) {

		vo.setImageNo(1);
		vo.setImageName("imsi");
		try {
			userMainImageUploader(userMainUploadImage,vo, userMainImageNoList);
			updateUserMainImageService.updateUserMainImage(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect: userMainImageChangeForm.ado";
	}

	public void userMainImageUploader2(List<MultipartFile> toDoUploadList, AdminUserMainImageChangeVO vo)
			throws Exception {

		List<String> toRemoveFilePath = new ArrayList<String>();

		if (!toDoUploadList.get(0).isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리
			toRemoveFilePath.add(vo.getImagePath()); // 제거될 파일경로를 vo객체에서 가져오기
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			if (toSettingPath == null)
				return;

			for (String toInsertImage : toSettingPath) {
				vo.setImagePath(toInsertImage);
			}
		}
	}

	public void userMainImageUploader(List<MultipartFile> toDoUploadList, AdminUserMainImageChangeVO vo,
			List<Integer> toRemoveImageNoList) throws Exception {

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

		if (!toDoUploadList.isEmpty()) { // 프로젝트 소개 이미지 기존업로드 제거 및 새 업로드, DB 추가 작업 메서드

			List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			insertUserMainImageService.insertUserMainImage(adminUserMainImageChangeVO, tmpUploadList);

		} else {
			uploadUtil.removeUtil(voName, toRemoveFilePath);

		}

	}

}
