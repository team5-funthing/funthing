package com.team5.funthing.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.RewardVO;

@Controller
public class RewardController {
	
	@RequestMapping(value= "insertReward.udo", method = RequestMethod.POST)
	public String insertReward(RewardVO vo, Model model) {
		
		System.out.println(vo.toString());
		
		model.addAttribute("addedReward", vo);
		
		return "f-create-project";
	
	}
	
	public String updateReward() {
		return "";
	}
	
}
