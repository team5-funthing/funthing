package com.team5.funthing.common.utils.uploadUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
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
	public String upload(MultipartFile uploadFile, String voName, String toRemoveFilePath) throws Exception {
		
		String temp = voName.replace("VO", "");
		String dirName = File.separator + temp.substring(0, 1).toLowerCase() + temp.substring(1); // vo Ŭ���� ������ ���� ������ ����ϱ� ���� ���� ex) ProjectVO ---> project

		//�̹��� �ٲٱ� �ÿ� ���� �Ǵ� �޼���
		remove(toRemoveFilePath, dirName);
		
		String realPath = initRealPathController.getRealPath(); // ���ε� ������ ���� ����� ���
		String dirPath = calcPath(realPath, dirName); // 
		String fileName = null;
		
		//��ο� ���� ���� �� ���� ���� �ڵ�
		if(uploadFile != null) {
			fileName = fileUpload(realPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), dirPath);
		}else {
			System.out.println("���ε� �� ���� ���� ���� ");
			return null;
		}
		
		//DB�� ������ ���
		return File.separator + "funthing" + File.separator + "resources" + File.separator + "upload" + dirPath + File.separator + fileName; 


	}

	@Override
	public String fileUpload(String realPath, String fileName, byte[] fileData, String dirPath) throws Exception{

		// UUID '-' �����Ͽ� ������ ����
		String uuid = UUID.randomUUID().toString().replace("-", "");

		String newFileName = uuid + "_" + fileName; // ���ε� �� ����� ���ϸ� ���� 
		String imgPath = realPath + dirPath; // ���� ��θ� year, month, day�� ����
		
		File image = new File(imgPath + File.separator + newFileName);
		FileCopyUtils.copy(fileData, image); // �̹����� ���� ��η� ���� ����
		
		if (image.exists()) {
			System.out.println("���ε� ����");
		}
		
		return newFileName; 


	}

	@Override
	public String calcPath(String realPath, String dirName) {
		Calendar cal = Calendar.getInstance();
		String yearPath = dirName + File.separator + cal.get(Calendar.YEAR);           
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(realPath, dirName, yearPath, monthPath, datePath); // ������Ʈ ���� �̹�����

		return datePath;
	}


	//���� ���� ���ִ� �޼���
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
	
	//���� ���� �޼��� remove('������ ���� path', '���ε��� ��ΰ� �ִ� �����̸�')
	@Override
	public void remove(String filePath, String voName) {
		
		// dirIndex�� -1�� ������ ���ε带 ó�� ��û�ϴ� ��Ȳ�̹Ƿ�  �ٷ� return: �޼��� ����
		int dirIndex = filePath.indexOf(voName);
		if (dirIndex == -1 ) {
			System.out.println("���ε� ù ��û");
			return;
		}
		
		String fixedPath = initRealPathController.getRealPath() + filePath.substring(dirIndex);
		System.out.println("fixedPath : " + fixedPath);
		
		
		File toRemoveFile = new File(fixedPath);
		if(toRemoveFile.exists()) {
			if(toRemoveFile.delete()) {
				System.out.println("���� �Ϸ�");
			}
		}
		else {
			System.out.println("��ο� ������ �����ϴ�.");
		}
		
		
	}
	
}
