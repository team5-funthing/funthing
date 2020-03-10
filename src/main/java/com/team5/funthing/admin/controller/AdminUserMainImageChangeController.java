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

	// ===================== �쑀�떥 二쇱엯 =====================

	@Autowired
	private UploadUtil uploadUtil;

	@RequestMapping("userMainImageChange.ado")
	public String upload(
			@RequestParam(name = "userMainImageNo", required = false)List<Integer> userMainImageNoList,
			@RequestParam(name = "userMainUploadImage",required = false) List<MultipartFile> userMainUploadImage,
			AdminUserMainImageChangeVO vo) {

		
		try {
			userMainImageUploader(userMainUploadImage,vo, userMainImageNoList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect: userMainImageChangeForm.ado";
	}

	public void userMainImageUploader2(List<MultipartFile> toDoUploadList, AdminUserMainImageChangeVO vo)
			throws Exception {

		List<String> toRemoveFilePath = new ArrayList<String>();

		if (!toDoUploadList.get(0).isEmpty()) { // �뾽濡쒕뱶 �떆�궓 �뙆�씪�씠 �씠誘� 議댁옱�븯�뒗 寃쎌슦 �뙆�씪 �꽑�깮�쓣 �떎�떆 �븞�븳 寃쎌슦�뿉 �굹�삱 �닔 �엳�뒗 �긽�솴 泥섎━
			toRemoveFilePath.add(vo.getImagePath()); // �젣嫄곕맆 �뙆�씪寃쎈줈瑜� vo媛앹껜�뿉�꽌 媛��졇�삤湲�
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

		if (!toDoUploadList.isEmpty()) { // �봽濡쒖젥�듃 �냼媛� �씠誘몄� 湲곗〈�뾽濡쒕뱶 �젣嫄� 諛� �깉 �뾽濡쒕뱶, DB 異붽� �옉�뾽 硫붿꽌�뱶

			List<String> tmpUploadList = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			for(int i=0; i<tmpUploadList.size();i++) {
			System.out.println("tmpUploadList:"+tmpUploadList.get(i));
			}
			Collections.reverse(tmpUploadList);
			insertUserMainImageService.insertUserMainImage(adminUserMainImageChangeVO, tmpUploadList);

		} else {
			uploadUtil.removeUtil(voName, toRemoveFilePath);

		}

	}

}
