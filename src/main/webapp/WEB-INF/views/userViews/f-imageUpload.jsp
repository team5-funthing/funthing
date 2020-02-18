<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="saveimage.udo" method="post" enctype="multipart/form-data">
<input  type="file" id="filename" name="filename" accept="image/*" >
<input type="submit" value="저장">
</form>

</body>
</html>