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

	
//	������Ʈ 
//	   1) void createProject ( ProjectVO vo )  - ������Ʈ ���� �޼���
//	      - void insertProject ( ProjectVO vo ) PROJECTNO - ������Ʈ �Է�/�ӽ����� �޼���
//	      - void updateProject ( ProjectVO vo ) PROJECTNO - ������Ʈ ���� �޼���
//	   2) void deleteProject ( ProjectVO vo ) PROJECTNO - ������Ʈ ���� �޼���
//	       * �ش� �޼��� ȣ��� projectCount, projectAccountInfomation,Reward,ReservationManagement
//			       report, projectBoard���� ���̺��� ������ ������Ʈ ��ȣ�� ���� ���ڵ� ����
	
	
	//�ۼ����� ������Ʈ ȭ�� ��������
	@RequestMapping(value="/showCreateProjectForm.udo", method = RequestMethod.GET)
	public String showCreateProjectForm(ProjectVO vo) {
		return "f-create-project";
	}
	
	@RequestMapping(value="/createProject.udo", method = RequestMethod.GET)
	public String createProject(ProjectVO vo) {
		System.out.println("==> createProject.udo ����");
		return null;
	}
	
	@RequestMapping(value="/insertProject.udo", method = RequestMethod.POST)
	public String insertProject(ProjectVO vo) {
		System.out.println("����� ������ �� �Ѿ��");
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
















