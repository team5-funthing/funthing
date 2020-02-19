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
		
		// �׽�Ʈ �� �ڵ�
		MemberVO test = new MemberVO();
		test.setEmail("test@naver.com");
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
		model.addAttribute("basicProjectSetting", vo);
		
		return "f-create-project-basic"; // ������Ʈ �ۼ� ��
	} // ������Ʈ ����� ���� ���������� ����
	
	
	
	@RequestMapping(value = "insertProject.udo", method = RequestMethod.POST)
	public String insertProject(HttpSession session, ProjectVO vo, Model model) {
		
		// ������Ʈ ���� ù ���۽ÿ��� ����
		ProjectVO checkVO = (ProjectVO)session.getAttribute("insertedProject");
		
		
		// ���ΰ�ħ�� �� ��쿡 �ݺ������� requestMapping �۾��� ����Ǵ� �κ��� �����ϱ� ���� �ڵ�
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
	public String saveInputWritingProject(@RequestParam(name = "uploadImage")MultipartFile uploadFile, ProjectVO vo, Model model) throws Exception {

		
		// ���ε� ��Ų ������ �̹� �����ϴ� ��� ���� ������ �ٽ� ���� ��쿡 ���� �� �ִ� ��Ȳ ó��
		// ���ε� �̹����� ������ ���
		if(!uploadFile.isEmpty()) { 
			
			//���ŵ� ���ϰ�θ� vo��ü���� ��������
			String toRemoveFilePath = vo.getProjectMainImage();
			
			String voName = vo.getClass().getSimpleName();
			String toSettingPath = projectMainImageUploadUtils.upload(uploadFile, voName, toRemoveFilePath);
			
			vo.setProjectMainImage(toSettingPath);
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
















