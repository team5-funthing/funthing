<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   
<!doctype html>

<html class="no-js" lang="zxx">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
</head>

<body>
	
	<c:if test="${msg ne null }">
    	<script>
    		alert("${msg }");
    	</script>
    </c:if>

  	
    <jsp:include page="./include/i-popupover-mypage.jsp"/> 
    <jsp:include page="./include/i-header.jsp"/> 
     
     
    <!-- 회원가입 선택 폼 양식 start -->
    <div class="wrap">
        <div class="container ">
            <div class="row ">
                <div class="col">
                </div>
                <div class="col align-self-center">
                    <form id="startProjectForm" action="showCreateProjectBasicForm.udo" method="GET">
                        <hr>
                        <input type="hidden" name="email" value="${member.email }">
                        <div class="col-xl-12 mt-10 d-flex justify-content-center">
                            <a class="btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                href="#" onclick="document.getElementById('startProjectForm').submit();">
                                	시작하기</a>
                        </div>
                        <hr>
                    </form>

                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
    <!-- 회원가입 폼 end -->
 	

    <footer class="footer">
    </footer>
    
     <jsp:include page="./include/i-popup-login.jsp"></jsp:include> 
	 <jsp:include page="./include/i-popup-search.jsp"></jsp:include> 
     <jsp:include page="./include/i-body-js.jsp"></jsp:include> 
    
</body>
</html>