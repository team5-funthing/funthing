//package com.team5.funthing.common.utils.uploadUtils;
//
//import java.io.File;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.multipart.MultipartFile;
//import net.coobird.thumbnailator.Thumbnails;
//
//@Component
//public class ProjectMainImageUploadUtilsImpl_bak implements UploadFileUtils {
//
//	@Autowired
//	private InitRealPathController initRealPathController;
//	
//	
//	private Map<String, String> toSavePathMap; 
//
//	static final int THUMB_WIDTH = 300;
//	static final int THUMB_HEIGHT = 300;
//
//	@Override
//	public String upload(MultipartFile uploadFile, String voName, String toRemoveFilePath) throws Exception {
//		
//		
//		String temp = voName.replace("VO", "");
//		String dirName = File.separator + temp.substring(0, 1).toLowerCase() + temp.substring(1); // vo Ŭ���� ������ ���� ������ ����ϱ� ���� ���� ex) ProjectVO ---> project
//
//		//�̹��� �ٲٱ� �ÿ� ���� �Ǵ� �޼���
//		remove(toRemoveFilePath, voName);
//		
//		String realPath = initRealPathController.getRealPath(); // ���ε� ������ ���� ����� ���
//		String dirPath = calcPath(realPath, dirName); // 
//		String fileName = null;
//		
//		//��ο� ���� ���� �� ���� ���� �ڵ�
//		if(uploadFile != null) {
//			fileName = fileUpload(realPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), dirPath);
//
//		}else {
//			System.out.println("���ε� �� ���� ���� ���� ");
//			return null;
//		}
//
////		"thumbnail" + File.separator + "thumb_" + fileName
//		String finalPath = File.separator + "funthing" + File.separator + "resources" + File.separator + "upload" + dirPath + File.separator + fileName;
//
//
//
//		return finalPath; //DB�� ������ ���
//
//	}
//
//	@Override
//	public String fileUpload(String realPath, String fileName, byte[] fileData, String dirPath) throws Exception{
//
////		System.out.println("----------fileUpload-------- ");
////		System.out.println("realPath : " + realPath);
////		System.out.println("fileName : " + fileName);
////		System.out.println("fileData : " + fileData);
////		System.out.println("dirPath : " + dirPath);
////		System.out.println("----------------------------- ");
//
//		// UUID '-' �����Ͽ� ������ ����
//		String uuid = UUID.randomUUID().toString().replace("-", "");
//
//		String newFileName = uuid + "_" + fileName; // ���ε� �� ����� ���ϸ� ���� 
//		String imgPath = realPath + dirPath; // ���� ��θ� year, month, day�� ����
//
//		File target = new File(imgPath, newFileName);
//		FileCopyUtils.copy(fileData, target); // ����Ͽ� �̹����� ��������� ����
//		String thumbFileName = "thumb_" + newFileName; // ��ο� ����� ������ thunmb�� ����
//
//
//		File image = new File(imgPath + File.separator + newFileName); // �̹����� ���� ��η� ���� ����
//		File thumbnail = new File(imgPath + File.separator + "thumbnail" + File.separator + thumbFileName); // ����
//
//
//		if (image.exists()) {
//			thumbnail.getParentFile().mkdirs();
//			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail); // ����Ϸ����� �޼��� ���
//		}
//		return newFileName; 
//
//
//	}
//
//	@Override
//	public String calcPath(String realPath, String dirName) {
//		Calendar cal = Calendar.getInstance();
//		String yearPath = dirName + File.separator + cal.get(Calendar.YEAR);           
//		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
//		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
//
//		makeDir(realPath, dirName, yearPath, monthPath, datePath); // ������Ʈ ���� �̹�����
//		makeDir(realPath, dirName, yearPath, monthPath, datePath + "\\thumbnail"); // ������Ʈ �����
//
//		return datePath;
//	}
//
//
//	//���� ���� ���ִ� �޼���
//	@Override
//	public void makeDir(String realPath, String... paths) {
//
//		if(new File(paths[paths.length - 1]).exists()) {
//			return; 
//		}
//
//		for(String path : paths) {
//			File dirPath = new File(realPath + path);
//			if (!dirPath.exists()) {
//				dirPath.mkdir();
//			}
//		}
//
//	}
//	
//	//���� ���� �޼��� remove('������ ���� path', '���ε��� ��ΰ� �ִ� �����̸�')
//	@Override
//	public void remove(String filePath, String voName) {
//		
//		// dirIndex�� -1�� ������ ���ε带 ó�� ��û�ϴ� ��Ȳ�̹Ƿ�  �ٷ� return: �޼��� ����
//		int dirIndex = filePath.indexOf(voName);
//		if (dirIndex == -1 ) {
//			System.out.println("���ε� ù ��û");
//			return;
//		}
//		
//		String fixedPath = initRealPathController.getRealPath() + filePath.substring(dirIndex);
//		System.out.println("fixedPath : " + fixedPath);
//		
//		
//		File toRemoveFile = new File(fixedPath);
//		if(toRemoveFile.exists()) {
//			if(toRemoveFile.delete()) {
//				System.out.println("���� �Ϸ�");
//			}
//		}
//		else {
//			System.out.println("��ο� ������ �����ϴ�.");
//		}
//		
//		
//	}
//	
//}
