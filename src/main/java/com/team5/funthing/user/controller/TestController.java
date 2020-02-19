package com.team5.funthing.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

@Controller
public class TestController {
	
	@Autowired
	private UploadUtil uploadFileUtils;
	
	@Autowired
	private UpdateProjectService updateProjectService;
	

	
	@RequestMapping("/showUpload.tdo")
	public String showUpload() {
		return "fileupload";
	}
	
//	@RequestMapping(value="/uploadTest.tdo", method = RequestMethod.POST)
//	public String testUpload(ProjectVO vo, @RequestParam("uploadFile")MultipartFile uploadFile, MultipartHttpServletRequest request) throws Exception {
//		
//		
//		String realPath = uploadPath.getUploadPath();
//		
//		//fileUpload
//		System.out.println("uploadPath : " + realPath);
//		String imgUploadPath = realPath + "uploadImg"; // uploadImg 폴더
//		String ymdPath = uploadFileUtils.calcPath(imgUploadPath);
//		String fileName = null;
//		
//		if(uploadFile != null) {
//			fileName = uploadFileUtils.fileUpload(imgUploadPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), ymdPath);
//		}else {
//			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
//		}
//		
//		String proejctMainImagePath = File.separator + "imgUpload" + ymdPath + File.separator + fileName;
//		
//		
//		
//		vo.setProjectMainImage(proejctMainImagePath);
//		vo.setProjectVideo(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
//		vo.setProjectNo(49);
//		vo.setCreator("uploadTester");
//		vo.setEmail("uploadTester@test.com");
//		updateProjectService.updateProject(vo);
//		
//		System.out.println("성공");
//		
//		
//		
//		//-------------------------------------------------------
////	    MultipartFile upload = request.getFile("uploadFile");
////		
////		System.out.println("testupload 수행중");
////		MultipartFile file = upload;
////		System.out.println(file == null);
////		if(!file.isEmpty()) {
////			String filename = file.getOriginalFilename();
////			file.transferTo(new File("C:/funthing/projectTestUploadFiles/" + filename));
////		}
//		
//		return "fileupload";
//	}
//	

	
	
}
