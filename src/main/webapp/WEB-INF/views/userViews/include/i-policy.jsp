<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="policy">
<h1>funthing 서비스 개인정보처리방침</h1>
funthing은 이용자들의 개인정보를 소중히 다루고 있습니다.

<ul>
<c:forEach var="policyTitle" items="${getPersonalInfoProcessing}">
<li><a href="#policyNo${policyTitle.infoNo}">${policyTitle.infoTitle}</a></li>
</c:forEach>
</ul>
<hr>
<c:forEach var="policy" items="${getPersonalInfoProcessing}">
<div id="policyNo${policy.infoNo}">
	<h3>${policy.infoTitle}</h3>
	<div>${policy.infoContent}</div>
</div>
</c:forEach>
</div>