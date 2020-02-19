package com.team5.funthing.common.utils.uploadUtils;

import org.springframework.web.multipart.MultipartFile;

public interface UploadUtil {

	public String upload(MultipartFile uploadFile, String voName, String toRemoveFilePath) throws Exception;
	public String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception;
	public String calcPath(String uploadPath, String dirName);
	public void makeDir(String uploadPath, String... paths);
	
	public void remove(String toRemoveFilePath, String voName);
	
}
