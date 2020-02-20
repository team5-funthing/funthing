<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글입력창</title>
</head>
<body>
	<!-- 새글달기 입력창 -->
		<c:choose>
			<c:when test="${ vo.email eq null }">
				<form action="insertProjectBoard.udo" method="post">
					<table border="1" width="500px">
					<tr>
						<th>이름</th>
						
						<td>${sessionScope.memberSessionName }		
						<input type="hidden" name="email" value="${sessionScope.memberSessionEmail }"  >
						
						</td>
					</tr>
					<tr>
						<th>내용</th>
							<td><input type="text" name="projectBoardContents" value="${vo.projectBoardContents}"></td>
					</tr>			
					<tr>
						<td colspan="2">
							<input  type="submit" value="완료"></input>
						</td>
					</tr>
				</table>
			</form>		
			
				</c:when>
				<c:when test="${ vo.projectBoardNo ne -1 }">
				<form action="updateProjectBoard.udo" method="post">
					<table border="1" width="500px">
					<tr>
						<th>이름</th>

						<td>${ sessionScope.memberSessionName } 
						<input type="hidden" name="projectBoardNo" value="${vo.projectBoardNo}"  >
										
						</td>
					</tr>
					<tr>
						<th>내용</th>
							<td><input type="text" name="projectBoardContents" value="${vo.projectBoardContents}" ></td>
					</tr>			
					<tr>
						<td colspan="2">
							<input  type="submit" value="수정"></input>
						</td>
					</tr>
					</table>
			</form>		
				</c:when>

			</c:choose>
				


		
		

</body>
</html>