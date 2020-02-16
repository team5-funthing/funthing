package com.team5.funthing.user.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

@Controller
@SessionAttributes("project")
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
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String showStartProjectPage(HttpSession session, Model model) {

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
		return "p-start-project"; // 시작하기 페이지로 이동하자
	} // 로그인 시에만 프로젝트 만들기 접근 가능하도록 하기위해 세션에 저장된 값 확인 후 페이지 이동.
	
	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(HttpSession session, ProjectVO vo, Model model) {
		
		session.removeAttribute("insertedProject");
		System.out.println("insertedProject 삭제");
		model.addAttribute("basicProjectSetting", vo);
		
		return "f-create-project-basic"; // 프로젝트 작성 폼
	} // 프로젝트 만들기 시작 페이지에서 수행
	
	@RequestMapping(value = "insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {
		
		// 프로젝트 제작 첫 시작시에만 시작
		ProjectVO checkVO = (ProjectVO)session.getAttribute("insertedProject");
		
		if(checkVO == null) {
			vo = insertProjectService.insertProject(vo);
			session.setAttribute("insertedProject", vo);
		}
		else {
			System.out.println("새로고침 확인 : " + checkVO.getProjectNo());
			vo = checkVO;
		}
		
		System.out.println("insertProject 또는 새로고침 실행 후 =======> " + vo.toString());
		model.addAttribute("writingProject", vo);

		return "f-create-project";
	} // 프로젝트 작성 시작할때 메서드 
	
	@RequestMapping(value = "saveInputWritingProject.udo", method = RequestMethod.POST)
	public String saveInputWritingProject(MultipartHttpServletRequest request,
											ProjectVO vo, 
											Model model) throws IOException {
		
		MultipartFile uploadImage = request.getFile("uploadImage");
		
		
		System.out.println(uploadImage == null);
		if(!uploadImage.isEmpty()) {
			String filename = uploadImage.getOriginalFilename();
			uploadImage.transferTo(new File("C:/funthing/projectTestUploadFiles/" + filename));
			
			vo.setProjectMainImage("C:/funthing/projectTestUploadFiles/" + filename);
		}
		
		System.out.println("저장하기 클릭 ====> " + vo.toString());
		
		
		vo.setWriteStatus(writingInputCheck(vo));
		updateProjectService.updateProject(vo);
	
		model.addAttribute("writingProject", vo);
		model.addAttribute("msg", "저장 되었습니다");
		
		return "f-create-project";
	} // 작성중인 프로젝트 저장하기.
	
	
	@RequestMapping(value = "showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO vo, Model model) {
		
		model.addAttribute("previewProject", vo);
		
		return "p-project-details";
	}// 프로젝트 미리보기 이동.


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
				project.getProjectSummary() == null || project.getProjectSummary() == "" 
			) 
		{
			return false;
			
		}
		else {
			
			return true;
			
		}
	}
		
	
	
	
	
	
	
	
	
	
	
}
















