<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul><c:forEach var="alarm" items="${userNewestAlarmList}">
	<li><a href="alarmPaging.udo?alarmNo=${alarm.alarmNo}&alarmType=${alarm.alarmType}">${alarm.alarmType} : ${alarm.detailAlarmType}</a></li><hr>
</c:forEach></ul>