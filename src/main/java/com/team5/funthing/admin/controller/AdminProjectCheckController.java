package com.team5.funthing.admin.controller;

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
	public String updateProjectCheckApproval(ProjectVO vo, AlarmVO avo, Model model) {
	
		updateProjectCheckApprovalService.updateProjectCheckApproval(vo);			
		vo.setStatusReplyMessage("");
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);				
		
		insertProjectJudgeResultAlarm(vo,avo,"글씨깨짐으로인해서 비워놓음");
		
		return "redirect:getProjectCheckList.ado";

	}
	
	
	@RequestMapping("updateProjectCheckDeny.ado")
	public String updateProjectCheckDeny(ProjectVO vo, AlarmVO avo, Model model) {

		updateProjectCheckDenyService.updateProjectCheckDeny(vo);
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		
		insertProjectJudgeResultAlarm(vo,avo,"글씨깨짐으로인해서 비워놓음");
		
		return "redirect:getProjectCheckList.ado";
	}
	
	@RequestMapping("updateProjectCheckDefer.ado")
	public String updateProjectCheckDefer(ProjectVO vo, AlarmVO avo, Model model) {
		
		updateProjectCheckDeferService.updateProjectCheckDefer(vo);
		insertProjectJudgeResultAlarm(vo,avo,"글씨깨짐으로인해서 비워놓음");
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		
		return "redirect:getProjectCheckList.ado";
	}	
	
	
	//===============================================================================
	
	public void insertProjectJudgeResultAlarm(ProjectVO vo, AlarmVO avo, String state) {
		
		avo.setAlarmType(vo.getProjectTitle() + " ");
		avo.setDetailAlarmType(state);
		avo.setReceiveId(vo.getEmail());
		avo.setReadConfirm('n');
		avo.setAlarmMessage(vo.getStatusReplyMessage());
		avo.setProjectNo(vo.getProjectNo());
						

		insertProjectJudgeResultAlarmService.insertProjectJudgeResultAlarm(avo);
	}
	
	
}
