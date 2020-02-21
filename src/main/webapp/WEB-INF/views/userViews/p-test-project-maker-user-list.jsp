<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메이커와 일반유저 분리 리스트</title>
</head>
<body>
	<form action="getEntireMakerMessageList.udo" method="post">
		<input type="submit" value="메이커에게 온 문의리스트" >
		<input type="submit" formaction="getEntireProjectAskMessageList.udo" value="내가 보낸 문의리스트" >
		<input type="hidden" name="email" value="${sessionScope.memberSessionEmail}">
	</form>
</body>
</html>