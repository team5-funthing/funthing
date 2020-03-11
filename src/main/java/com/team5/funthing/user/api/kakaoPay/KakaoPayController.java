//package com.team5.funthing.user.api.kakaoPay;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import lombok.Setter;
//import lombok.extern.java.Log;
//
////@Controller
////@Log
//public class KakaoPayController {	
//
//	@Setter(onMethod_ = { @Autowired })
//	private KakaoPayService kakaoPayService;
//	
//	@GetMapping("/kakaoPay")
//	public void kakaoPayGet() {
//	}
//	
//	@PostMapping("/kakaoPay")
//	public String kakaoPay() {
//        log.info("kakaoPay post............................................");
//        
//        return "redirect:";
//	}
//	
//	@GetMapping("/kakaoPaySuccess")
//	public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
//        log.info("kakaoPaySuccess get............................................");
//        log.info("kakaoPaySuccess pg_token : " + pg_token);
//        
//        
//        // 여기서 결과 페이지로 가야한다. 또는 나머지 db추가 셋팅 서비스가 실행
//        model.addAttribute("info", kakaoPayService.kakaoPayInfo(pg_token));
//        
//	}
//	
////	@RequestMapping(value = "kakaoPaySuccess.udo", method = RequestMethod.GET)
////	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
////        log.info("kakaoPaySuccess get............................................");
////        log.info("kakaoPaySuccess pg_token : " + pg_token);
////        
////        model.addAttribute("info", kakaoPayService.kakaoPayInfo(pg_token));
////        
////        return "kakaoPaySuccess";
////	}
////	
//	
//	
//}
