package com.team5.funthing.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.CreatorVO;
import com.team5.funthing.user.service.creatorService.GetCreatorService;

@Controller
public class CreatorController {
	
	@Autowired
	private GetCreatorService getCreatorService;

	@RequestMapping(value="existCreatorCheck.udo", method = RequestMethod.POST, produces ="application/text; charset=utf8")
	@ResponseBody
	public String existCreatorCheck(@RequestBody CreatorVO cvo) {
		
		String msg = null;
		
		String inputCreator = cvo.getCreator();
		
		if(inputCreator.length() == 0) {
			msg = "";
		}else {
			cvo = getCreatorService.getCreator(cvo);
			if(cvo != null) {
				if(inputCreator.equals(cvo.getCreator())) {
					msg = "이미 등록된 창작자명입니다.";
				}
			}else {
	
					msg = "사용 가능한 창작자명입니다.";
			}
		}
		
		return msg;		
	}
	
	@RequestMapping(value="selectCreatorCheck.udo", method = RequestMethod.POST, produces ="application/text; charset=utf8")
	@ResponseBody
	public String selectCreatorCheck(@RequestBody CreatorVO cvo) throws JsonProcessingException {

		cvo = getCreatorService.getCreator(cvo);
		System.out.println(cvo.getBusinessFileLink());
		ObjectMapper mapper = new ObjectMapper();
		String selectedCreatorToJSON = mapper.writeValueAsString(cvo);
	
		return selectedCreatorToJSON;
	}
	
	
}






















