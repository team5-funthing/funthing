package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

//@Controller
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
	
	
	
	
	
	@RequestMapping(value="/showCreateProjectBasicFrom.udo", method = RequestMethod.GET)
	public String showCreateProjectForm(HttpSession session, Model model) {
		return "f-create-project-basic"; // 프로젝트 작성 폼
	} 
	
	@RequestMapping(value = "insertProject.udo", method = RequestMethod.POST)
	public String insertProject(ProjectVO vo, Model model) {
		
		
		// 프로젝트 제작 첫 시작시에만 시작
		vo = insertProjectService.insertProject(vo);
		System.out.println("insertProject 실행 후 =======> " + vo.toString());
		
		model.addAttribute("writingProject", vo);
		
		return "f-create-project";
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
















