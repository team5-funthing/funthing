package com.team5.funthing.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.admin.model.vo.AdminUserMainImageChangeVO;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageNullService;
import com.team5.funthing.admin.service.userMainImageChangeService.UpdateUserMainImageService;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;

@Controller
public class AdminUserMainImageChangeController {
	
	private String SAVE_PATH = "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\main\\";
	
	@Autowired
	UpdateUserMainImageService updateUserMainImageService;
	@Autowired
	UpdateUserMainImageNullService updateUserMainImageNullService;

	// ===================== ��ƿ ���� =====================

		@Autowired
		private UploadUtil uploadUtil;
	

	@RequestMapping("userMainImageChange.ado")
    public String upload(
    		@RequestParam(name = "userMainUploadImage", required = false)List<MultipartFile> userMainUploadImage,AdminUserMainImageChangeVO vo) {

		vo.setImageNo(1);
		vo.setImageName("imsi");
		try {
			userMainImageUploader(userMainUploadImage, vo);
			updateUserMainImageService.updateUserMainImage(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return "redirect: userMainImageChangeForm.ado";
        }
	
	
public void userMainImageUploader(List<MultipartFile> toDoUploadList, AdminUserMainImageChangeVO vo) throws Exception{
		
		List<String> toRemoveFilePath = new ArrayList<String>();

		
		if(!toDoUploadList.get(0).isEmpty()) { // ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
			toRemoveFilePath.add(vo.getImagePath()); //���ŵ� ���ϰ�θ� vo��ü���� ��������
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = uploadUtil.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) return;

			for(String toInsertImage : toSettingPath) {
				vo.setImagePath(toInsertImage);
			}
		}
		
	}
    

}
