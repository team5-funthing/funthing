package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("deleteMember.udo")
	public String deleteMember(MemberVO vo,HttpSession session) {
		deleteMemberService.deleteMember(vo);
		Cookie cookieid = new Cookie("funthingCookieId",null);
		cookieid.setMaxAge(0);  /// kill the cookie 
		Cookie cookiepw = new Cookie("funthingCookiePw",null);
		cookiepw.setMaxAge(0); /// kill the cookie
		session.invalidate();
		return "p-index";
	}
	
	@RequestMapping(value = "updateMember.udo",method= RequestMethod.GET)
		public String updateProfile(MemberVO vo,HttpSession session) {
		System.out.println(vo.toString());
		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		updateMemberService.updateMember(vo);
		session.setAttribute("memberSession", vo);
		return "p-index";
	}
	
	@RequestMapping(value="updateCheck.udo",method=RequestMethod.POST)
	public String pwCheck(String pw,Model model,MemberVO vo,HttpSession session){
		System.out.println("pw :"+pw);
		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		System.out.println("vo :"+vo.toString());
		getMemberService.getMember(vo);
		System.out.println("getMemberService.getMember(vo) :"+vo.toString());
		if(getMemberService.getMember(vo).getPassword().equals(pw)) {
			model.addAttribute("result","1");
			System.out.println(vo.getPassword());
		}else {
			model.addAttribute("result","2");
			System.out.println(vo.getPassword());
		}
		return "callback";
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
		   System.out.println("���̺��̹��� ���� " + vo.toString());
		   System.out.println("���� ������ �Ѿ�� �̹��� ���� :"+uploadFile.toString());
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);
	        insertImageService.insertImage(vo);
	        getMemberService.getMember(vo);
	        session.setAttribute("memberSession", vo);
	        
	      return "f-update-profile";
	   }

	

//
	   
	   
	   
	   
	   
	   
	public void memberImageUploader(List<MultipartFile> toDoUploadList, MemberVO vo) throws Exception {
		System.out.println("memberImageUploader ����");
		List<String> toRemoveFilePath = new ArrayList<String>();
          
				
		if(toDoUploadList.get(0) != null) { // ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��  
			toRemoveFilePath.add(vo.getMyImage()); //���ŵ� ���ϰ�θ� vo��ü���� ��������
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = upload.upload(toDoUploadList, voName, toRemoveFilePath);
			if(toSettingPath == null) { System.out.println("�̹��� ���ε� �ȵ�"); return;}
			
			int cnt = 1;
			for(String toInsertImage : toSettingPath) {
				System.out.println("cnt : " + cnt++);
				vo.setMyImage(toInsertImage);
			}
		}
	}
	
}
