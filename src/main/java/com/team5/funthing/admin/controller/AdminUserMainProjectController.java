package com.team5.funthing.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminUserMainProjectVO;
import com.team5.funthing.admin.service.adminUserMainProjectService.DeleteFocusProjectService;
import com.team5.funthing.admin.service.adminUserMainProjectService.GetFocusProjectListService;
import com.team5.funthing.admin.service.adminUserMainProjectService.GetFocusProjectService;
import com.team5.funthing.admin.service.adminUserMainProjectService.GetUserMainProjectListService;
import com.team5.funthing.admin.service.adminUserMainProjectService.InsertFocusProjectService;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.projectService.GetProjectService;

@Controller
public class AdminUserMainProjectController {

	@Autowired
	GetUserMainProjectListService getUserMainProjectListService;
	@Autowired
	GetProjectService getProjectService;
	@Autowired
	InsertFocusProjectService insertFocusProjectService;
	@Autowired
	GetFocusProjectListService getFocusProjectListService;
	@Autowired
	DeleteFocusProjectService deleteFocusProjectService;
	@Autowired
	GetFocusProjectService getFocusProjectService;

	private List<ProjectVO> focusProjectList;

	@RequestMapping("getUserMainProjectList.ado")
	public String getUserMainProjectList(ProjectVO vo, Model model) {

		AdminUserMainProjectVO advo=null;
		
		List<ProjectVO> userMainProjectList = getUserMainProjectListService.getUserMainProjectList(advo);

		model.addAttribute("userMainProjectList", userMainProjectList);

		return "p-usermainproject-list";
	}

	@RequestMapping("getUserMainProject.ado")
	public String getProject(ProjectVO vo, Model model) {

		ProjectVO userMainProject = getProjectService.getProject(vo);
		
		String videoTag = userMainProject.getProjectIntroduceVideo();
		String modifyVideoTag = videoTag.replace(videoTag.substring(15, 18),"520").replace(videoTag.substring(28, 31), "310");
		userMainProject.setProjectIntroduceVideo(modifyVideoTag);
		
		System.out.println(userMainProject.toString());
		
		model.addAttribute("userMainProject", userMainProject);

		return "p-usermainproject-detail";
	}

	@RequestMapping("insertFocusProject.ado")
	public String insertFocusProject(ProjectVO vo) {

		insertFocusProjectService.insertFocusProject(vo);
		return "redirect: getFocusProjectList.ado";
	}

	@RequestMapping("getFocusProjectList.ado")
	public String getFocusProjectList(ProjectVO vo, Model model) {

		List<AdminUserMainProjectVO> focusList = getFocusProjectListService.getFocusProjectList(vo);

		focusProjectList = new ArrayList<ProjectVO>();
		for (int i = 0; i < focusList.size(); i++) {
			vo.setProjectNo(focusList.get(i).getProjectNo());
			focusProjectList.add(getProjectService.getProject(vo));

		}

		model.addAttribute("focusProjectList", focusProjectList);

		return "p-usermainfocusproject-list";
	}

	@RequestMapping("getFocusProject.ado")
	public String getFocusProject(ProjectVO vo, Model model) {

		ProjectVO focusProject = getProjectService.getProject(vo);
		
		String videoTag = focusProject.getProjectIntroduceVideo();
		String modifyVideoTag = videoTag.replace(videoTag.substring(15, 18),"520").replace(videoTag.substring(28, 31), "310");
		focusProject.setProjectIntroduceVideo(modifyVideoTag);

		model.addAttribute("focusProject", focusProject);

		return "p-usermainfocusproject-detail";
	}

	@RequestMapping("deleteFocusProject.ado")
	public String deleteFocusProject(ProjectVO vo) {

		System.out.println(vo.getProjectNo());
		
		deleteFocusProjectService.deleteFocusProject(vo);

		return "redirect: getFocusProjectList.ado";
	}
}
