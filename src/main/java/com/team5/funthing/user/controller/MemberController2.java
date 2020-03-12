package com.team5.funthing.user.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "updateMember.udo",method= RequestMethod.POST)
		public String updateProfile(MemberVO vo,HttpSession session,Model model) {
		//form으로부터 받아온 정보를 확인한다.
		System.out.println(vo.toString());
		System.out.println("updateMember.udo 변경하려는 비밀번호 : " + vo.getPassword());
		
		//변경을 위해 입력한 비밀번호를 암호화한다.
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(vo.getPassword());
		System.out.println("updateMember.udo 암호화된 비밀번호 : " + encodedPassword);
		
		//암호화한 비밀번호를 담은 객체를 통하여 회원정보를 변경한다.
		vo.setPassword(encodedPassword);
		updateMemberService.updateMember(vo);
		//기존의 비밀번호에 대한 세션을 지우고 변경된 정보의 세션을 저장한다.
		session.removeAttribute("memberSession");
		session.setAttribute("memberSession", vo);
		model.addAttribute("ok","1");
		return "f-update-profile";
	}
	
	@RequestMapping(value="updateCheck.udo",method=RequestMethod.POST)
	public String pwCheck(String pw,Model model,MemberVO vo,HttpSession session){
		//현재 db에 등록되어있는 비밀번호와 세션을 받아온다.
		System.out.println("pw :"+pw);
		MemberVO insertedMember = (MemberVO) session.getAttribute("memberSession");
		System.out.println("updateCheck.udo 세션으로 부터 얻어온 비밀번호 : " + insertedMember.getPassword());
		
		//세션의 비밀번호로부터 Member의 정보를 받아온다.
//		vo.setEmail(insertedMember.getEmail());
//		System.out.println("vo :"+vo.toString());
//		getMemberService.getMember(vo);
//		System.out.println("getMemberService.getMember(vo) :"+vo.toString());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(pw, insertedMember.getPassword())) {
			model.addAttribute("result","1");
			System.out.println("리턴으로 1감");
		}else {
			model.addAttribute("result","2");
			System.out.println(vo.getPassword());
		}
		return "ajax/callback";
	}

	
	   @RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	   @ResponseBody
	   public String saveImage(@RequestParam(name ="imgname") List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   System.out.println("세이브이미지 실행 ");
		   System.out.println("비었느냐:" +uploadFile.get(0).getOriginalFilename());
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);
	        insertImageService.insertImage(vo);
	        session.setAttribute("memberSession", getMemberService.getMember(vo));
	        
	      return "1";
	   }

	   @RequestMapping(value="saveimage2.udo",method=RequestMethod.POST)
	   public String saveImage2(@RequestParam(name ="imgname") List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   System.out.println("세이브이미지 실행 ");
		   System.out.println("비었느냐:" +uploadFile.get(0).getOriginalFilename());
		   MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		   vo.setEmail(vo2.getEmail());
	       memberImageUploader(uploadFile, vo);
	        insertImageService.insertImage(vo);
	        session.setAttribute("memberSession", getMemberService.getMember(vo));
	        
	        return "f-update-profile";
	   }
	   
	   


	   @RequestMapping(value="deleteimage.udo",method=RequestMethod.POST)
	   public String civa(@RequestParam(name ="imgname") List<MultipartFile> uploadFile,MemberVO vo,HttpSession session) throws Exception {
		   MemberVO vo2  = (MemberVO)session.getAttribute("memberSession");
		 File file = new File(vo2.getMyImage());
		 if(file.exists()) {
			 file.delete();
		 }
		 vo2.setMyImage("");
		 session.setAttribute("memberSession", vo2);
	      return "f-update-profile";
	   }

//
	   

	   
	   
	   
	public void memberImageUploader(List<MultipartFile> toDoUploadList, MemberVO vo) throws Exception {
		System.out.println("memberImageUploader 실행");
		List<String> toRemoveFilePath = new ArrayList<String>();
          
				
		if(!toDoUploadList.get(0).isEmpty()) { // 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리  
			toRemoveFilePath.add(vo.getMyImage()); //제거될 파일경로를 vo객체에서 가져오기
			String voName = vo.getClass().getSimpleName();
			List<String> toSettingPath = upload.upload(toDoUploadList, voName, toRemoveFilePath);
            System.out.println("리턴은 들어오지? ㅇㅇ"+upload.upload(toDoUploadList, voName, toRemoveFilePath));
			
			if(toSettingPath == null) { System.out.println("이미지 업로드 안됨"); return;}
			
			int cnt = 1;
			for(String toInsertImage : toSettingPath) {
				System.out.println("cnt : " + cnt++);
				vo.setMyImage(toInsertImage);
			}
		}else {
		}
		
	}
	
}
