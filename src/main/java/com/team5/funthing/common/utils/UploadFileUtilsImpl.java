package com.team5.funthing.common.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import net.coobird.thumbnailator.Thumbnails;

@Component("uploadFileUtils")
public class UploadFileUtilsImpl implements UploadFileUtils {
	
	static final int THUMB_WIDTH = 300;
	static final int THUMB_HEIGHT = 300;
	
	public String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception{
		
		UUID uid = UUID.randomUUID();
		
		
		String newFileName = uid + "_" + fileName;
		System.out.println("newFileName : " + newFileName);
		String imgPath = uploadPath + ymdPath;
		
		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);
		
		String thumbFileName = "s_" + newFileName;
		
		System.out.println("imgPath : " + imgPath);
		System.out.println("File.separator : " + File.separator);
		System.out.println("newFileName : " + newFileName);
		
		File image = new File(imgPath + File.separator + newFileName); // 일반 이미지가 들어가는 경로
		
		File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbFileName); // 썸네일 이미지가 들어가는 폴더 경로
		
		if (image.exists()) {
			thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail);
		}
		return newFileName; 
	}

	public String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		makeDir(uploadPath, yearPath, monthPath, datePath + "\\s");
		
		return datePath;
	}

	public void makeDir(String uploadPath, String... paths) {
		
		if(new File(paths[paths.length - 1]).exists()) {
			return; 
		}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
	
	
}
