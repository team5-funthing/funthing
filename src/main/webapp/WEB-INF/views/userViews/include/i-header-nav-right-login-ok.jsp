<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- header nav right 위치에 들어가면 됨  -->
    
	<div class="col-xl-5 col-lg-3 d-none d-lg-block">
	    <div class="nav_right">
	
	        <div class="search_icon ">
	            <a class="popup-with-form" href="#search-popup">
	                <i class="fa fa-search fa-2x pr-1"></i>
	            </a>
	        </div>
	
	
	        <div class="pl-3">
	            <a class="popup-with-form" href="#">
	                <i class="far fa-bell fa-2x pr-1"></i>
	            </a>
	        </div>
	
	        <div class="pl-3">
	            <i class="far fa-envelope fa-2x pr-2"></i>
	        </div>
	
	        <div class="d-none d-lg-block pl-3 pr-3">
	            <a type="button" href="#" id="mypage-btn" data-popover="popover-mypage-menu">
	                <img class="profile" src="${sessionScope.memberSession.myImage }"></a>
	        </div>
	    </div>
	</div>