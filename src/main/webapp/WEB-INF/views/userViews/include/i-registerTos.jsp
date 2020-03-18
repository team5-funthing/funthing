<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="registerTos">
<h1>회원가입약관</h1>
funthing 회원가입과 관련하여 필요한 사항을 규정합니다.
</div>
<ul id="registerTosTitleList">
<c:forEach var="registerTos" items="${getRegisterTosList}">
	<li><a href="#registerTosNo${registerTos.registerNo}">${registerTos.registerTosTitle}</a></li>
</c:forEach>
</ul>

<hr>
<c:forEach var="registerTos" items="${getRegisterTosList}">
<div id="registerTosNo${registerTos.registerNo}">
	<h3>${registerTos.registerTosTitle}</h3>
	<div>${registerTos.registerTosContent}</div>
</div>
</c:forEach>