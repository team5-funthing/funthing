package com.team5.funthing.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.funthing.admin.model.vo.AdminMainViewVO;
import com.team5.funthing.admin.service.adminMainViewService.GetMainViewProjectFundingListService;
import com.team5.funthing.admin.service.adminMainViewService.GetMainViewProjectStatusListService;
import com.team5.funthing.user.model.vo.ProjectVO;

@Controller
public class AdminMainViewController {
	
	@Autowired
	GetMainViewProjectStatusListService getMainViewProjectStatusListService;
	@Autowired
	GetMainViewProjectFundingListService getMainViewProjectFundingListService;
	
	@RequestMapping("getMainViewProjectStatusList.ado")
	public String getMainViewProjectStatusList(AdminMainViewVO vo, Model model) {
		//���� �� �ݵ� ������
		vo.setStatus('p');
		List<ProjectVO> statusPList = getMainViewProjectStatusListService.getMainViewProjectStatusList(vo);
		int statusPListCount = statusPList.size();
		//�ź�
		vo.setStatus('f');
		List<ProjectVO> statusFList = getMainViewProjectStatusListService.getMainViewProjectStatusList(vo);
		int statusFListCount = statusFList.size();
		
		//�ɻ���
		vo.setStatus('w');
		List<ProjectVO> statusWList = getMainViewProjectStatusListService.getMainViewProjectStatusList(vo);
		int statusWListCount = statusWList.size();
		
		//����
		vo.setStatus('m');
		List<ProjectVO> statusMList = getMainViewProjectStatusListService.getMainViewProjectStatusList(vo);
		int statusMListCount = statusMList.size();
		
		model.addAttribute("statusPListCount", statusPListCount);
		model.addAttribute("statusFListCount", statusFListCount);
		model.addAttribute("statusWListCount", statusWListCount);
		model.addAttribute("statusMListCount", statusMListCount);
		
		return "p-index";
	}

}
