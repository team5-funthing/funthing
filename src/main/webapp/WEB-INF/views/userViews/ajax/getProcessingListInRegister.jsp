<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="processing" items="${ProcessingList}">
	<div>${processing.infoTitle}</div><br>
	<div>${processing.infoContent}</div><br>
</c:forEach>
