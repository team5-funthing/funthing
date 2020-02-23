package com.team5.funthing.common.controller;

import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.ProjectStoryVO;

@Controller
public class CKEditorFileUploadController {
	
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
			//제거될 파일경로를 vo객체에서 가져오기
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
	
		// json 데이터로 등록
		// ex ==> {"uploaded" : 1, "uploadName" : "test.jpg", "url" : "/img/text.jpg"}
		json.addProperty("uploaded", 1);
		json.addProperty("uploadName", uploadName);
		json.addProperty("url", projectStory.getProjectStoryImagePath());
		
		printWriter.println(json);
			
			
		return null;
		
	}

}



















