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
		
		System.out.println(projectCheck.toString());
		
		String videoTag = projectCheck.getProjectIntroduceVideo();
		String modifyVideoTag = videoTag.replace(videoTag.substring(15, 18),"520").replace(videoTag.substring(28, 31), "310");
		projectCheck.setProjectIntroduceVideo(modifyVideoTag);
		
		System.out.println(projectCheck.toString());
		
		model.addAttribute("projectCheck",projectCheck);
		return "b-project-check-detail";
	}
	
	@RequestMapping("updateProjectCheckApproval.ado")
	public String updateProjectCheckApproval(ProjectVO vo, AlarmVO avo, Model model) {
	
		updateProjectCheckApprovalService.updateProjectCheckApproval(vo);			//프로젝트의 상태를 변경
		vo.setStatusReplyMessage("");
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);				//사유 기재 상태를 변경
		
		insertProjectJudgeResultAlarm(vo,avo,"승인");
		
		return "redirect:getProjectCheckList.ado";

	}
	
	//보낸후에 다시 그 페이지로 이동
	@RequestMapping("updateProjectCheckDeny.ado")
	public String updateProjectCheckDeny(ProjectVO vo, AlarmVO avo, Model model) {

		updateProjectCheckDenyService.updateProjectCheckDeny(vo);
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		
		insertProjectJudgeResultAlarm(vo,avo,"거부");
		
		return "redirect:getProjectCheckList.ado";
	}
	
	@RequestMapping("updateProjectCheckDefer.ado")
	public String updateProjectCheckDefer(ProjectVO vo, AlarmVO avo, Model model) {
		
		updateProjectCheckDeferService.updateProjectCheckDefer(vo);
		insertProjectJudgeResultAlarm(vo,avo,"반려");
		updateStatusReplyMessageService.updateStatusReplyMessage(vo);
		
		return "redirect:getProjectCheckList.ado";
	}	
	
	
	//===============================================================================
	
	public void insertProjectJudgeResultAlarm(ProjectVO vo, AlarmVO avo, String state) {
		//알람을 보내기위해서 데이터를 db에 넣는 부분
		avo.setAlarmType(vo.getProjectTitle() + " 심사결과");
		avo.setDetailAlarmType(state);
		avo.setReceiveId(vo.getEmail());
		avo.setReadConfirm('n');
		avo.setAlarmMessage(vo.getStatusReplyMessage());
		avo.setProjectNo(vo.getProjectNo());
						
		System.out.println("입력 avo 상태 : " + avo.toString());
		insertProjectJudgeResultAlarmService.insertProjectJudgeResultAlarm(avo);
	}
	
	
}
