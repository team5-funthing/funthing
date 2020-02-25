<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판글목록</title>
</head>
<body>
	<h1>
	메이커에게 문의하기 
	<form action="insertNewAskMessage.udo" method="post">
	<input type="submit" value="문의글작성하기">
	</form>
	</h1>

	<h1>
	게시판
	<form action="insertNewBoard.udo" method="post">
	<input type="submit" name="newText" value="새글작성">
	</form>
	</h1>
	
	<!-- 밑에 메이커 이부분 바꿔주기 지금 잠시 메이커로 설정한거고 메이커 구별하는 로직 만들기  -->
	<c:forEach var="board" items="${list}">
		<form action="getProjectBoard.udo" method="post">
			<table border="1" width="500px">
				<tr>
					<th>이름</th>
					<td>${board.member.name }<input type="hidden" name="email" value="${board.email}"></td>
					<th>날짜</th>
					<td>${board.projectBoardDate}<input type="hidden" name="projectBoardNo" value="${board.projectBoardNo}"></td>

				</tr>

				<tr>
					<th>내용</th>
					<td colspan="4" height="200">${board.projectBoardContents}</td>
				</tr>

				<!-- 만약 이메일이 같지않으면 버튼 생성이 안되야된다. -->
				<c:choose>
					<c:when test="${ board.email eq sessionScope.memberSessionEmail }">
						<tr>
							<td colspan="5"><input type="submit" value="수정"></input> 
							<input type="submit" formaction="deleteProjectBoard.udo" value="삭제"></input>

							</td>

						</tr>
					</c:when>


					<c:when test="${ sessionScope.memberSessionPosition eq '메이커' }">
						<tr>
							<td colspan="6"><input type="submit" formaction="replyBoard.udo"
								value="답글"></input></td>

						</tr>
					</c:when>
				</c:choose>

			</table>
		</form>
		<br>

	</c:forEach>



</body>
</html>