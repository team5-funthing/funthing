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
		@RequestMapping(path="account.udo",method=RequestMethod.GET)
		public String goAccountIn() {
			return "#";
		}
		@RequestMapping(path="accountInfo.udo",method=RequestMethod.GET)
		public String goAccountInfo() {
			return "redirect:account.udo/?projectno=1";
		}
		
		
		/////   �̰� �޼ҵ� �ϳ��� ���Ƴ��� ���ϴ� �����.  ����   �ϳ��� �����!!!   
		@RequestMapping(path="insertProjectAccountInformation.udo",method=RequestMethod.POST)
		public void insertPAI(ProjectAccountInformationVO vo) {
		
				insertProjectAccountInformation.insertProjectAccountInformation(vo);
	    
		}

		@RequestMapping(path="UpdateProjectAccountInformation.udo",method=RequestMethod.POST)
		public void updatePAI(ProjectAccountInformationVO vo) {

			updateProjectAccountInformation.updateProjectAccountInformation(vo);
			
		}
	
		@RequestMapping(path="deleteProjectAccountInformation.udo",method=RequestMethod.POST)
		public void deletePAI(ProjectAccountInformationVO vo) {
		
			deleteProjectAccountInformation.deleteProjectAccountInformation(vo);
			
		}
		
		@RequestMapping(path="getProjectAccount",method=RequestMethod.GET)
		public void getProjectAccount(ProjectAccountInformationVO vo) {
			
			getProjectAccountInformation.accountCheck(vo);
			System.out.println(getProjectAccountInformation.accountCheck(vo));
			System.out.println(getProjectAccountInformation.getProjectAccountInformation(vo).toString());
		}
}
