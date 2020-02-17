<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글입력창</title>
</head>
<body>
	<form action="insertprojectBoard.udo" method="get">
		<div>
			<h2>글쓰기</h2>
		</div>
		<div>
			<h5>이름</h5>
			<input type="text" name="name"  value="${sessionScope.memberSessionName}" readonly></input>
		</div>
		<div>
			<h5>이메일</h5>
			<input type="hidden" name="email" value="${sessionScope.memberSessionEmail}" ></input>
		</div>
		<div>
			<h5>내용</h5>
			<input type="text" name="projectboardcontents" ></input>
		</div>
		
	
		<div>
			<input type="submit" value="완료"> </input>
		</div>
		<hr>
	</form>

</body>
</html>