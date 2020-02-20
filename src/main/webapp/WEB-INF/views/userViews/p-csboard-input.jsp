<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html class="no-js" lang="zxx">

<head>

<jsp:include page="./include/i-head-setting.jsp" />

</head>

<body>


	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />
	<hr>
	<article class="d-flex justify-content-center">
		<div class="h2 p-5">고객센터 문의</div>
	</article>
	<hr>
	
	<form method="POST" action="insertCSBoard.udo">
	<input type="hidden" name="email" value="jungho.p47@gmail.com">
	
	<div align="center">
		제목이구요<input type="text" name="csTitle"
			style="margin: 3%; padding-left: 5px; padding-right: 5px;">
	</div>
	<div align="center">
		내용입니다 </br>
		<textarea rows="20" cols="100" style="padding: 10px;" name="csContent" placeholder="문의내용"></textarea>
		<p></p>
	</div>
	
	
		<div align="center">
			<input type="submit" value="등록"></a>
			<a href="#"><input type="button" value="취소"></a>
		</div>
	</form>
		</br>
	


	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>