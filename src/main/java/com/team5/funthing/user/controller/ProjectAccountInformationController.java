package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.ProjectAccountInformationVO;
import com.team5.funthing.user.service.projectAccountInformationService.DeleteProjectAccountInformationService;
import com.team5.funthing.user.service.projectAccountInformationService.GetProjectAccountInformationService;
import com.team5.funthing.user.service.projectAccountInformationService.InsertProjectAccountInformationService;
import com.team5.funthing.user.service.projectAccountInformationService.UpdateProjectAccountInformationService;

@Controller
public class ProjectAccountInformationController {

		@Autowired
		InsertProjectAccountInformationService insertProjectAccountInformation;
		@Autowired
		UpdateProjectAccountInformationService updateProjectAccountInformation;
		@Autowired
		GetProjectAccountInformationService getProjectAccountInformation;
		@Autowired
		DeleteProjectAccountInformationService deleteProjectAccountInformation;
		
		@RequestMapping(path="accountInfo.udo",method=RequestMethod.GET)
		public String goAccountInfo() {
			return "f-accountInfo";
		}
		
		@RequestMapping(path="insertOrUpdateProjectAccountInformation.udo",method=RequestMethod.POST)
		public String insertPAI(ProjectAccountInformationVO vo) {
			if(getProjectAccountInformation.getProjectAccountInformation(vo).getProjectBank()==null) {
				insertProjectAccountInformation.insertProjectAccountInformation(vo);
			}else {
				updateProjectAccountInformation.updateProjectAccountInformation(vo);
			}
			
			return "forward:accountInfo.udo";
		}
		
	
		@RequestMapping(path="deleteProjectAccountInformation.udo",method=RequestMethod.POST)
		public String deletePAI(ProjectAccountInformationVO vo) {
			deleteProjectAccountInformation.deleteProjectAccountInformation(vo);
			return "";
		}
	
}
