package com.team5.funthing.common.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.team5.funthing.common.utils.uploadUtils.InitRealPathController;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.ProjectIntroduceVO;

@Controller
public class CKEditorFileUploadController {
	
	@Autowired
	private InitRealPathController initRealPathController;
	@Autowired
	private UploadUtil uploadutil;
	
//	@Autowired 
//	private ProjectIntroduceVO ProjectIntroduceVO; 
	
	
	@RequestMapping(value = "/storyUpload.udo", method = RequestMethod.POST)
	@ResponseBody
	public String uploadUpload( HttpServletRequest request, 
								HttpServletResponse response,
								@RequestParam(name = "upload", required = false)MultipartFile upload) throws Exception {
		
		if(!upload.isEmpty()) {  
			//제거될 파일경로를 vo객체에서 가져오기
			String toRemoveFilePath = ProjectIntroduceVO.getProjectStoryImage();
			String voName = ProjectIntroduceVO.getClass().getSimpleName();
			String toSettingPath = projectMainImageUploadUtils.upload(upload, voName, toRemoveFilePath);

			ProjectIntroduceVO.setProjectMainImage(toSettingPath);
		}
		
		
		System.out.println("여기 오냐");
		
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		
		
		
		if(upload != null) {
			if(upload.getSize() > 0 && StringUtils.isNotBlank(upload.getName())) {
				if(upload.getContentType().toLowerCase().startsWith("image/")) {
					try {
						String uploadName = upload.getName();
						byte[] bytes = upload.getBytes();
						
						
						String uploadPath = initRealPathController.getRealPath();
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						uploadName = UUID.randomUUID().toString();
						uploadPath = uploadPath + "/" + uploadName;
						out.write(bytes);
						
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String uploadUrl = request.getContextPath() + "/img" + uploadName;
						
						// json 데이터로 등록
						// {"uploaded" : 1, "uploadName" : "test.jpg", "url" : "/img/text.jpg"}
						// 이런 형태로 리턴이 나가야한데요.
						json.addProperty("uploaded", 1);
						json.addProperty("uploadName", uploadName);
						json.addProperty("url", uploadUrl);
						
						printWriter.println(json);
						
						
					}catch(IOException e) {
						
						e.printStackTrace();
					}finally {
						
						if(out != null) {
							out.close();
						}
						if(printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
		return null;
		
	}
	
}



















