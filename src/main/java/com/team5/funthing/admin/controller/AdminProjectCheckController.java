package com.team5.funthing.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.service.adminProjectCheckService.GetProjectCheckService;
import com.team5.funthing.admin.service.adminProjectCheckService.UpdateProjectCheckApprovalService;
import com.team5.funthing.admin.service.adminProjectCheckService.UpdateProjectCheckDeferService;
import com.team5.funthing.admin.service.adminProjectCheckService.UpdateProjectCheckDenyService;
import com.team5.funthing.admin.service.adminProjectCheckService.UpdateStatusReplyMessageService;
import com.team5.funthing.user.model.vo.AlarmVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.AlarmService.InsertProjectJudgeResultAlarmService;

@Controller
public class AdminProjectCheckController {
	
	@Autowired
	GetProjectCheckService getProjectCheckService;
	@Autowired
	UpdateProjectCheckApprovalService updateProjectCheckApprovalService;
	@Autowired
	UpdateProjectCheckDenyService updateProjectCheckDenyService;
	@Autowired
	UpdateProjectCheckDeferService updateProjectCheckDeferService;
	@Autowired
	UpdateStatusReplyMessageService updateStatusReplyMessageService;
	@Autowired
	InsertProjectJudgeResultAlarmService insertProjectJudgeResultAlarmService;
	
	
	
	@RequestMapping("getProjectCheck.ado")
	public String getProjectCheck(ProjectVO vo,Model model) {
		
		ProjectVO projectCheck = getProjectCheckService.getProjectCheck(vo);
		
		String videoTag = projectCheck.getProjectIntroduceVideo();
		String modifyVideoTag = videoTag.replace(videoTag.substring(15, 18),"520").replace(videoTag.substring(28, 31), "310");
		projectCheck.setProjectIntroduceVideo(modifyVideoTag);
		
		System.out.println(projectCheck.toString());
		
		model.addAttribute("projectCheck",projectCheck);
		return "b-project-check-detail";
	}
	
	@RequestMapping("updateProjectCheckApproval.ado")
	public String updateProjectCheckApproval(ProjectVO vo,Model model) {
	
		updateProjectCheckApprovalService.updateProjectCheckApproval(vo);
		vo.setStatusReplyMessage("");
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		
		return "redirect:getProjectCheckList.ado";

	}
	
	//보낸후에 다시 그 페이지로 이동
	@RequestMapping("updateProjectCheckDeny.ado")
	public String updateProjectCheckDeny(ProjectVO vo, AlarmVO avo, Model model,HttpServletRequest request) {

		updateProjectCheckDenyService.updateProjectCheckDeny(vo);
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		
		System.out.println(vo.getEmail());
		System.out.println(vo.getStatusReplyMessage());
		System.out.println(vo.getProjectTitle());
		System.out.println(vo.getProjectNo());
		
		//알람을 보내기위해서 데이터를 db에 넣는 부분
		avo.setAlarmType(vo.getProjectTitle() + " 심사결과");
		avo.setDetailAlarmType("거부");
		avo.setReceiveId(vo.getEmail());
		avo.setReadConfirm('n');
		avo.setAlarmMessage(vo.getStatusReplyMessage());
		avo.setProjectNo(vo.getProjectNo());
		
		System.out.println("입력 avo 상태 : " + avo.toString());
		insertProjectJudgeResultAlarmService.insertProjectJudgeResultAlarm(avo);
		
		return "redirect:getProjectCheckList.ado";
	}
	
	@RequestMapping("updateProjectCheckDefer.ado")
	public String updateProjectCheckDefer(ProjectVO vo,Model model) {
		
		updateProjectCheckDeferService.updateProjectCheckDefer(vo);
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		ProjectVO projectCheck = getProjectCheckService.getProjectCheck(vo);
		
		model.addAttribute("projectCheck",projectCheck);
		
		return "b-project-check-detail";
	}	
	
	
}
