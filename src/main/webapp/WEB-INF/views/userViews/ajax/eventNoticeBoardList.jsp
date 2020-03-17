<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tab-pane fade show active" id="nav-event" role="tabpanel" aria-labelledby="nav-event-tab">
	<c:forEach var="list" items="${eventNoticeList}">
		<div class="h4">
			<p>공지 알림 [뱃지 형식]</p>
			<a href="getNoticeBoard.udo?noticeNo=${list.noticeNo}">${list.noticeTitle }</a>
			<p>${list.adminId }</p>
			<p>${list.noticeDate }</p>
		</div>
		<hr>
	</c:forEach>
</div>