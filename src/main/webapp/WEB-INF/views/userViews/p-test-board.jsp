<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판글목록</title>
</head>
<body>
	<c:forEach var = "list" items = "${List}">
		<h4>포지션</h4>
			${list.position}<br>
		<h4>내용</h4>
			${list.projectboardcontents}<br>
		<h4>날짜</h4>
			${list.projectboarddate}<br>
		<h4>이름</h4>
			${list.member.name }
	</c:forEach>
			
	

</body>
</html>