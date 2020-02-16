package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.GetMemberService;
import com.team5.funthing.user.service.projectService.CreateProjectService;
import com.team5.funthing.user.service.projectService.DeleteProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.InsertProjectService;
import com.team5.funthing.user.service.projectService.UpdateProjectService;

@Controller
@SessionAttributes("project")
public class ProjectController2 {
	
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
	
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String showStartProjectPage(HttpSession session, Model model) {

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
		return "p-start-project"; // �����ϱ� �������� �̵�����
	} //�׽�Ʈ ��
	
	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(HttpSession session, ProjectVO vo, Model model) {
		
		session.removeAttribute("insertedProject");
		System.out.println("insertedProject ����");
		model.addAttribute("basicProjectSetting", vo);
		
		return "f-create-project-basic"; // ������Ʈ �ۼ� ��
	} 
	
	@RequestMapping(value = "insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {
		
		// ������Ʈ ���� ù ���۽ÿ��� ����
		ProjectVO checkVO = (ProjectVO)session.getAttribute("insertedProject");
		
		if(checkVO == null) {
			vo = insertProjectService.insertProject(vo);
			session.setAttribute("insertedProject", vo);
		}
		else {
			System.out.println("���ΰ�ħ Ȯ�� : " + checkVO.getProjectNo());
			vo = checkVO;
		}
		
		System.out.println("insertProject �Ǵ� ���ΰ�ħ ���� �� =======> " + vo.toString());
		model.addAttribute("writingProject", vo);

		return "f-create-project";
	}
	
	@RequestMapping(value = "saveInputWritingProject.udo", method = RequestMethod.POST)
	public String saveInputWritingProject(ProjectVO vo, Model model) {
		
		System.out.println("�����ϱ� Ŭ�� ====> " + vo.toString());
		
		updateProjectService.updateProject(vo);
		model.addAttribute("writingProject", vo);
		model.addAttribute("msg", "���� �Ǿ����ϴ�");
		
		return "f-create-project";
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
		// ���Ŀ� �̹���, ȫ�� ����, ����  �� üũ ������ �߰��ؾ��Ѵ�. 
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
