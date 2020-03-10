package com.team5.funthing.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.File;
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
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.model.vo.ProjectIntroduceImageVO;

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

	// ===================== ��ƿ ���� =====================

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

		if (!toDoUploadList.get(0).isEmpty()) { // ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��
			toRemoveFilePath.add(vo.getImagePath()); // ���ŵ� ���ϰ�θ� vo��ü���� ��������
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

		if (!toDoUploadList.isEmpty()) { // ������Ʈ �Ұ� �̹��� �������ε� ���� �� �� ���ε�, DB �߰� �۾� �޼���

			List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			insertUserMainImageService.insertUserMainImage(adminUserMainImageChangeVO, tmpUploadList);

		} else {
			uploadUtil.removeUtil(voName, toRemoveFilePath);

		}

	}

}
