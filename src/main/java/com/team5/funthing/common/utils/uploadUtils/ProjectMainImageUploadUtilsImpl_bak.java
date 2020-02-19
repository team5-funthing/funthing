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
//		String dirName = File.separator + temp.substring(0, 1).toLowerCase() + temp.substring(1); // vo 클래스 네임을 폴더 명으로 사용하기 위한 변수 ex) ProjectVO ---> project
//
//		//이미지 바꾸기 시에 수행 되는 메서드
//		remove(toRemoveFilePath, voName);
//		
//		String realPath = initRealPathController.getRealPath(); // 업로드 파일의 실제 저장될 경로
//		String dirPath = calcPath(realPath, dirName); // 
//		String fileName = null;
//		
//		//경로에 따른 폴더 및 파일 생성 코드
//		if(uploadFile != null) {
//			fileName = fileUpload(realPath, uploadFile.getOriginalFilename(), uploadFile.getBytes(), dirPath);
//
//		}else {
//			System.out.println("업로드 할 파일 없이 실행 ");
//			return null;
//		}
//
////		"thumbnail" + File.separator + "thumb_" + fileName
//		String finalPath = File.separator + "funthing" + File.separator + "resources" + File.separator + "upload" + dirPath + File.separator + fileName;
//
//
//
//		return finalPath; //DB에 저장할 경로
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
//		// UUID '-' 제거하여 변수에 저장
//		String uuid = UUID.randomUUID().toString().replace("-", "");
//
//		String newFileName = uuid + "_" + fileName; // 업로드 시 사용할 파일명 설정 
//		String imgPath = realPath + dirPath; // 폴더 경로를 year, month, day로 셋팅
//
//		File target = new File(imgPath, newFileName);
//		FileCopyUtils.copy(fileData, target); // 썸네일용 이미지를 만들기위해 복사
//		String thumbFileName = "thumb_" + newFileName; // 경로에 복사된 파일을 thunmb로 지정
//
//
//		File image = new File(imgPath + File.separator + newFileName); // 이미지가 들어가는 경로로 파일 생성
//		File thumbnail = new File(imgPath + File.separator + "thumbnail" + File.separator + thumbFileName); // 생성
//
//
//		if (image.exists()) {
//			thumbnail.getParentFile().mkdirs();
//			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail); // 썸네일레이터 메서드 사용
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
//		makeDir(realPath, dirName, yearPath, monthPath, datePath); // 프로젝트 메인 이미지용
//		makeDir(realPath, dirName, yearPath, monthPath, datePath + "\\thumbnail"); // 프로젝트 썸네일
//
//		return datePath;
//	}
//
//
//	//폴더 생성 해주는 메서드
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
//	//파일 삭제 메서드 remove('삭제할 파일 path', '업로드한 경로가 있는 폴더이름')
//	@Override
//	public void remove(String filePath, String voName) {
//		
//		// dirIndex에 -1이 들어오면 업로드를 처음 요청하는 상황이므로  바로 return: 메서드 종료
//		int dirIndex = filePath.indexOf(voName);
//		if (dirIndex == -1 ) {
//			System.out.println("업로드 첫 요청");
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
//				System.out.println("삭제 완료");
//			}
//		}
//		else {
//			System.out.println("경로에 파일이 없습니다.");
//		}
//		
//		
//	}
//	
//}
