package com.team5.funthing.user.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team5.funthing.common.utils.UploadFileUtils;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

@Controller
public class TestController {
	
	@Autowired
	private UpdateProjectService updateProjectService;
	
	
	private String uploadPath = "C:/funthing/project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/funthing/resources/user/";

	
	@RequestMapping("/showUpload.tdo")
	public String showUpload() {
		return "fileupload";
	}
	
	
	@RequestMapping(value="/uploadTest.tdo", method = RequestMethod.POST)
	public String testUpload(ProjectVO vo, @RequestParam("uploadFile")MultipartFile uploadFile, MultipartHttpServletRequest request) throws Exception {
		
		System.out.println("uploadPath : " + uploadPath);
		String imgUploadPath = uploadPath + "uploadImg";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(uploadFile != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), ymdPath);
		}else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setProjectMainImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setProjectVideo(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		vo.setProjectNo(49);
		vo.setCreator("uploadTester");
		vo.setEmail("uploadTester@test.com");
		updateProjectService.updateProject(vo);
		
		System.out.println("성공");
		
		
		
		//-------------------------------------------------------
//	    MultipartFile upload = request.getFile("uploadFile");
//		
//		System.out.println("testupload 수행중");
//		MultipartFile file = upload;
//		System.out.println(file == null);
//		if(!file.isEmpty()) {
//			String filename = file.getOriginalFilename();
//			file.transferTo(new File("C:/funthing/projectTestUploadFiles/" + filename));
//		}
		
		return "fileupload";
	}
	

	
	
}
