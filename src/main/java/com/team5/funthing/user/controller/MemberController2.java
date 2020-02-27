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
		
		return "���� Ȯ��(���̵� �н������Է¿䱸) �������� �̵�.";
	}
	
	   @RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	   public String saveImage(@RequestParam(name ="imgname",required=false) List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   System.out.println("���̺��̹��� ���� ");
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
		   System.out.println("���̺��̹��� ���� ");
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

				
		if(toDoUploadList.get(0) != null) { // ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
			toRemoveFilePath.add(vo.getMyImage()); //���ŵ� ���ϰ�θ� vo��ü���� ��������
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
