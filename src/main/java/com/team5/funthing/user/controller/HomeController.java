package com.team5.funthing.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.ProjectBoardVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.homeService.GetAttentionProjectService;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
public class HomeController {

	
	@Autowired
	private GetAttentionProjectService getAttentionProjectService;
	@Autowired
	private GetProjectService getProjectService;
	
	@RequestMapping("*.udo") 
	public String showindex(ProjectBoardVO vo, ProjectVO vo2, Model model) { //��ó�� ���������� ������
		
		//�ָ��Ҹ��� ������Ʈ 
		List<ProjectBoardVO> attentionProject = getAttentionProjectService.getAttentionProjectList(vo); //1.��� ���� ���� ������� �������� 
		model.addAttribute("attentionProject",attentionProject);
		
//		vo2.setProjectNo(Integer.parseInt(((ProjectBoardVO) getAttentionProjectService.getAttentionProjectList(vo)).getProjectNo());
		ProjectVO getProject = getProjectService.getProject(vo2); //projectNo���� �������� 
		model.addAttribute("getProject",getProject);
		
		//�������� ������Ʈ 
		
		
		return "p--";
	}

}
