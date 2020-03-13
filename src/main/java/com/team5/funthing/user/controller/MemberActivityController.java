package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team5.funthing.user.model.vo.MemberActivityVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.model.vo.PaymentReserveVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.memberActivityService.DeleteMemberActivityService;
import com.team5.funthing.user.service.memberActivityService.GetLikeProjectNoListService;
import com.team5.funthing.user.service.memberActivityService.GetMemberActivityListService;
import com.team5.funthing.user.service.memberActivityService.GetReportProjectNoListService;
import com.team5.funthing.user.service.memberActivityService.GetReservationProjectNoListService;
import com.team5.funthing.user.service.memberActivityService.InsertMemberActivityService;
import com.team5.funthing.user.service.memberActivityService.UpdateMemberActivityService;
import com.team5.funthing.user.service.memberService.GetMemberService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveListByEmailService;
import com.team5.funthing.user.service.paymentReserveService.GetPaymentReserveService;
import com.team5.funthing.user.service.projectService.GetProjectListByEmailService;
import com.team5.funthing.user.service.projectService.GetProjectService;
	
@Controller
public class MemberActivityController {

	//Project Service
	@Autowired
	private GetProjectListByEmailService getProjectServiceByEmailService;
	@Autowired
	private GetProjectService getProjectService;
	@Autowired
	private GetMemberService getMemberService;
	
	//PaymentReserve Service
	//MemberActivity Service
	@Autowired
	private InsertMemberActivityService insertMemberActivityService;
	@Autowired
	private GetLikeProjectNoListService getLikeProjectNoListService;
	@Autowired
	private GetReportProjectNoListService getReportProjectNoListService;
	@Autowired
	private GetReservationProjectNoListService getReservationProjectNoListService;
	


	@RequestMapping(value="mypage.udo",method=RequestMethod.GET)
	public String myPage(HttpSession session, MemberActivityVO vo, ProjectVO vo1, Model model, MemberVO vo2) {
		myProjectList(vo1, model, session);
		myLikeProjectList(session, vo, vo1, model);
		myReportProjectList(session, vo, vo1, model);
		myReservationProjectList(session, vo, vo1, model);

		return "p-detail-mypage";
	}  
	

	//네임클릭했을때 넘어가는 페이지 
	@RequestMapping(value="nameProfile.udo",method=RequestMethod.GET)
	public String nameProfile(HttpSession session, 
			@RequestParam(value="email") String email,@RequestParam(value="name") String name, MemberActivityVO vo, ProjectVO vo1, Model model, MemberVO vo2) {
		
		vo.setEmail(email);
		model.addAttribute("vo",vo);
		
		vo2.setEmail(email);
		model.addAttribute("getMember",getMemberService.getMember(vo2));
		
		//내가 만든 프로젝트 리스트
		model.addAttribute("myProjectList",getProjectServiceByEmailService.getProjectListByEmail(vo1));
		
		//내가 좋아요 프로젝트 리스트 
		List<ProjectVO> projectLikeList = new ArrayList<ProjectVO>();
//		MemberVO loginMember = (MemberVO) session.getAttribute("memberSession");
		
		List<MemberActivityVO> likeProjectList = getLikeProjectNoListService.getLikeProjectNoList(vo);

		for(MemberActivityVO getProjectNo : likeProjectList) {
			vo1.setProjectNo(getProjectNo.getProjectNo());
			projectLikeList.add(getProjectService.getProject(vo1));
		}
		//System.out.println(projectLikeList.toString());
		
		model.addAttribute("projectLikeList", projectLikeList);
		
		//내가 후원한 리스트 
		
		List<ProjectVO> projectReportList = new Vector<ProjectVO>();
//		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
//		vo.setEmail(vo2.getEmail());
		for(MemberActivityVO list: getReportProjectNoListService.getReportProjectNoList(vo)) {
			vo1.setProjectNo(list.getProjectNo());
			projectReportList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectReportList",projectReportList);
		
		
		//예정중인 리스트
		List<ProjectVO> projectReservationList = new Vector<ProjectVO>();
//		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
//		vo.setEmail(vo2.getEmail());
		for(MemberActivityVO list: getReservationProjectNoListService.getReservationProjectNoList(vo)) {
			vo1.setProjectNo(list.getProjectNo());
			projectReservationList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectReservationList",projectReservationList);
		

		return "p-name-profile";
	}  
	
	
	

	@RequestMapping("upCountLikeInterceptor.udo")

	public String upCountLike(MemberActivityVO mavo, 
							Model model,
							RedirectAttributes redirectAttributes,
							@RequestParam(value="projectNo") String projectNo,
							HttpSession session) {
		
		MemberVO clickLikeMember = (MemberVO) session.getAttribute("memberSession");
		mavo.setEmail(clickLikeMember.getEmail());
		mavo.setProjectNo(Integer.parseInt(projectNo));
		mavo.setLikeCount('y');
		insertMemberActivityService.insertMemberActivity(mavo);
		
		redirectAttributes.addAttribute("projectNo", projectNo);
		

		return "redirect:projectDetails.udo";

	}

	
	
	
	
	
//	=============================================================================
	public void myProjectList(ProjectVO vo,Model model,HttpSession session) {

		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		model.addAttribute("myProjectList",getProjectServiceByEmailService.getProjectListByEmail(vo));
	}
	

	public void myLikeProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectLikeList = new ArrayList<ProjectVO>();
		MemberVO loginMember = (MemberVO) session.getAttribute("memberSession");

		vo.setEmail(loginMember.getEmail());
		List<MemberActivityVO> likeProjectList = getLikeProjectNoListService.getLikeProjectNoList(vo);

		for(MemberActivityVO getProjectNo : likeProjectList) {
			vo1.setProjectNo(getProjectNo.getProjectNo());
			projectLikeList.add(getProjectService.getProject(vo1));
		}
		//System.out.println(projectLikeList.toString());
		
		model.addAttribute("projectLikeList", projectLikeList);
	}

	public void myReportProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectReportList = new Vector<ProjectVO>();
		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		for(MemberActivityVO list: getReportProjectNoListService.getReportProjectNoList(vo)) {
			vo1.setProjectNo(list.getProjectNo());
			projectReportList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectReportList",projectReportList);
	}

	public void myReservationProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectReservationList = new Vector<ProjectVO>();
		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		for(MemberActivityVO list: getReservationProjectNoListService.getReservationProjectNoList(vo)) {
			vo1.setProjectNo(list.getProjectNo());
			projectReservationList.add(getProjectService.getProject(vo1));
		}
		model.addAttribute("projectReservationList",projectReservationList);
	}


}
