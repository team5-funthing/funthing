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

import com.team5.funthing.user.memberService.SelectMemberService;
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
	@Autowired
	private SelectMemberService selectMemberService;
	
	@RequestMapping(value="/showStartProjectPage.udo", method = RequestMethod.GET)
	public String showStartProjectPage(HttpSession session, Model model) {

		// �׽�Ʈ �� �ڵ�
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
		test = selectMemberService.getMember(test);
		session.setAttribute("email", test.getEmail());
		
		String loginId = (String)session.getAttribute("email");
		
		
		if(loginId == null) {
			model.addAttribute("msg", "�α��� �� �̿� �����մϴ�.");
			return "p-index";
		}
		
		model.addAttribute("member", test); 
		return "p-start-project"; // �����ϱ� �������� �̵�����
	} // �α��� �ÿ��� ������Ʈ ����� ���� �����ϵ��� �ϱ����� ���ǿ� ����� �� Ȯ�� �� ������ �̵�.
	
	@RequestMapping(value="/showCreateProjectBasicForm.udo", method = RequestMethod.GET)
	public String showCreateProjectBasicForm(HttpSession session, ProjectVO vo, Model model) {
		
		session.removeAttribute("insertedProject");
		System.out.println("insertedProject ����");
		model.addAttribute("basicProjectSetting", vo);
		
		return "f-create-project-basic"; // ������Ʈ �ۼ� ��
	} // ������Ʈ ����� ���� ���������� ����
	
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
	} // ������Ʈ �ۼ� �����Ҷ� �޼��� 
	
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
		
		System.out.println("�����ϱ� Ŭ�� ====> " + vo.toString());
		
		
		vo.setWriteStatus(writingInputCheck(vo));
		updateProjectService.updateProject(vo);
	
		model.addAttribute("writingProject", vo);
		model.addAttribute("msg", "���� �Ǿ����ϴ�");
		
		return "f-create-project";
	} // �ۼ����� ������Ʈ �����ϱ�.
	
	
	@RequestMapping(value = "showPreviewProject.udo", method = RequestMethod.POST)
	public String showPreviewProject(ProjectVO vo, Model model) {
		
		model.addAttribute("previewProject", vo);
		
		return "p-project-details";
	}// ������Ʈ �̸����� �̵�.


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
















