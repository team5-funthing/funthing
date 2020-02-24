package com.team5.funthing.user.controller;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.ProjectAskMessageService.GetMakerMemberCreatorService;
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
	@Autowired
	GetMakerMemberCreatorService getMakerMemberCreatorService;

	@RequestMapping(value="mypage.udo",method=RequestMethod.GET)
	public String myPage(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model, MemberVO vo2) {
		System.out.println("마이페이지 이동시 세션에 담긴 이메일 확인:"+session.getAttribute("memberSessionEmail"));
		myProjectList(vo1, model, session);
		myLikeProjectList(session, vo, vo1, model);
		myReportProjectList(session, vo, vo1, model);
		myReservationProjectList(session, vo, vo1, model);
		System.out.println(model.getAttribute("projectLikeList"));
		System.out.println(model.getAttribute("projectReportList"));
		System.out.println(model.getAttribute("projectReservationList"));
		
		
		return "p-detail-mypage";
	}  
	

	
	
	
	
	
//	=============================================================================
	public void myProjectList(ProjectVO vo,Model model,HttpSession session) {
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		System.out.println("myprojectVO 의 email값 :"+vo.getEmail());
        System.out.println(getProjectServiceByEmailService.getProjectListByEmail(vo).toString());
		model.addAttribute("myProjectList",getProjectServiceByEmailService.getProjectListByEmail(vo));
	}
	

	public void myLikeProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectLikeList = new Vector<ProjectVO>();
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		for(MemberActivityVO list:getMemberActivityService.getLikeProjectnoList(vo)) {
			vo1.setProjectNo(list.getprojectno());
			projectLikeList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectLikeList",projectLikeList);
	}

	public void myReportProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectReportList = new Vector<ProjectVO>();
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		for(MemberActivityVO list:getMemberActivityService.getReportProjectnoList(vo)) {
			vo1.setProjectNo(list.getprojectno());
			projectReportList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectReportList",projectReportList);
	}

	public void myReservationProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectReservationList = new Vector<ProjectVO>();
		vo.setEmail((String)session.getAttribute("memberSessionEmail"));
		for(MemberActivityVO list:getMemberActivityService.getReservationProjectnoList(vo)) {
			vo1.setProjectNo(list.getprojectno());
			projectReservationList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectReservationList",projectReservationList);
	}
}
