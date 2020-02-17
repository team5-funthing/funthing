package com.team5.funthing.user.controller;


import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.common.utils.uploadUtils.UploadFileUtils;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

@Controller
public class TestController {
	
	@Autowired
	private UploadFileUtils uploadFileUtils;
	
	@Autowired
	private UpdateProjectService updateProjectService;
	
	@RequestMapping("/showUpload.tdo")
	public String showUpload() {
		return "fileupload";
	}
	
	@RequestMapping(value="/uploadTest.tdo", method = RequestMethod.POST)
	public String testUpload(ProjectVO vo, @RequestParam("uploadFile")MultipartFile uploadFile) throws Exception {
		
		
		vo = uploadFileUtils.useUtil(uploadFile, vo);
		
		vo.setProjectNo(58);
		vo.setCreator("uploadTester");
		vo.setEmail("uploadTester@test.com");
		
		updateProjectService.updateProject(vo);
		
		return "fileupload";
	}
	

	
	
}
