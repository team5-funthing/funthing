<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- header nav right 위치에 들어가면 됨  -->
    
	<div class="col-xl-5 col-lg-3 d-none d-lg-block">
	    <div class="nav_right">
	
	        <div class="search_icon ">
	            <a class="popup-with-form" href="#search-popup" id="search" style="padding:0 10px;">
	            	<span class="fa fa-search fa-2x pr-1"></span>
	            </a>
	        </div>
			
			<script>
				$(document).ready(function(){
					$("i").on('click',function(){
						var id = $(".userId").attr('id');
						$.ajax({
							type:"post",
							url:"getUserAlarmList.udo",
							data:{
								status : 'n',
								receiveId : id
							},
							success:function(data){
								
								console.log(data);
								console.log(typeof(data));
								var trimData = data.trim();
								console.log(trimData.trim());
								$('.fa-bell').popover({title: "알람", content: trimData , html:true, placement: "bottom"});
								if(trimData.trim()=="<ul></ul>"){
									$("#showAlarmState").empty();
									$("#showAlarmState").append("알람 없음").css('font-size','70%');
								}else{
									$("#showAlarmState").empty();
									$("#showAlarmState").append("알람 있음").css('font-size','70%');
								}
							},
							error:function(request,status,error){
								console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
					});
				});
			</script>
			
			<div id="alarmArea" style="width:80px;">
				<span id="showAlarmState" style="width:50px;font-size:70%;">${sessionScope.userAlarmList}</span>
				<a id="${sessionScope.memberSession.email}" class="headerBtn userId" style="padding:0 10px;">
					<i class="far fa-bell fa-2x pr-1"></i>
				</a>
			</div>
	        <div class="d-none d-lg-block pl-3 pr-3">
	            <a type="button" href="#" id="mypage-btn" data-popover="popover-mypage-menu">
	                <img id="gogoimage2" class="profile" src="${sessionScope.memberSession.myImage}"></a>
	        </div>
	    </div>
	</div>