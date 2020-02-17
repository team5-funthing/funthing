package com.team5.funthing.common.utils;

public interface UploadFileUtils {

	public String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception;
	public String calcPath(String uploadPath);
	public void makeDir(String uploadPath, String... paths);
	
}
