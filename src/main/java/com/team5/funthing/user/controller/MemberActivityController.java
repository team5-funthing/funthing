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
	
	//PaymentReserve Service
	@Autowired
	private GetPaymentReserveService getPaymentReserveService;
	@Autowired
	private GetPaymentReserveListByEmailService getPaymentReserveListByEmailService;
	
	//MemberActivity Service
	@Autowired
	private InsertMemberActivityService insertMemberActivityService;
	@Autowired
	private DeleteMemberActivityService deleteMemberActivityService;
	@Autowired
	private GetMemberActivityListService getMemberActivityService;
	@Autowired
	private UpdateMemberActivityService updateMemberActivityService;
	@Autowired
	private GetLikeProjectNoListService getLikeProjectNoListService;
	@Autowired
	private GetReportProjectNoListService getReportProjectNoListService;
	@Autowired
	private GetReservationProjectNoListService getReservationProjectNoListService;
	


	@RequestMapping(value="mypage.udo",method=RequestMethod.GET)
	public String myPage(HttpSession session, MemberActivityVO vo, ProjectVO vo1, Model model, MemberVO vo2) {
		
		System.out.println(":"+session.getAttribute("memberSession").toString());
		myProjectList(vo1, model, session);
		myLikeProjectList(session, vo, vo1, model);
		myReportProjectList(session, vo, vo1, model);
		myReservationProjectList(session, vo, vo1, model);

		return "p-detail-mypage";
	}  
	
	@RequestMapping("upCountLike.udo")
	public String upCountLike(MemberActivityVO mavo, 
							Model model,
							RedirectAttributes redirectAttributes,
							@RequestParam(value="projectNo") String projectNo,
							HttpSession session) {
		
		MemberVO clickLikeMember = (MemberVO) session.getAttribute("memberSession");
		System.out.println(clickLikeMember.getEmail());
		
		mavo.setEmail(clickLikeMember.getEmail());
		mavo.setProjectNo(Integer.parseInt(projectNo));
		mavo.setLikeCount('y');
		
		System.out.println(mavo.toString());
		
		insertMemberActivityService.insertMemberActivity(mavo);
		
		redirectAttributes.addAttribute("projectNo", projectNo);
		
		return "redirect:projectDetails.udo"; //�쉲�쉧夷뚰슀�쉧吏좏쉱吏� 夷⑹쿂姨뚯찈�쉱梨꾬옙�쉻�쉧泥�
	}

	
	
	
	
	
//	=============================================================================
	public void myProjectList(ProjectVO vo,Model model,HttpSession session) {

		MemberVO vo2 = (MemberVO) session.getAttribute("memberSession");
		vo.setEmail(vo2.getEmail());
		System.out.println("myprojectVO email :"+vo.getEmail());

        System.out.println(getProjectServiceByEmailService.getProjectListByEmail(vo).toString());
		model.addAttribute("myProjectList",getProjectServiceByEmailService.getProjectListByEmail(vo));
	}
	

	public void myLikeProjectList(HttpSession session,MemberActivityVO vo,ProjectVO vo1,Model model) {
		List<ProjectVO> projectLikeList = new ArrayList<ProjectVO>();
		MemberVO loginMember = (MemberVO) session.getAttribute("memberSession");
		//System.out.println("夷뚰슀吏뱁슎占쏀슀 姨먰쉱占쏀쉻夷됱괩 吏몄㎣ : " + loginMember.getEmail());
		vo.setEmail(loginMember.getEmail());
		//System.out.println("vo占쏀쉲 吏몄㎣ : " +  vo.toString());
		List<MemberActivityVO> likeProjectList = getLikeProjectNoListService.getLikeProjectNoList(vo);
		//System.out.println("�쉳夷띿찓泥⑼옙�쉻 �쉧�쉧姨먰쉱姨붿콈 夷덉ℓ夷띿쭨 吏명쉯 : " + likeProjectList);
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
