<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
  <c:if test="${AdminNewestAlarmList eq '[]'}">
     <li>알림이 없습니다.</li>
  </c:if>
  <c:forEach var="alarmList" items="${AdminNewestAlarmList}">
     <li><a href="alarmPaging.udo?alarmNo=${alarmList.alarmNo}">${alarmList.alarmType}</a></li>
  </c:forEach>
</ul>