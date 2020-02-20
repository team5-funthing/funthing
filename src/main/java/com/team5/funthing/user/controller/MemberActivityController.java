package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.team5.funthing.user.service.memberActivityService.DeleteMemberActivityService;
import com.team5.funthing.user.service.memberActivityService.GetMemberActivityListService;
import com.team5.funthing.user.service.memberActivityService.InsertMemberActivityService;
import com.team5.funthing.user.service.memberActivityService.UpdateMemberActivityService;

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
	
	
	
}
