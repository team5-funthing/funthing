<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${AdminNewestAlarmList eq '[]'}"></c:if>  
<c:if test="${AdminNewestAlarmList ne '[]'}">
    <ul style="float:left;padding:5px;list-style:none;font-decoration:none;">
  		<c:forEach var="alarmList" items="${AdminNewestAlarmList}">
     		<li style="padding:5px;list-style:none;font-decoration:none;font-size:80%;">
     			<a href="alarmPaging.udo?alarmNo=${alarmList.alarmNo}&alarmType=${alarmList.alarmType}">${alarmList.alarmType}</a>
     		</li>
     		<hr>
  		</c:forEach>
	</ul>
</c:if>
