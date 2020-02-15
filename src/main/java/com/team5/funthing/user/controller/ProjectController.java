package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.GetMemberService;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;
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
	private GetProjectService getProjectService;
	
	@Autowired
	private GetMemberService getMemberService;
	
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
	
	
	
	@RequestMapping(value = "/getWritingProject.udo", method = RequestMethod.POST)
	public String getWritingProject(@RequestParam("currentWritingProject")
									ProjectVO vo, Model model) {
		
		model.addAttribute("writingProject", getProjectService.getProject(vo));
		model.addAttribute("msg", "저장 되었습니다.");
		
		System.out.println("------getWritingProject-----");
		System.out.println(vo.toString());
		
		return "f-create-project";
	}
	
	@RequestMapping(value = "/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(ProjectVO vo,
								Model model,
								RedirectAttributes redirect,
//								@RequestParam(value = "projectMainImage", required = false)MultipartFile projectMainImage,
								@RequestParam(value = "projectVideo", required = false)MultipartFile projectVideo
								) {		 
		System.out.println(vo.toString());
		char result = writingInputCheck(vo);
		System.out.println("결과 : " + result);
		vo.setWriteStatus(result);// 작성완료 체크하여 'y' 또는 'n' 값을 vo에 넣어줌
		
		insertProjectService.insertProject(vo);
		
		redirect.addAttribute("currentWritingProject", vo);
		
		return "redirect:getWritingProject.udo";
		
	}
	
	

	
	
	@RequestMapping(value="/createProject.udo", method = RequestMethod.POST)
	public String createProject(ProjectVO vo, Model model) {
		System.out.println("==> createProject.udo 실행");
		return null;
	}

	public String updateProject(ProjectVO vo) {
		return null;
	}
	

	public String deleteProject(ProjectVO vo) {
		return null;
	}
	
	
	
	//----------------------------------------------------------------------
	
	public char writingInputCheck(ProjectVO vo) {
		
		boolean result = nullCheck(vo);
		
		if(result) {
			return 'y';
		}
		
		return 'n';
	}
	
	
	public boolean nullCheck(ProjectVO project) {
		// 추후에 이미지, 홍보 영상, 동의  등 체크 변수에 추가해야한다. 
		if(
				project.getGoalMoney() == 0 ||
				project.getProjectTitle() == null || project.getProjectTitle() == "" || 
				project.getProjectSubTitle() == null || project.getProjectSubTitle() == "" ||
				project.getProjectStory() == null || project.getProjectStory() == "" ||
				project.getProjectDetail() == null || project.getProjectDetail() == "" || 
				project.getProjectCaution() == null || project.getProjectDetail() == "") {
			
			
			return false;
			
		}
		else {
			
			return true;
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
















