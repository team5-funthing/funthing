package com.team5.funthing.common.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String uploadUpload( HttpServletResponse response,
								HttpSession session,
								@RequestParam(name = "upload", required = false)MultipartFile upload) throws Exception {
		
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		List<String> SettingPathList = new ArrayList<String>(); 
		
		if(!upload.isEmpty()) {  
			//제거될 파일경로를 vo객체에서 가져오기 
			
			List<MultipartFile> uploadList = new ArrayList<MultipartFile>();
			List<String> toRemoveFilePath = new ArrayList<String>();   
			uploadList.add(upload);
			toRemoveFilePath.add(projectStory.getProjectStoryImage());
			String voName = projectStory.getClass().getSimpleName();
			SettingPathList = uploadutil.upload(uploadList, voName, toRemoveFilePath);
			
		}
		String SettingPath = SettingPathList.get(0);
		String uploadName = SettingPath.substring(SettingPath.lastIndexOf('/')+1);
		printWriter = response.getWriter();
		response.setContentType("text/html");
	
		// json 데이터로 등록
		// ex ==> {"uploaded" : 1, "uploadName" : "test.jpg", "url" : "/img/text.jpg"}
		json.addProperty("uploaded", 1);
		json.addProperty("uploadName", uploadName);
		json.addProperty("url", SettingPath);
		
		printWriter.println(json);
			
			
		return null;
		
	}

}



















