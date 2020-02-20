package com.team5.funthing.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.memberActivityService.DeleteMemberActivityService;
import com.team5.funthing.user.service.memberActivityService.GetMemberActivityListService;
import com.team5.funthing.user.service.memberActivityService.InsertMemberActivityService;
import com.team5.funthing.user.service.memberActivityService.UpdateMemberActivityService;
import com.team5.funthing.user.service.projectService.GetProjectService;
import com.team5.funthing.user.service.projectService.GetProjectServiceByEmail;

@Controller
public class MemberActivityController {

	@Autowired
	DeleteMemberActivityService deleteMemberActivityService;
	@Autowired
	GetMemberActivityListService getMemberActivityService;
	@Autowired
	InsertMemberActivityService insertMemberActivityService;
	@Autowired
	UpdateMemberActivityService updateMemberActivityService;
	@Autowired
	GetProjectServiceByEmail getProjectServiceByEmailService;
	@Autowired
	GetProjectService getProjectService;

	
	
	@RequestMapping("gmas1")
	public void myProjectList(ProjectVO vo,Model model,HttpSession session) {
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		model.addAttribute("myProjectList",getProjectServiceByEmailService.getProjectListByEmail(vo));
	}
	
	@RequestMapping("gmas2")
	public void myLikeProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectList = null;
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		for(MemberActivityVO list:getMemberActivityService.getLikeProjectnoList(vo)) {
			vo1.setProjectNo(list.getprojectno());
			projectList.add(getProjectService.getProject(vo1));
		}
		System.out.println(projectList.get(0));
		System.out.println(projectList.get(1));
		model.addAttribute(projectList);
	}
	@RequestMapping("imas1")
	public void myReportProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectList = null;
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		for(MemberActivityVO list:getMemberActivityService.getReportProjectnoList(vo)) {
			vo1.setProjectNo(list.getprojectno());
			projectList.add(getProjectService.getProject(vo1));
		}
		System.out.println(projectList.get(0));
		System.out.println(projectList.get(1));
		model.addAttribute(projectList);
	}
	@RequestMapping("umas1")
	public void myReservationProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectList = null;
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		for(MemberActivityVO list:getMemberActivityService.getReservationProjectnoList(vo)) {
			vo1.setProjectNo(list.getprojectno());
			projectList.add(getProjectService.getProject(vo1));
		}
		System.out.println(projectList.get(0));
		System.out.println(projectList.get(1));
		model.addAttribute(projectList);
		
	}
}
