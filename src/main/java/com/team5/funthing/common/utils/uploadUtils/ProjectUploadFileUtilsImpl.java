package com.team5.funthing.common.utils.uploadUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.user.model.vo.ProjectVO;

import net.coobird.thumbnailator.Thumbnails;

@Component("uploadFileUtils")
public class ProjectUploadFileUtilsImpl implements UploadFileUtils {
	
	@Autowired
	private UploadPath uploadPath;
	
	static final int THUMB_WIDTH = 300;
	static final int THUMB_HEIGHT = 300;
	
	public ProjectVO useUtil(MultipartFile uploadFile, ProjectVO vo) throws Exception {
		
		String realPath = uploadPath.getUploadPath(); // ���� ��� ��������
		System.out.println("uploadPath : " + realPath); 
		
		//fileUpload
		String imgUploadPath = realPath + "uploadImg"; // uploadImg ����
		String ymdPath = calcPath(imgUploadPath); //
		String fileName = null;
		
		if(uploadFile != null) {
			fileName = fileUpload(imgUploadPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), ymdPath);

		}else {
			System.out.println("���� ���� ���ε� ����");
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		
		System.out.println("fileName : " + fileName);
		vo.setProjectMainImage(File.separator + "funthing" + File.separator + "resources" + File.separator + "user" + File.separator + "uploadImg" + ymdPath + File.separator + fileName); // DB�� �����ų ���
		vo.setProjectVideo(File.separator + "funthing" + File.separator + "resources" + File.separator + "user" + File.separator + "uploadImg" + ymdPath + File.separator + "thumbnail" + File.separator + "thumb_" + fileName);
		
		return vo; // DB�� �����ų ���
		
	}
	
	
	public String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception{

		// UUID '-' �����Ͽ� ������ ����
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		String newFileName = uuid + "_" + fileName; // ���ε� �� ����� ���ϸ� ���� 
		String imgPath = uploadPath + ymdPath; // ���� ��θ� year, month, day�� ����
		
		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);
		
		String thumbFileName = "thumb_" + newFileName;
		
		
		System.out.println("imgPath : " + imgPath);
		System.out.println("newFileName : " + newFileName);
		System.out.println("thumbFileName : " + thumbFileName);
		
		File image = new File(imgPath + File.separator + newFileName); // �Ϲ� �̹����� ���� ���
		
		File thumbnail = new File(imgPath + File.separator + "thumbnail" + File.separator + thumbFileName); // ����� �̹����� ���� ���� ���
		
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
		makeDir(uploadPath, yearPath, monthPath, datePath + "\\thumbnail");
		
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
