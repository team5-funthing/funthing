package com.team5.funthing.user.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.searchKeywordService.GetSearchKeywordService;

@Controller
public class SearchKeywordController {
	
	@Autowired
	private GetSearchKeywordService getSearchKeywordService;
	
	@RequestMapping(value="/getSearchKeyword.udo" , method=RequestMethod.GET, produces = "application/text;charset=utf-8")
	@ResponseBody
	public String getSearchKeyword(	@RequestParam(value="searchKeywordStr", required = false)String searchKeyword,
									ProjectVO vo, Model model) throws JsonProcessingException, UnsupportedEncodingException {
		System.out.println(searchKeyword);
		List<ProjectVO> searchList = getSearchKeywordService.getSearchKeyword(searchKeyword);
		model.addAttribute("searchList",searchList);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(searchList);
		
		
		return json;
	}
	

}