package com.team5.funthing.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team5.funthing.user.model.vo.DeliveryAddressVO;
import com.team5.funthing.user.model.vo.MemberVO;
import com.team5.funthing.user.service.deliveryService.GetDeliveryAddressService;
import com.team5.funthing.user.service.deliveryService.InsertDeliveryAddressService;
import com.team5.funthing.user.service.deliveryService.UpdateDeliveryAddressService;

@Controller
public class DeliveryAddressController {
	
	   @Autowired
	   private InsertDeliveryAddressService insertDeliveryAddressService;
	   @Autowired
	   private UpdateDeliveryAddressService updateDeliveryAddressService;
	   @Autowired
	   private GetDeliveryAddressService getDeliveryAddressService;
	   @Autowired
	   private MemberVO memberVo;
	   
	   @RequestMapping(value="insertDeliveryAddress.udo",method =RequestMethod.GET)
	   public String insertDeliveryAddress(DeliveryAddressVO vo,HttpSession session) {
		   memberVo = (MemberVO)session.getAttribute("memberSession");
		   vo.setEmail(memberVo.getEmail());
		   insertDeliveryAddressService.insertDeliveryAddress(vo);
		   return "#";
	   }
	   
	   @RequestMapping(value="updateDeliveryAddress.udo",method=RequestMethod.GET)
	   public String updateDeliveryAddress(DeliveryAddressVO vo,HttpSession session) {
		   memberVo = (MemberVO)session.getAttribute("memberSession");
		   vo.setEmail(memberVo.getEmail());
		   ///   주소정보 관련해서   input태그   해당 vo와 이름맞춘다.   zipcode  address1  address2
		   updateDeliveryAddressService.updateDeliveryAddress(vo);
		   return "#";
	   }
	   
	   @RequestMapping(value="getDeliveryAddress.udo",method=RequestMethod.GET)
	   public String getDeliveryAddress(DeliveryAddressVO vo,HttpSession session){
		   memberVo = (MemberVO)session.getAttribute("memberSession");
		   vo.setEmail(memberVo.getEmail());
		   getDeliveryAddressService.getDeliveryAddress(vo);
		   return "#";
	   }
	
}
