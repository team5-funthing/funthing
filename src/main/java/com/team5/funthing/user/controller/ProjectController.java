package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.ProjectVO;
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

	
//	프로젝트 
//	   1) void createProject ( ProjectVO vo )  - 프로젝트 생성 메서드
//	      - void insertProject ( ProjectVO vo ) PROJECTNO - 프로젝트 입력/임시저장 메서드
//	      - void updateProject ( ProjectVO vo ) PROJECTNO - 프로젝트 수정 메서드
//	   2) void deleteProject ( ProjectVO vo ) PROJECTNO - 프로젝트 삭제 메서드
//	       * 해당 메서드 호출시 projectCount, projectAccountInfomation,Reward,ReservationManagement
//			       report, projectBoard관련 테이블의 동일한 프로젝트 번호에 대해 레코드 삭제
	
	
	//작성중인 프로젝트 화면 가져오기
	@RequestMapping(value="/showCreateProjectForm.udo", method = RequestMethod.GET)
	public String showCreateProjectForm(ProjectVO vo) {
		return "f-create-project";
	}
	
	@RequestMapping(value="/createProject.udo", method = RequestMethod.GET)
	public String createProject(ProjectVO vo) {
		System.out.println("==> createProject.udo 실행");
		return null;
	}
	
	@RequestMapping(value="/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(ProjectVO vo) {
		System.out.println("여기로 데이터 값 넘어옴");
		System.out.println(vo.toString());
		return null;
	}
	
	public String updateProject(ProjectVO vo) {
		return null;
	}
	

	public String deleteProject(ProjectVO vo) {
		return null;
	}
	
}
















