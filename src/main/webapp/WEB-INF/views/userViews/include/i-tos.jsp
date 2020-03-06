<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="tos">
<h1>funthing 서비스 이용 약관</h1>
funthing 리워드 서비스의 이용과 관련하여 필요한 사항을 규정합니다.

<ul id="toslist">
<c:forEach var="tos" items="${getTosList}">
	<li><a href="#tosNo${tos.tosNo}">${tos.tosTitle}</a></li>
</c:forEach>
</ul>

<hr>
<c:forEach var="tos" items="${getTosList}">
<div id="tosNo${tos.tosNo}">
	<h3>${tos.tosTitle}</h3>
	<div>${tos.tosContent}</div>
</div>
</c:forEach>
</div>