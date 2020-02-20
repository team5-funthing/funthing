<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post">
   	<input type ="hidden" id="projectno" name="projectno" value="${param.projectno}"><!-- 넘어온  프로젝트 번호 값  받아서 쓰기. -->

   <label>은행 선택</label>
   	<input type="text" id="projectBank" name="projectBank" >
   	
   <label>예금주</label>
   	<input type="text" id="projectAccountName" name="projectAccountName">
   	
   <label>계좌번호</label>
   	<input type="text" id="projectAccount" name="projectAccount">
   	
   <label>통장사본</label>
   	<input id="bankBookImg" name="bankBookImg" type="file" formenctype="multipart/form-data">
   	<br>
   	
   	<input type="submit" formaction="" value="사진 저장"> 
   	
   	<br>
   	<br>
   	
   	<input type="submit" formaction="insertOrUpdateProjectAccountInformation.udo" value="등록/수정"> 
   	
   </form>
  
</body>
</html>