package com.team5.funthing.user.controller;

import java.io.UnsupportedEncodingException;
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
import com.team5.funthing.user.model.vo.KeywordVO;
import com.team5.funthing.user.model.vo.ProjectVO;
import com.team5.funthing.user.service.searchKeywordService.GetKeywordFiveListService;
import com.team5.funthing.user.service.searchKeywordService.GetSearchKeywordByKeywordService;
import com.team5.funthing.user.service.searchKeywordService.GetSearchKeywordService;
import com.team5.funthing.user.service.searchKeywordService.UpdateKeywordCountService;

@Controller
public class SearchKeywordController {
	
	@Autowired
	private GetSearchKeywordService getSearchKeywordService;
	@Autowired
	private UpdateKeywordCountService updateKeywordCountService;
	@Autowired
	private GetKeywordFiveListService getKeywordFiveListService;
	@Autowired
	private GetSearchKeywordByKeywordService getSearchKeywordByKeywordService;
	
	
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
	
	@RequestMapping(value="/getKeywordFiveList.udo" , method=RequestMethod.GET, produces = "application/text;charset=utf-8")
	@ResponseBody
	public String getKeywordFiveList(KeywordVO vo, Model model) throws JsonProcessingException, UnsupportedEncodingException {
		
		List<KeywordVO> keywordFiveList = getKeywordFiveListService.getKeywordFiveList(vo);
		model.addAttribute("keywordFiveList",keywordFiveList);
		
		System.out.println(keywordFiveList.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		String json2 = mapper.writeValueAsString(keywordFiveList);
		
		
		return json2;
	}
	
	
	
	@RequestMapping(value="getSearchKeywordList.udo", method = RequestMethod.GET)
	public String getSearchKeywordList(@RequestParam(value="searchKeywordStr", required = false)String searchKeyword,
										ProjectVO vo, Model model) {
		
		updateKeywordCountService.updateKeywordCount(searchKeyword); //업데이트 키워드 (키워드 카운트+1)
		
		List<ProjectVO> getAllFundingProjectList = getSearchKeywordService.getSearchKeyword(searchKeyword);
		List<ProjectVO> getAllFundingProjectListByKeyword = getSearchKeywordByKeywordService.getSearchKeywordByKeyword(searchKeyword);
		
		for(ProjectVO pvo : getAllFundingProjectListByKeyword) {
			getAllFundingProjectList.add(pvo);
		}
		
		model.addAttribute("getAllFundingProjectList",getAllFundingProjectList);
		

		return "p-project-list";
		
	}
	
	
	@RequestMapping(value="getClickKeywordList.udo", method = RequestMethod.GET)
	public String getClickKeywordList(@RequestParam(value="searchKeywordStr", required = false)String searchKeyword,
										ProjectVO vo, Model model) {
		System.out.println("searchKeyword :" + searchKeyword);
		updateKeywordCountService.updateKeywordCountShap(searchKeyword);
		List<ProjectVO> getAllFundingProjectList = getSearchKeywordByKeywordService.getSearchKeywordByKeywordShap(searchKeyword);
			
		model.addAttribute("getAllFundingProjectList",getAllFundingProjectList);
		

		return "p-project-list";
		
	}
	
	
}
