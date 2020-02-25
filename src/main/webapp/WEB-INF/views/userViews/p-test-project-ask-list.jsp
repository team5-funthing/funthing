<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의내역 전체 보여주기</title>
</head>
<body>
	
		<form id="messageForm"method="post">
			<table border="1" >
				<tr>
					<td>문의번호</td>
					<td style="width: 130px;">고객아이디</td>
					<td style="width: 130px;">문의업체</td>
					<td style="width: 250px;">문의제목</td>
					<td style="width: 250px;">문의날짜</td>
					<td>답변날짜</td>
					<td>답변상태</td>
					
				</tr>
				<c:forEach var="messagelist" items="${messagelist}">
				<tr>
					<td>${messagelist.projectAskNo }</td>
					<td>${messagelist.email }</td>
					<td>${messagelist.creator}</td>
					<td><a href="getChoiceProjectAskMessage.udo?projectAskNo=${messagelist.projectAskNo }">${messagelist.projectAskContentsTitle}</a></td>
					<td>${messagelist.projectAskDate}</td>
					<td>${messagelist.projectAskReplyDate}</td>
					<td>${messagelist.projectAskReplyStatus}</td>
				</tr>
		
				</c:forEach>
			</table>
		</form>
	
</body>
</html>