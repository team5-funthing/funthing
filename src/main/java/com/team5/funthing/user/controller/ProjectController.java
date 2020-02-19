package com.team5.funthing.user.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.team5.funthing.common.utils.uploadUtils.InitRealPathController;
import com.team5.funthing.common.utils.uploadUtils.UploadUtil;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;


/**
 * 
 * 
 * 
 * 
 * @author qpara
 * 
 * 
 * 
 *
 */


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
	
	@Autowired
	private UploadUtil projectMainImageUploadUtils;
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String showStartProjectPage(HttpSession session, Model model) {
		
		// 테스트 용 코드
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
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
		model.addAttribute("basicProjectSetting", vo);
		
		return "f-create-project-basic"; // 프로젝트 작성 폼
	} // 프로젝트 만들기 시작 페이지에서 수행
	
	
	
	@RequestMapping(value = "insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {
		
		// 프로젝트 제작 첫 시작시에만 시작
		ProjectVO checkVO = (ProjectVO)session.getAttribute("insertedProject");
		
		
		// 새로고침을 할 경우에 반복적으로 requestMapping 작업이 수행되는 부분을 방지하기 위한 코드
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
	public String saveInputWritingProject(@RequestParam(name = "uploadImage")MultipartFile uploadFile, ProjectVO vo, Model model) throws Exception {

		
		// 업로드 시킨 파일이 이미 존재하는 경우 파일 선택을 다시 안한 경우에 나올 수 있는 상황 처리
		// 업로드 이미지를 변경할 경우
		if(!uploadFile.isEmpty()) { 
			
			//제거될 파일경로를 vo객체에서 가져오기
			String toRemoveFilePath = vo.getProjectMainImage();
			
			String voName = vo.getClass().getSimpleName();
			String toSettingPath = projectMainImageUploadUtils.upload(uploadFile, voName, toRemoveFilePath);
			
			vo.setProjectMainImage(toSettingPath);
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
















