package com.team5.funthing.common.utils.uploadUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 * 
 * 		// ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��
 *		// ���ε� �̹����� ������ ���
 *		if(!uploadFile.isEmpty()) { 
 *			
 *			//���ŵ� ���ϰ�θ� vo��ü���� ��������
 *			String toRemoveFilePath = vo.getProjectMainImage();
 *			
 *			String voName = vo.getClass().getSimpleName();
 *			String toSettingPath = projectMainImageUploadUtils.upload(uploadFile, voName, toRemoveFilePath);
 *			
 *			vo.setProjectMainImage(toSettingPath);
 *		}
 * 
 * 
 * 
 * 
 */

@Component
public class UploadUtilImpl implements UploadUtil {

	@Autowired
	private InitRealPathController initRealPathController;
	
//	static final int THUMB_WIDTH = 300;
//	static final int THUMB_HEIGHT = 300;

	
	@Override
	public List<String> upload(List<MultipartFile> uploadFiles, String voName, List<String> toRemoveFilePath) throws Exception {

		List<String> uploadCompletePaths = new ArrayList<String>();
		
		String realPath = initRealPathController.getRealPath(); // ���ε� ������ ���� ����� ��� 
		String temp = voName.replace("VO", "");
		String dirName = File.separator + temp.substring(0, 1).toLowerCase() + temp.substring(1); // vo Ŭ���� ������ ���� ������ ����ϱ� ���� ���� ex) ProjectVO ---> project
		String dirPath = calcPath(realPath, dirName);
		String fileName = null;
				

		if(toRemoveFilePath.get(0) != null) {
			
			for(String removePath : toRemoveFilePath) {
				remove(removePath, dirName);
			}
			
		}

		for(MultipartFile uploadFile : uploadFiles) {

			if(uploadFile != null) {
				String originalFileName = uploadFile.getOriginalFilename().trim();

				if( originalFileName != "") {
					fileName = fileUpload(realPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), dirPath);
					
				}else {
					return null;
				}
			}else {
				return null;
			}
			//DB�� ������ ���
			String completePath = File.separator + "funthing" + File.separator + "resources" + File.separator + "upload" + dirPath + File.separator + fileName;
			uploadCompletePaths.add(completePath);
			
			
		}
		return uploadCompletePaths;
	}

	@Override
	public String fileUpload(String realPath, String fileName, byte[] fileData, String dirPath) throws Exception{


		String uuid = UUID.randomUUID().toString().replace("-", "");

		String newFileName = uuid + "_" + fileName; 
		String imgPath = realPath + dirPath; 
		
		File image = new File(imgPath + File.separator + newFileName);
		FileCopyUtils.copy(fileData, image); 
		
		if (image.exists()) {
		}
		
		return newFileName; 


	}

	@Override
	public String calcPath(String realPath, String dirName) {
		Calendar cal = Calendar.getInstance();
		String yearPath = dirName + File.separator + cal.get(Calendar.YEAR);           
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(realPath, dirName, yearPath, monthPath, datePath); 

		return datePath;
	}


	@Override
	public void makeDir(String realPath, String... paths) {
		if(new File(paths[paths.length - 1]).exists()) {
			return; 
		}

		for(String path : paths) {
			File dirPath = new File(realPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}

	}
	
	@Override
	public void removeUtil(String voName, List<String> toRemoveFilePath) throws Exception {

		String temp = voName.replace("VO", "");
		String dirName = File.separator + temp.substring(0, 1).toLowerCase() + temp.substring(1); // vo Ŭ���� ������ ���� ������ ����ϱ� ���� ���� ex) ProjectVO ---> project
		if(toRemoveFilePath.get(0) != null) {
			for(String removePath : toRemoveFilePath) {
				remove(removePath, dirName);
			}
		}

	}
	
	@Override
	public void remove(String filePath, String voName) {
		
		
		if(filePath == null){
			return;
		}
		
		int dirIndex = filePath.indexOf(voName);
		if (dirIndex == -1 ) {
			System.out.println("���ε� ù ��û");
			return;
		}
		
		String fixedPath = initRealPathController.getRealPath() + filePath.substring(dirIndex);
	
		
		
		File toRemoveFile = new File(fixedPath);
		if(toRemoveFile.exists()) {
			if(toRemoveFile.delete()) {
			
			}
		}
		else {

		}
		
		
	}
	
}
