package com.team5.funthing.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team5.funthing.user.memberService.CertificationEmailService;
import com.team5.funthing.user.memberService.GetMemberService;
import com.team5.funthing.user.memberService.InsertImageService;
import com.team5.funthing.user.memberService.InsertMemberService;
import com.team5.funthing.user.memberService.InsertSocialMemberService;
import com.team5.funthing.user.model.vo.MemberVO;

@Controller
@SessionAttributes("member")
public class MemberController {

	@Autowired
	private CertificationEmailService certificationEmailService;


	@Autowired
	private GetMemberService getMemberService;


	@Autowired
	private InsertMemberService insertMemberService;
	@Autowired
	private InsertSocialMemberService insertSocialMemberService;
	@Autowired
	private InsertImageService insertImageService;

	@RequestMapping("*.udo")
	public String showindex() {
		return "p-index";
	}

	@RequestMapping(value="socialLogin.udo",method=RequestMethod.GET)
	public String socialLogin() {   
		return "f-socialjoin";
	}
	@RequestMapping(value="socialLoginSuccess.udo",method=RequestMethod.POST)
	public String socialLoginSuccess(HttpServletRequest request,HttpSession session,MemberVO vo) {   
		System.out.println("socialLoginSuccess.udo ����");
		//   session.invalidate();  // �α��� �� �����ʱ�ȭ 
		System.out.println("�Ҽ� �н����� :"+getMemberService.getMember(vo).getPassword());
		if(getMemberService.getMember(vo) != null) { //vo�� ���̾ƴҶ� �α��� ������
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { //�н����� �¾�����  
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage());   
				System.out.println(getMemberService.getMember(vo).getMyImage());
				System.out.println("�Ҽȷα��� ����");

				return "p-index";
			}else {
				System.out.println("�Ҽȷα��� ����");
				return "p-waytoJoin-select";   //������ ���� �� ���°�. 
			}
		}else { //vo�� ���϶� �α��� ���н�
			System.out.println("�Ҽȷα��� ����");
			return "p-waytoJoin-select";
		}

	}


	@RequestMapping(value="getMember.udo", method=RequestMethod.POST) // �α���Ȯ��
	public String getMember(MemberVO vo, HttpServletRequest request,HttpSession session) {
		System.out.println("getMember.udo ����");
		if(getMemberService.getMember(vo) != null) { //vo�� ���̾ƴҶ� �α��� ������
			if(getMemberService.getMember(vo).getPassword().equals(request.getParameter("password"))) { //�н����� �¾�����  
				session.setAttribute("memberSessionEmail", getMemberService.getMember(vo).getEmail());
				session.setAttribute("memberSessionName", getMemberService.getMember(vo).getName());
				session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage()); //�α������ڸ��� �����ߵǼ� �߰��� �̰Ը´°ǰ���?����?Ȯ��


				System.out.println(getMemberService.getMember(vo).getMyImage());
				System.out.println("����");

				return "p-index";
			}else {
				System.out.println("����");
				return "p-index";
			}
		}else { //vo�� ���϶� �α��� ���н�
			return "p-index";
		}

	}


	@RequestMapping(value="joinselect.udo" ,method=RequestMethod.GET) // ȸ�����Լ��� ȭ���̵�
	public String login() {
		return "p-waytoJoin-select";
	}


	@RequestMapping(value="findpw.udo",method=RequestMethod.GET) // ��й�ȣ ã�� ȭ���̵�
	public String findpw() {
		return "f-find-pw";
	}

	@RequestMapping(value="emailJoin.udo",method=RequestMethod.GET) // ���Ϸΰ����ϱ� ȭ���̵�
	public String emailjoin() {
		return "f-join";
	}

	@RequestMapping(value="successSocialjoin.udo",method=RequestMethod.GET) // ���Լ����ؼ� ����ȭ���̵�
	public String successSocialjoin(MemberVO vo) {
		insertSocialMemberService.insertSocialMember(vo);
		return "p-index";
	}

	@RequestMapping(value="successjoin.udo",method=RequestMethod.POST) // ���Լ����ؼ� ����ȭ���̵�
	public String successjoin(MemberVO vo) {
		System.out.println("�̸��Ϸ� ���� ����!");
		insertMemberService.insertMember(vo);
		return "p-index";
	}

	@RequestMapping(value="socialjoin.udo",method=RequestMethod.GET)
	public String naverJoin(MemberVO vo,HttpServletRequest request) {
		return "f-socialjoin";
	}

	@RequestMapping(value= "certification.udo" ,method=RequestMethod.GET )
	public String certificationEmail(MemberVO vo,Model model,HttpSession session) {
		try {
			certificationEmailService.sendCertificationEmail(vo);
			session.setAttribute("certificationCode", vo.getCertificationCode());   
			System.out.println("vo ������ȣ Ȯ�� :" +vo.getCertificationCode());
			System.out.println("session ������ȣ Ȯ�� : "+ session.getAttribute("certificationCode"));
			/// ��й�ȣ �缳�� ���������� ���� ���� �ϵ��� !!!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "f-find-id";
	}

	@RequestMapping(value="test.udo")
	public String tst(Model model) {

		model.addAttribute("test", "�̰͵� �¾�");
		return "testing";
	}

	@RequestMapping(value="imageUpload.udo",method=RequestMethod.GET)
	public String imageUpload() {
		//���ε带 ���� ���� ������
		return "imageUpload";
	}

	@RequestMapping(value="saveimage.udo",method=RequestMethod.POST)
	public String saveImage(HttpServletRequest request,MemberVO vo,HttpSession session) throws IOException {

		//  ���丮��    �����ؾ���.  ������ �����η� �����ؾ��ϸ�, �켱 ������� ��η� ��µ���.
		//      String saveDir= "C:\\funthing\\project\\funthing\\src\\main\\webapp\\resources\\user\\img\\test";
		String saveDir= "C:\\tomcat\\wtpwebapps\\funthing\\resources\\user\\img\\test";
		int maxPostSize = 3*1024*1024;
		String encoding = "UTF-8";
		MultipartRequest ms = new MultipartRequest(request, saveDir, maxPostSize, encoding, new DefaultFileRenamePolicy());  
		String renamedFile = ms.getFilesystemName("filename");
		System.out.println( ms.getFilesystemName("filename"));     
		///  �������� ���� ����!!! �� ����.     

		String email = (String) session.getAttribute("memberSessionEmail");
		vo.setEmail(email);
		vo.setMyImage(renamedFile);
		insertImageService.insertImage(vo);
		//  session.setAttribute("myprofile", getMemberService.getMember(vo).getMyImage());

		return "p-index";
	}

	@RequestMapping(value="mypage.udo",method=RequestMethod.GET)
	public String myPage(HttpSession session,MemberVO vo,Model model) { //������������ �̵� 

		//       
		//     String email =  (String)session.getAttribute("memberSessionEmail");
		//     vo.setEmail(email);
		//     model.addAttribute("okname",getMemberService.getMember(vo).getName());
		//     //  p-detail-mypage �� �����̷�Ʈ �����  �Ķ���Ͱ�  okname=getMemberService.getMember(vo).getName() �� �Ѱ���
		return "p-detail-mypage";
	}  
	@RequestMapping(value="logout.udo",method=RequestMethod.GET)
	public String logOut(HttpSession session) { //�α׾ƿ� 
		session.invalidate();
		return "p-index";
	}    



}
