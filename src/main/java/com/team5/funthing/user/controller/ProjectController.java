package com.team5.funthing.user.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.GetMemberService;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

@Controller
public class ProjectController {

	@Autowired
	private CreateProjectService createProjectService;
	@Autowired
	private InsertProjectService insertProjectService;
	@Autowired
	private UpdateProjectService updateProjectService;
	@Autowired
	private DeleteProjectService deleteProjectService;
	
	@Autowired
	private GetMemberService getMemberService;
	
//	������Ʈ 
//	   1) void createProject ( ProjectVO vo )  - ������Ʈ ���� �޼���
//	      - void insertProject ( ProjectVO vo ) PROJECTNO - ������Ʈ �Է�/�ӽ����� �޼���
//	      - void updateProject ( ProjectVO vo ) PROJECTNO - ������Ʈ ���� �޼���
//	   2) void deleteProject ( ProjectVO vo ) PROJECTNO - ������Ʈ ���� �޼���
//	       * �ش� �޼��� ȣ��� projectCount, projectAccountInfomation,Reward,ReservationManagement
//			       report, projectBoard���� ���̺��� ������ ������Ʈ ��ȣ�� ���� ���ڵ� ����
	
	
	//�ۼ����� ������Ʈ ȭ�� ��������
	@RequestMapping(value="/showCreateProjectForm.udo", method = RequestMethod.GET)
	public String showCreateProjectForm(HttpSession session, Model model) {

		
		// �׽�Ʈ �� �ڵ�
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
		test = getMemberService.getMember(test);
		session.setAttribute("email", test.getEmail());
		
		String loginId = (String)session.getAttribute("email");
		
		if(loginId == null) {
			model.addAttribute("msg", "�α��� �� �̿� �����մϴ�.");
			return "p-index";
		}
		
		model.addAttribute("member", test); 
		return "f-create-project";
	}
	
	
	
	
	@RequestMapping(value="/createProject.udo", method = RequestMethod.POST)
	public String createProject(ProjectVO vo, Model model) {
		System.out.println("==> createProject.udo ����");
		return null;
	}
	
	
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject( ProjectVO vo, 
									Model model,
//									MultipartHttpServletRequest request,
									@RequestParam(value = "projectMainImage", required = false)MultipartFile projectMainImage,
									@RequestParam(value = "projectVideo", required = false)MultipartFile projectVideo
									) {		
		
		System.out.println(vo.toString());
		model.addAttribute("writingProject", vo);
		model.addAttribute("msg", "���� �Ǿ����ϴ�.");
		
		return "f-create-project";
		
	}
	
	
	
	
//	// �ش� �޼���� �κ� �ۼ� �Ϸ� �ÿ� ����Ǵ� �޼���
//	@RequestMapping(value="/insertProject.udo", method = RequestMethod.POST)
//	public String insertProject(ProjectVO vo, Model model){
//		System.out.println(vo.toString());
//		model.addAttribute("writingProject", vo);
//		model.addAttribute("msg", "���� �Ǿ����ϴ�.");
//		
//		return "f-create-project";
//	}

	
	public String updateProject(ProjectVO vo) {
		return null;
	}
	

	public String deleteProject(ProjectVO vo) {
		return null;
	}
	
}
















