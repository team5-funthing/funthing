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
	
//	프로젝트 
//	   1) void createProject ( ProjectVO vo )  - 프로젝트 생성 메서드
//	      - void insertProject ( ProjectVO vo ) PROJECTNO - 프로젝트 입력/임시저장 메서드
//	      - void updateProject ( ProjectVO vo ) PROJECTNO - 프로젝트 수정 메서드
//	   2) void deleteProject ( ProjectVO vo ) PROJECTNO - 프로젝트 삭제 메서드
//	       * 해당 메서드 호출시 projectCount, projectAccountInfomation,Reward,ReservationManagement
//			       report, projectBoard관련 테이블의 동일한 프로젝트 번호에 대해 레코드 삭제
	
	
	//작성중인 프로젝트 화면 가져오기
	@RequestMapping(value="/showCreateProjectForm.udo", method = RequestMethod.GET)
	public String showCreateProjectForm(HttpSession session, Model model) {

		
		// 테스트 용 코드
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
		test = getMemberService.getMember(test);
		session.setAttribute("email", test.getEmail());
		
		String loginId = (String)session.getAttribute("email");
		
		if(loginId == null) {
			model.addAttribute("msg", "로그인 후 이용 가능합니다.");
			return "p-index";
		}
		
		model.addAttribute("member", test); 
		return "f-create-project";
	}
	
	
	
	
	@RequestMapping(value="/createProject.udo", method = RequestMethod.POST)
	public String createProject(ProjectVO vo, Model model) {
		System.out.println("==> createProject.udo 실행");
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
		model.addAttribute("msg", "저장 되었습니다.");
		
		return "f-create-project";
		
	}
	
	
	
	
//	// 해당 메서드는 부분 작성 완료 시에 실행되는 메서드
//	@RequestMapping(value="/insertProject.udo", method = RequestMethod.POST)
//	public String insertProject(ProjectVO vo, Model model){
//		System.out.println(vo.toString());
//		model.addAttribute("writingProject", vo);
//		model.addAttribute("msg", "저장 되었습니다.");
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
















