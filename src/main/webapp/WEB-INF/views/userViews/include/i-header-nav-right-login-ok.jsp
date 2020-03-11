<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- header nav right 위치에 들어가면 됨  -->
    
	<div class="col-xl-5 col-lg-3 d-none d-lg-block">
	    <div class="nav_right">
	
	        <div class="search_icon ">
	            <a class="popup-with-form" href="#search-popup" id="search"><span
	                    class="fa fa-search fa-2x pr-1"></span></a>
	        </div>
			
			<script>
				$(document).ready(function(){
					$("i").on('click',function(){
						var id = $(".bbb").attr('id');
						$.ajax({
							type:"post",
							url:"getUserAlarmList.udo",
							data:{
								status : 'n',
								receiveId : id
							},
							success:function(data){
								$("#userAlarmList").empty();
								$("#userAlarmList").append(data);							
							},
							error:function(request,status,error){
								console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
					});
				});
			</script>
			
			
			<div class="dropdown">
				<a id="${sessionScope.memberSession.email}" class="dropdown-toggle bbb" data-toggle="dropdown">
					<i class="far fa-bell fa-2x pr-1"></i>
				</a>
				<ul id="userAlarmList" class="dropdown-menu">
					<!--<c:forEach var="alarmList" items="${sessionScope.memberAlarmList}">
						<li><a href="alarmPaging.udo?alarmNo=${alarmList.alarmNo}&alarmType=${alarmList.alarmType}">${alarmList.alarmType}</a></li>
					</c:forEach>-->
				</ul>
			</div>
			<script>
				$(document).ready(function(){
  					$(".dropdown-toggle").dropdown();
				});
			</script>
	
	        <div class="pl-3">
	            <i class="far fa-envelope fa-2x pr-2"></i>
	        </div>
	
	        <div class="d-none d-lg-block pl-3 pr-3">
	            <a type="button" href="#" id="mypage-btn" data-popover="popover-mypage-menu">
	                <img id="gogoimage2" class="profile" src="${sessionScope.memberSession.myImage }"></a>
	        </div>
	    </div>
	</div>