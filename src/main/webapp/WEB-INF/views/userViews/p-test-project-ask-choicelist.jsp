<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
	<form action="getEntireProjectAskMessageList.udo" method="post">
		<table border="1" >
			<tr>
				<td>문의번호</td>
				<td><input type="text" name="projectAskNo" value="${choiceProjectAskMessage.projectAskNo }"></td>
			</tr>
			<tr>
				<td>문의업체</td>
				<td><input type="text" name="creator" value="${choiceProjectAskMessage.creator }"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="email" value="${choiceProjectAskMessage.email }"></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td>${choiceProjectAskMessage.projectAskDate }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="projectAskContentsTitle" value="${choiceProjectAskMessage.projectAskContentsTitle }" ></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="projectAskContents" value="${choiceProjectAskMessage.projectAskContents }"></td>
			</tr>
			
		</table>
		
		<table border="1" >
			
			<tr>
				<td>답변업체</td>
				<td><input type="text" name="creator" value="${choiceProjectAskMessage.creator }"></td>
			</tr>
			<tr>
				<td>답변제목</td>
				<td><input type="text" name="projectAskReplyContentsTitle" value="${choiceProjectAskMessage.projectAskReplyContentsTitle }" ></td>
			</tr>
			<tr>
				<td>답변내용</td>
				<td><input type="text" name="projectAskReplyContents" value="${choiceProjectAskMessage.projectAskReplyContents }"></td>
				<input type="hidden" name="projectAskReplyStatus" value="답변완료">
			</tr>
			
		</table>
			<c:if test="${sessionScope.makerCreator ne null }">
				<tr>
					<td colspan="2">
							<input  type="submit" formaction="updateProjectAskReplyContentsStatus.udo" value="답변완료"></input>
				</tr>
			</c:if>
			<tr>
				<td colspan="2">
							<input  type="submit" value="목록으로 돌아가기"></input>
			</tr>
		
	</form>
</body>
</html>