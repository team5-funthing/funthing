package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.memberService.DeleteMemberService;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.memberService.InsertImageService;
import com.team5.funthing.user.service.memberService.UpdateMemberService;

@Controller
public class MemberController2 {

	@Autowired
	GetMemberService getMemberService;
	@Autowired
	UpdateMemberService updateMemberService;
	@Autowired
	DeleteMemberService deleteMemberService;
	@Autowired
	InsertImageService insertImageService;
	@Autowired
	UploadUtil upload;
	
	
	@RequestMapping(value = "updateMember.udo",method= RequestMethod.GET)
		public String updateProfile(MemberVO vo,HttpSession session) {
		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		updateMemberService.updateMember(vo);
		return "p-index";
	}
	
	
	@RequestMapping(value="deleteCheckMember.udo",method=RequestMethod.GET)
	public String deleteMember(MemberVO vo,HttpSession session) {
		
		return "삭제 확인(아이디 패스워드입력요구) 페이지로 이동.";
	}
	
	   @RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	   public String saveImage(@RequestParam(name ="imgname",required=false) List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   System.out.println("세이브이미지 실행 ");
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);
	        insertImageService.insertImage(vo);
	        getMemberService.getMember(vo);
	        session.setAttribute("memberSession", vo);
	        
	      return "p-index";
	   }

	   @RequestMapping(value="saveimage2.udo",method=RequestMethod.POST)
	   public String saveImage2(@RequestParam(name ="imgname",required=false) List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   System.out.println("세이브이미지 실행 ");
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);
	        insertImageService.insertImage(vo);
	        getMemberService.getMember(vo);
	        session.setAttribute("memberSession", vo);
	        
	      return "f-update-profile";
	   }

	
	
	public void memberImageUploader(List<MultipartFile> toDoUploadList, MemberVO vo) throws Exception {
		
		List<String> toRemoveFilePath = new ArrayList<String>();

				
		if(toDoUploadList.get(0) != null) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			toRemoveFilePath.add(vo.getMyImage()); //제거될 파일경로를 vo객체에서 가져오기
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = upload.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) return;
			
			int cnt = 1;
			for(String toInsertImage : toSettingPath) {
				System.out.println("cnt : " + cnt++);
				vo.setMyImage(toInsertImage);
			}
		}
	}
	
}
