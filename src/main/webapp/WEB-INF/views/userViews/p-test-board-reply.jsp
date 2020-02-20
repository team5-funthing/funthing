<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<!-- 답글달기 입력창 -->
			
				<form action="insertReplyProjectBoard.udo" method="post">
					<table border="1" width="500px">
					<tr>
						<th>이름</th>
						<td>${ sessionScope.memberSessionName } 
						<input type="hidden" name="ref" value= "${vo.projectBoardNo}"  >
						<input type="hidden" name="email" value="${sessionScope.memberSessionEmail }"  >
						
										
						</td>
					</tr>
					<tr>
						<th>내용</th>
							<td><input type="text" name="projectBoardContents"></td>
					</tr>			
					<tr>
						<td colspan="2">
							<input  type="submit" value="댓글등록"></input>
						</td>
					</tr>
					</table>
				</form>		
				
</body>
</html>