<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의내용 입력</title>
</head>
<body>

	<form action="insertProjectAskContents.udo" method="post">
		<table border="1" width="500px">
			<tr>
				<td>문의업체</td>
				<td><input type="text" name="creator" value="${vo.creator }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${sessionScope.memberSession.name }</td>
				<input type="hidden" name="email" value="${sessionScope.memberSession.email }"  >
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="projectAskContentsTitle" ></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="projectAskContents" ></td>
			</tr>
			<tr>
				<td colspan="2">
							<input  type="submit" value="문의하기"></input>
			</tr>
		</table>
	</form>
	

</body>
</html>