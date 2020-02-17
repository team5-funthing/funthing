package com.team5.funthing.common.utils.uploadUtils;

import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.user.model.vo.ProjectVO;

public interface UploadFileUtils {

	public ProjectVO useUtil(MultipartFile uploadFile, ProjectVO vo) throws Exception;
	public String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception;
	public String calcPath(String uploadPath);
	public void makeDir(String uploadPath, String... paths);
	
}
