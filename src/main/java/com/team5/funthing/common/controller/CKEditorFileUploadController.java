package com.team5.funthing.common.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.team5.funthing.common.utils.uploadUtils.InitRealPathController;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.ProjectStoryVO;

@Controller
public class CKEditorFileUploadController {
	
	@Autowired
	private InitRealPathController initRealPathController;
	@Autowired
	private UploadUtil uploadutil;
	
	@Autowired 
	private ProjectStoryVO projectStory; 
	
	
	@RequestMapping(value = "/storyUpload.udo", method = RequestMethod.POST)
	@ResponseBody
	public String uploadUpload( HttpServletRequest request, 
								HttpServletResponse response,
								@RequestParam(name = "upload", required = false)MultipartFile upload) throws Exception {
		
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		
		if(!upload.isEmpty()) {  
			//���ŵ� ���ϰ�θ� vo��ü���� ��������
			String toRemoveFilePath = projectStory.getProjectStoryImagePath();
			String voName = projectStory.getClass().getSimpleName();
			String toSettingPath = uploadutil.upload(upload, voName, toRemoveFilePath);
	
			projectStory.setProjectStoryImagePath(toSettingPath);
			
		}
		
		System.out.println(projectStory.getProjectStoryImagePath());
		String uploadName = projectStory.getProjectStoryImagePath();

		uploadName = uploadName.substring(uploadName.lastIndexOf('/')+1);
		printWriter = response.getWriter();
		response.setContentType("text/html");
	
		// json �����ͷ� ���
		// {"uploaded" : 1, "uploadName" : "test.jpg", "url" : "/img/text.jpg"}
		// �̷� ���·� ������ �������ѵ���.
		json.addProperty("uploaded", 1);
		json.addProperty("uploadName", uploadName);
		json.addProperty("url", projectStory.getProjectStoryImagePath());
		
		printWriter.println(json);
			
			
		return null;
		
	}

}



















